# MarketPulse Sales Service

Spring Boot REST API for managing sales records.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Swagger/OpenAPI
- Maven
- Git

---

## Version 1

### Features
- Create Sales Record
- Get All Sales Records
- Get Sales Record By Id
- Update Sales Record
- Delete Sales Record

---

## Version 2

### Features
- Bean Validation
- Global Exception Handling
- Custom ResourceNotFoundException
- Swagger Documentation

---

## Version 3

### Features
- DTO Layer
- Mapper Layer
- Pagination
- Sorting
- Filtering

---

## Version 4

### Features
- Advanced Search API
- Search By Region
- Search By Status
- Search By Region And Status
- Dynamic Filtering Using Optional Query Parameters

Example:

GET /sales/search?region=Texas

GET /sales/search?status=COMPLETED

GET /sales/search?region=Texas&status=COMPLETED
