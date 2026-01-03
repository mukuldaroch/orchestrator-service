package com.daroch.orchestrator.dto.api.response;

import com.daroch.orchestrator.dto.common.enums.EventStatusEnum;
import com.daroch.orchestrator.dto.ticketservice.response.TicketServiceCreateTicketTypeResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventResponse {

  private UUID eventId;
  private String name;
  private String venue;
  private String description;
  private EventStatusEnum status;
  private LocalDateTime EventStartDate;
  private LocalDateTime EventEndDate;
  private LocalDateTime salesStartDate;
  private LocalDateTime salesEndDate;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private List<TicketServiceCreateTicketTypeResponse> ticketTypes;
}
