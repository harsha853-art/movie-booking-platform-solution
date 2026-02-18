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
