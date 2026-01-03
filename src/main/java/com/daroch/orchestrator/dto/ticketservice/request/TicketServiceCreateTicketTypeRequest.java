package com.daroch.orchestrator.dto.ticketservice.request;

import com.daroch.orchestrator.dto.common.enums.TicketTypeStatusEnum;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketServiceCreateTicketTypeRequest {

  @NotNull(message = "eventId is required")
  private UUID eventId;

  private String name;
  private Double price;
  private String description;
  private Integer totalAvailable;
  private TicketTypeStatusEnum status;
}
