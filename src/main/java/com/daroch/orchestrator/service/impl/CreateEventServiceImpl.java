package com.daroch.orchestrator.service.impl;

import com.daroch.orchestrator.dto.api.request.CreateEventRequest;
import com.daroch.orchestrator.dto.api.response.CreateEventResponse;
import com.daroch.orchestrator.dto.eventservice.request.EventServiceCreateEventRequest;
import com.daroch.orchestrator.dto.eventservice.response.EventServiceCreateEventResponse;
import com.daroch.orchestrator.dto.ticketservice.tickettype.request.TicketServiceCreateTicketTypeRequest;
import com.daroch.orchestrator.dto.ticketservice.tickettype.response.TicketServiceCreateTicketTypeResponse;
import com.daroch.orchestrator.mapper.EventWorkflowMapper;
import com.daroch.orchestrator.service.CreateEventService;
import com.daroch.orchestrator.service.client.EventServiceClient;
import com.daroch.orchestrator.service.client.TicketServiceClient;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateEventServiceImpl implements CreateEventService {

  private final EventServiceClient eventServiceClient;
  private final TicketServiceClient ticketServiceClient;
  private final EventWorkflowMapper mapper;

  @Override
  public CreateEventResponse createEvent(Jwt jwt, CreateEventRequest apiRequest) {

    // 1. API → Event Service DTO
    EventServiceCreateEventRequest eventRequest = mapper.toEventServiceRequest(apiRequest);

    // 2. Call Event Service
    EventServiceCreateEventResponse eventResponse =
        eventServiceClient.createEvent(jwt, eventRequest);

    UUID eventId = eventResponse.getEventId();

    // 3. API + eventId → Ticket Service DTOs
    List<TicketServiceCreateTicketTypeRequest> ticketRequests =
        mapper.toTicketServiceRequests(eventId, apiRequest);

    // 4. Call Ticket Service for each ticket type
    List<TicketServiceCreateTicketTypeResponse> ticketResponses =
        ticketRequests.stream()
            .map(request -> ticketServiceClient.createTicketType(jwt, request))
            .toList();

    // 5. Merge into final API response
    return mapper.toCreateEventResponse(eventResponse, ticketResponses);
  }
}
