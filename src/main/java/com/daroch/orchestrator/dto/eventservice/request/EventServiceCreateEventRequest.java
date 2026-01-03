package com.daroch.orchestrator.dto.eventservice.request;

import com.daroch.orchestrator.dto.common.enums.EventStatusEnum;
import java.time.LocalDateTime;
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
public class EventServiceCreateEventRequest {

  private String name;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private String venue;

  private LocalDateTime salesStartDate;

  private LocalDateTime salesEndDate;

  private EventStatusEnum status;
}
