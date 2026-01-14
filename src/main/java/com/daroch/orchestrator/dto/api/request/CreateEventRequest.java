package com.daroch.orchestrator.dto.api.request;

import com.daroch.orchestrator.dto.common.enums.EventStatusEnum;
import com.daroch.orchestrator.dto.ticketservice.tickettype.request.TicketServiceCreateTicketTypeRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventRequest {

  @NotBlank(message = "Event name is required")
  private String name;

  @NotBlank(message = "venue information are required")
  private String venue;

  @NotNull(message = "Event status is required")
  private EventStatusEnum status;

  private LocalDateTime eventStartDate;
  private LocalDateTime eventEndDate;
  private LocalDateTime salesStartDate;
  private LocalDateTime salesEndDate;

  private List<TicketServiceCreateTicketTypeRequest> ticketTypes;
}
