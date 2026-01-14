package com.daroch.orchestrator.service.client;

import com.daroch.orchestrator.dto.eventservice.request.EventServiceCreateEventRequest;
import com.daroch.orchestrator.dto.eventservice.response.EventServiceCreateEventResponse;
import com.daroch.orchestrator.exception.EventServiceUnavailableException;
import com.daroch.orchestrator.exception.event.EventNotFoundException;
import com.daroch.orchestrator.exception.event.EventServiceFailedException;
import com.daroch.orchestrator.exception.event.EventValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class EventServiceClient {

  private final WebClient webClient;

  public EventServiceClient(WebClient webClient) {
    this.webClient = webClient;
  }

  public EventServiceCreateEventResponse createEvent(
      Jwt jwt, EventServiceCreateEventRequest request) {

    try {
      return webClient
          .post()
          .uri("http://localhost:8083/events")
.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt.getTokenValue())
          .bodyValue(request)
          .retrieve()

          // 4xx — client & business errors
          .onStatus(
              status -> status.value() == 400,
              r -> Mono.error(new EventValidationException("Invalid event request")))
          .onStatus(
              status -> status.value() == 404,
              r -> Mono.error(new EventNotFoundException("Event not found")))

          // 5xx — Event Service failed
          .onStatus(
              HttpStatusCode::is5xxServerError,
              r -> r.bodyToMono(String.class).map(EventServiceFailedException::new))
          .bodyToMono(EventServiceCreateEventResponse.class)
          .block();

    } catch (Exception ex) {
      throw new EventServiceUnavailableException("Event service unreachable", ex);
    }
  }
}
