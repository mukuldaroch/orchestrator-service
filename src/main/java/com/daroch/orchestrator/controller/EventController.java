package com.daroch.orchestrator.controller;

import com.daroch.orchestrator.dto.api.request.CreateEventRequest;
import com.daroch.orchestrator.dto.api.response.CreateEventResponse;
import com.daroch.orchestrator.service.CreateEventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class EventController {

  private final CreateEventService createEventService;

  @PostMapping
  // @ResponseStatus(HttpStatus.CREATED)
  public CreateEventResponse createEvent(
      @AuthenticationPrincipal Jwt jwt, @Valid @RequestBody CreateEventRequest request) {
    return createEventService.createEvent(jwt, request);
  }
}
