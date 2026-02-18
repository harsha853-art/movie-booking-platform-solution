# movie-booking-platform-solution
# Movie Booking Platform – Assignment Solution

## Implemented Scenarios
- Browse theatres running a movie (Read Scenario)
- Book movie tickets (Write Scenario)

## Architecture
Microservice-inspired Spring Boot design with Controller → Service → Repository layers.

## Design Patterns
- Repository Pattern
- DTO Pattern
- Strategy Pattern (PricingService)

## Assumptions
- Payment mocked
- Seat locking conceptual only

## Trade-offs
- Redis/Kafka not implemented due to scope

## Non-Functional Design
- Stateless services for scaling
- Adapter pattern for payment gateway
- OWASP protections via API Gateway (design level)
# 🎬 Movie Booking Platform – Assignment Solution

## 📌 Overview
This project demonstrates a scalable movie ticket booking platform designed using Java Spring Boot.
The solution focuses on architecture thinking, clean design, and implementation of selected read/write scenarios as required in the assignment.

Implemented Features:
✔ Browse theatres running a movie (Read Scenario)
✔ Book movie tickets (Write Scenario)

---

# 🏗️ High-Level Architecture

The platform is designed using a microservice-inspired layered architecture.

Client
|
API Controller Layer
|
Service Layer (Business Logic)
|
Repository Layer (Data Access)
|
Database

Key Architectural Decisions:
- Stateless services for horizontal scalability
- Pricing logic separated from booking logic
- Controller → Service → Repository separation

Future extensibility:
- Booking Service
- Theatre Service
- Payment Service
- Notification Service

---

# 🔗 API Contracts

## 1. Browse Shows (Read Scenario)

GET /shows?movieId={id}&date={yyyy-mm-dd}

Response:
[
{
"theatreId": 1,
"startTime": "14:00",
"price": 200.0
}
]

---

## 2. Book Tickets (Write Scenario)

POST /bookings?showId=1&seats=3

Response:
{
"id": 10,
"showId": 1,
"seats": 3,
"totalPrice": 360.0
}

---

# 🗄️ Data Models

Movie
- id
- name
- language

Theatre
- id
- name
- city

Show
- id
- movieId
- theatreId
- showDate
- startTime
- price

Booking
- id
- showId
- seats
- totalPrice

---

# 🧩 Design Patterns Used

Repository Pattern:
Used for database access via Spring Data JPA repositories.

DTO Pattern:
ShowResponseDTO separates API contract from entity model.

Strategy-like Pattern:
PricingService encapsulates discount logic:
- 50% discount on third ticket
- Afternoon show 20% discount

Layered Architecture:
Controller → Service → Repository ensures separation of concerns.

---

# ⚙️ Non-Functional Requirements (Design Level)

## Scalability
- Stateless REST services allow horizontal scaling.
- Future Redis caching can reduce database load.
- Microservice architecture enables independent scaling.

## Availability
- Services can be deployed across multiple availability zones.
- Blue/Green deployment strategy recommended.
- Health checks via Spring Actuator (future enhancement).

## Security
- API Gateway can enforce JWT authentication.
- Input validation prevents injection attacks.
- HTTPS communication recommended.

## Payment Integration
Payment integration designed using Adapter Pattern.

Example:
PaymentGateway
├ RazorpayAdapter
├ StripeAdapter
└ PayUAdapter

Current implementation mocks payment for simplicity.

---

# 📈 Assumptions

- Seat locking is conceptual and not implemented using Redis.
- Payment gateway is mocked.
- H2 database used for demo simplicity.

---

# ⚖️ Trade-offs

- Event-driven architecture explained conceptually but Kafka not implemented.
- Distributed locking avoided to keep scope minimal.

---

# 🚀 Future Enhancements

- Redis-based seat locking
- Kafka event streaming
- Multi-region deployment
- Real payment gateway integration


