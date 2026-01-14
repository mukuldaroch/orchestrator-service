## orchestrator.dto.eventservice.request

1. **EventServiceCreateEventRequest.java**

| Column1         | Column2        |
| --------------- | -------------- |
| String          | name           |
| String          | venue          |
| EventStatusEnum | status         |
| String          | description    |
| LocalDateTime   | eventStartDate |
| LocalDateTime   | eventEndDate   |
| LocalDateTime   | salesStartDate |
| LocalDateTime   | salesEndDate   |

2. **EventServiceUpdateEventRequest.java**

| Column1         | Column2        |
| --------------- | -------------- |
| UUID            | eventId        |
| String          | name           |
| String          | venue          |
| String          | description    |
| EventStatusEnum | status         |
| LocalDateTime   | eventStartDate |
| LocalDateTime   | eventEndDate   |
| LocalDateTime   | salesStartDate |
| LocalDateTime   | salesEndDate   |

## orchestrator.dto.eventservice.response

1. **EventServiceCreateEventResponse.java**

| Column1         | Column2        |
| --------------- | -------------- |
| UUID            | eventId        |
| String          | name           |
| String          | venue          |
| String          | description    |
| EventStatusEnum | status         |
| LocalDateTime   | eventStartDate |
| LocalDateTime   | eventEndDate   |
| LocalDateTime   | salesStartDate |
| LocalDateTime   | salesEndDate   |
| LocalDateTime   | createdAt      |
| LocalDateTime   | updatedAt      |

2. **EventServiceUpdateEventResponse.java**

| Column1         | Column2        |
| --------------- | -------------- |
| UUID            | eventId        |
| String          | name           |
| String          | venue          |
| String          | description    |
| EventStatusEnum | status         |
| LocalDateTime   | eventStartDate |
| LocalDateTime   | eventEndDate   |
| LocalDateTime   | salesStartDate |
| LocalDateTime   | salesEndDate   |
| LocalDateTime   | createdAt      |
| LocalDateTime   | updatedAt      |
