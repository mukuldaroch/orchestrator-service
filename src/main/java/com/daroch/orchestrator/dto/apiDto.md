## orchestrator.dto.api.request

1. **CreateEventRequest.java**

| Column1                                    | Column2        |
| ------------------------------------------ | -------------- |
| String                                     | name           |
| LocalDateTime                              | eventStartDate |
| LocalDateTime                              | eventEndDate   |
| String                                     | venue          |
| LocalDateTime                              | salesStartDate |
| LocalDateTime                              | salesEndDate   |
| EventStatusEnum                            | status         |
| List<TicketServiceCreateTicketTypeRequest> | ticketTypes    |

##  orchestrator.dto.api.response

1. **CreateEventResponse.java**

| Column1                                     | Column2        |
| ------------------------------------------- | -------------- |
| UUID                                        | eventId        |
| String                                      | name           |
| String                                      | venue          |
| String                                      | description    |
| EventStatusEnum                             | status         |
| LocalDateTime                               | eventStartDate |
| LocalDateTime                               | eventEndDate   |
| LocalDateTime                               | salesStartDate |
| LocalDateTime                               | salesEndDate   |
| LocalDateTime                               | createdAt      |
| LocalDateTime                               | updatedAt      |
| List<TicketServiceCreateTicketTypeResponse> | ticketTypes    |
