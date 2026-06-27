# System Requirements Specification (SRS)

## 1. Introduction

The Healthcare Appointment Management System is designed to simplify the appointment booking process between patients and doctors using a Microservices Architecture.

The application enables patients to register, search doctors based on specialization, check doctor availability, and schedule appointments through secure REST APIs.

Each business module is implemented as an independent microservice with its own database to ensure scalability, maintainability, and fault isolation.

---

# 2. System Users

The system supports two primary users.

## 2.1 Patient

A patient can:

- Register into the system.
- View personal profile.
- Update profile information.
- Search doctors by specialization.
- View available appointment slots.
- Book appointments.
- Cancel appointments.
- View appointment history.

---

## 2.2 Doctor

A doctor can:

- Register into the system.
- Update profile information.
- Manage available schedules.
- View booked appointments.
- Update consultation fees.

---

# 3. Functional Requirements

## Patient Service

The Patient Service shall:

- Register new patients.
- Retrieve patient information.
- Update patient details.
- Delete patient records.
- Validate patient information before saving.

---

## Doctor Service

The Doctor Service shall:

- Register doctors.
- Update doctor information.
- Maintain doctor specialization.
- Manage doctor schedules.
- Search doctors by specialization.
- Return available appointment slots.

---

## Appointment Service

The Appointment Service shall:

- Book appointments.
- Cancel appointments.
- Reschedule appointments.
- Retrieve appointment history.
- Validate patient existence.
- Validate doctor availability.
- Prevent duplicate appointment booking.

---

# 4. Business Rules

The system shall enforce the following business rules.

- Every patient shall have a unique Patient ID.
- Every doctor shall have a unique Doctor ID.
- Every appointment shall have a unique Appointment ID.
- Appointment booking shall be allowed only during available doctor slots.
- Patients cannot book appointments in the past.
- A doctor cannot have two appointments at the same time.
- Cancelled appointment slots become available again.
- Each microservice owns its own database.
- No microservice shall directly access another service's database.

---

# 5. Non-Functional Requirements

The application shall satisfy the following non-functional requirements.

## Performance

- Frequently accessed doctor information shall be cached using Redis.

## Scalability

- The application shall follow a Microservices Architecture.

## Reliability

- Service failures shall be handled using Resilience4j Circuit Breaker.

## Availability

- Services shall register with Eureka Discovery Server.

## Communication

- Services shall communicate using OpenFeign.

## Routing

- All client requests shall pass through API Gateway.

## Testing

The project shall include:

- Unit Testing
- Integration Testing
- API Testing

using JUnit 5 and Mockito.

## Deployment

The application shall support:

- Docker
- GitHub Actions CI/CD
- AWS EC2 Deployment

---

# 6. Assumptions

- Every patient is identified using a unique Patient ID.
- Every doctor belongs to one specialization.
- Appointment duration is fixed to 30 minutes.
- A doctor may have multiple available slots per day.
- Patients can only book one appointment for the same doctor at the same time.

---

# 7. Future Enhancements

The system can be extended with:

- Email Notifications
- SMS Notifications
- Payment Integration
- JWT Authentication
- Role-Based Authorization
- Kubernetes Deployment
- Monitoring using Prometheus and Grafana
