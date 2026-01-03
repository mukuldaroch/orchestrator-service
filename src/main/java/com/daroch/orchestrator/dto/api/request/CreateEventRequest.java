package com.daroch.orchestrator.dto.api.request;

import com.daroch.orchestrator.dto.common.enums.EventStatusEnum;
import com.daroch.orchestrator.dto.ticketservice.request.TicketServiceCreateTicketTypeRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventRequest {

  @NotBlank(message = "Event name is required")
  private String name;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  @NotBlank(message = "venue information are required")
  private String venue;

  private LocalDateTime salesStartDate;

  private LocalDateTime salesEndDate;

  @NotNull(message = "Event status is required")
  private EventStatusEnum status;

  private List<TicketServiceCreateTicketTypeRequest> ticketTypes;
}
