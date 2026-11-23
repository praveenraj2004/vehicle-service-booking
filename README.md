# Vehicle Service Booking & Tracking System

## 1. Project Overview

The **Vehicle Service Booking & Tracking System** is a Spring Boot REST API application designed to manage vehicle service bookings.

Customers can create service bookings, view booking details, update booking information, track service status, and retrieve completed service revenue.

The application uses MySQL as its database and Spring Data JPA for database operations.

## 2. Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Jakarta Bean Validation
- Eclipse IDE
- Postman

## 3. Features

- Create a new vehicle service booking.
- Retrieve all bookings.
- Retrieve a booking using its ID.
- Update existing booking details.
- Delete a booking.
- Filter bookings by service status.
- Search bookings using vehicle number.
- Calculate total revenue from completed bookings.
- Find bookings above a specified service cost.
- Validate incoming booking data.
- Handle exceptions globally.

## 4. Booking Details

Each service booking contains the following fields:

| Field | Description |
|---|---|
| bookingId | Unique booking ID |
| customerName | Customer name |
| vehicleNumber | Vehicle registration number |
| vehicleType | Type of vehicle |
| serviceType | Required service |
| bookingDate | Service booking date |
| serviceCost | Service cost |
| status | Current booking status |

### Booking Status

The application supports four booking statuses:

- `BOOKED`
- `IN_PROGRESS`
- `COMPLETED`
- `CANCELLED`

## 5. Project Architecture

The application follows a layered architecture.

```text
com.example.vehicle_service_booking
|
|-- controller
|   |-- ServiceBookingController.java
|
|-- service
|   |-- ServiceBookingService.java
|   |-- ServiceBookingServiceImpl.java
|
|-- repository
|   |-- ServiceBookingRepository.java
|
|-- entity
|   |-- ServiceBookingEntity.java
|   |-- BookingStatus.java
|
|-- dto
|   |-- ServiceBookingDTO.java
|   |-- ServiceBookingDTOImpl.java
|
|-- exception
|   |-- BookingNotFoundException.java
|   |-- GlobalExceptionHandler.java
|
|-- VehicleServiceBookingApplication.java
```

### Layer Responsibilities

- **Controller:** Handles incoming REST API requests and HTTP responses.
- **Service:** Contains business logic.
- **Repository:** Performs database operations using Spring Data JPA.
- **Entity:** Represents database table information.
- **DTO:** Transfers data between the client and application.
- **Exception:** Handles application errors globally.

## 6. Database Configuration

Database: MySQL

Create the database:

```sql
CREATE DATABASE vehicle_service_db;
```

Configure `src/main/resources/application.properties`:

```properties
spring.application.name=vehicle-service-booking

spring.datasource.url=jdbc:mysql://localhost:3306/vehicle_service_db
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080
```

Replace `YOUR_MYSQL_PASSWORD` with your local MySQL password.

**Security:** Do not upload real database passwords or credentials to GitHub. Use environment variables or a local configuration file excluded from Git.

## 7. REST API Documentation

Base URL:

```text
http://localhost:8080
```

| No. | HTTP Method | Endpoint | Description |
|---|---|---|---|
| 1 | POST | `/bookings` | Create a booking |
| 2 | GET | `/bookings` | Retrieve all bookings |
| 3 | GET | `/bookings/{id}` | Retrieve booking by ID |
| 4 | PUT | `/bookings/{id}` | Update booking |
| 5 | DELETE | `/bookings/{id}` | Delete booking |
| 6 | GET | `/bookings/status/{status}` | Filter by status |
| 7 | GET | `/bookings/vehicle/{vehicleNumber}` | Filter by vehicle number |
| 8 | GET | `/bookings/revenue` | Calculate completed booking revenue |
| 9 | GET | `/bookings/cost/above/{amount}` | Find bookings above a cost |

### 7.1 Create Booking

**POST** `/bookings`

Sample request:

```json
{
    "customerName": "Arun Kumar",
    "vehicleNumber": "TN38AB1234",
    "vehicleType": "Car",
    "serviceType": "Full Service",
    "bookingDate": "2026-11-20",
    "serviceCost": 2500.00,
    "status": "BOOKED"
}
```

Expected response: `201 Created`

### 7.2 Get All Bookings

**GET** `/bookings`

Expected response: `200 OK`

### 7.3 Get Booking By ID

**GET** `/bookings/1`

Expected response: `200 OK`

### 7.4 Update Booking

**PUT** `/bookings/1`

Sample request:

```json
{
    "customerName": "Arun Kumar",
    "vehicleNumber": "TN38AB1234",
    "vehicleType": "Car",
    "serviceType": "Engine Service",
    "bookingDate": "2026-11-21",
    "serviceCost": 3500.00,
    "status": "IN_PROGRESS"
}
```

Expected response: `200 OK`

### 7.5 Delete Booking

**DELETE** `/bookings/1`

Expected response: `204 No Content`

### 7.6 Filter by Status

**GET** `/bookings/status/COMPLETED`

Expected response: `200 OK`

### 7.7 Filter by Vehicle Number

**GET** `/bookings/vehicle/TN38AB1234`

Expected response: `200 OK`

### 7.8 Calculate Completed Booking Revenue

**GET** `/bookings/revenue`

Calculates the total service cost of bookings whose status is `COMPLETED`.

Expected response: `200 OK`

### 7.9 Find Bookings Above a Specified Cost

**GET** `/bookings/cost/above/1000`

Retrieves bookings whose service cost is greater than the specified amount.

Expected response: `200 OK`

## 8. Validation

The application uses Jakarta Bean Validation annotations.

| Field | Validation |
|---|---|
| customerName | `@NotBlank` |
| vehicleNumber | `@NotBlank` |
| vehicleType | `@NotBlank` |
| serviceType | `@NotBlank` |
| bookingDate | `@NotNull`, `@FutureOrPresent` |
| serviceCost | `@NotNull`, `@Positive` |
| status | `@NotNull` |

The Controller uses `@Valid` to trigger request validation.

## 9. Exception Handling

Global exception handling is implemented using `@RestControllerAdvice`.

Handled exceptions:

- `BookingNotFoundException` – Returns HTTP 404.
- `MethodArgumentNotValidException` – Returns HTTP 400 for validation failures.

Example error response:

```json
{
    "message": "Service booking not found with ID: 9999"
}
```

## 10. HTTP Response Status Codes

| Status Code | Description |
|---|---|
| 200 | Request successful |
| 201 | Booking created successfully |
| 204 | Booking deleted successfully |
| 400 | Invalid request or validation failure |
| 404 | Booking not found |

## 11. How to Run the Project

### Prerequisites

- Java JDK
- Eclipse IDE
- MySQL Server
- Maven
- Postman

### Steps

1. Clone or download the project.
2. Import the project into Eclipse as an existing Maven project.
3. Create the MySQL database.
4. Configure the database credentials in `application.properties`.
5. Update Maven dependencies.
6. Run `VehicleServiceBookingApplication.java` as a Spring Boot application.
7. Open Postman.
8. Test the REST API endpoints using the base URL.

## 12. Future Enhancements

- Customer authentication and authorization.
- Vehicle service history.
- Service center management.
- Booking status tracking.
- Frontend integration using React.
- Pagination and sorting.
- Automated email notifications.

## 13. Author

Developed as a Spring Boot and MySQL learning project.

---

**Project:** Vehicle Service Booking & Tracking System  
**Backend:** Spring Boot REST API  
**Database:** MySQL