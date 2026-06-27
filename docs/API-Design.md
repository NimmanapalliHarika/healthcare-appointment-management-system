#Patient Service
POST /patients

GET /patients

GET /patients/{id}

PUT /patients/{id}

DELETE /patients/{id}

#Doctor Service
POST /doctors

GET /doctors

GET /doctors/{id}

PUT /doctors/{id}

DELETE /doctors/{id}

GET /doctors/specialization/{specialization}

GET /doctors/{id}/available-slots

#Appointment Service
POST /appointments

GET /appointments

GET /appointments/{id}

PUT /appointments/{id}

DELETE /appointments/{id}

GET /appointments/patient/{patientId}

GET /appointments/doctor/{doctorId}
