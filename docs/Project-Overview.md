# Project Overview

## Introduction

The Healthcare Appointment Management System is a production-style backend application developed using Spring Boot Microservices.

The application enables patients to register, search for doctors based on specialization, check available appointment slots, and book appointments through a scalable microservices architecture.

Each business capability is implemented as an independent microservice with its own database, following the Database-per-Service design pattern.

The project is designed to demonstrate enterprise backend development using Spring Boot, Spring Cloud, OpenFeign, Eureka Service Discovery, API Gateway, Redis, Resilience4j, Docker, GitHub Actions, and AWS.

---

# Problem Statement

Traditional appointment booking systems often become difficult to scale because all modules are tightly coupled into a single application.

The goal of this project is to demonstrate how a Healthcare Appointment System can be developed using Microservices Architecture, where every business module is independent, scalable, and maintainable.

---

# Objectives

The primary objectives of this project are:

* Develop RESTful APIs using Spring Boot.
* Implement CRUD operations using Spring Data JPA and Hibernate.
* Design a Microservices Architecture.
* Enable Service Discovery using Eureka Server.
* Configure API Gateway for centralized request routing.
* Implement Inter-Service Communication using OpenFeign.
* Improve application performance using Redis Cache.
* Implement fault tolerance using Resilience4j.
* Write Unit and Integration Tests using JUnit 5 and Mockito.
* Containerize services using Docker.
* Build an automated CI/CD pipeline using GitHub Actions.
* Deploy the application on AWS EC2.

---

# System Modules

The application consists of five major services.

## Patient Service

Responsible for managing patient registration and profile information.

Responsibilities:

* Register Patient
* Update Patient
* Delete Patient
* View Patient Details

---

## Doctor Service

Responsible for managing doctor information and schedules.

Responsibilities:

* Register Doctor
* Update Doctor
* Search Doctors
* Maintain Doctor Availability

---

## Appointment Service

Responsible for appointment booking.

Responsibilities:

* Book Appointment
* Cancel Appointment
* Reschedule Appointment
* View Appointment History

---

## API Gateway

Provides a single entry point for all client requests and routes them to the appropriate microservice.

---

## Eureka Discovery Server

Maintains service registration and enables service discovery between microservices.

---

# Scope of the Project

This project focuses on demonstrating enterprise backend development using Spring Boot Microservices.

The application includes distributed service communication, service discovery, centralized routing, caching, fault tolerance, testing, containerization, and cloud deployment.

---

# Expected Outcome

Upon completion, the project will demonstrate a complete enterprise-grade backend application that follows modern software architecture principles and cloud-native development practices.
