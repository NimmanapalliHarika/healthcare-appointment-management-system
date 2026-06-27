# Database Design

## Database Strategy

The application follows the **Database per Service** pattern.

Each microservice owns its own database.

| Service | Database |
|---------|----------|
| Patient Service | patient_db |
| Doctor Service | doctor_db |
| Appointment Service | appointment_db |

---

# Entity Relationship Diagram

(Insert ER Diagram here)

![ER Diagram](images/er-diagram.png)

---

# Relationships

Patient (1) ------ (*) Appointment

Doctor (1) ------- (*) Appointment

Doctor (1) ------- (*) DoctorSchedule

---

# Design Decisions

- Database per Service pattern
- No cross-database joins
- Communication through REST APIs (OpenFeign)
- Independent scalability
- Loose coupling