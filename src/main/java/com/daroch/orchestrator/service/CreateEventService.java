package com.daroch.orchestrator.service;

import com.daroch.orchestrator.dto.api.request.CreateEventRequest;
import com.daroch.orchestrator.dto.api.response.CreateEventResponse;
import org.springframework.security.oauth2.jwt.Jwt;

public interface CreateEventService {

  CreateEventResponse createEvent(Jwt jwt, CreateEventRequest request);
}
