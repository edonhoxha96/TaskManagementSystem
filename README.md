# 📝 Task Management System (Spring Boot + PostgreSQL)

A full-featured **backend system** for managing users, projects, tasks, and comments — built using **Spring Boot**, **JWT authentication**, and **PostgreSQL**. Designed for use in real-world applications with secure REST APIs and clean architecture.

---

## 🚀 Features

- ✅ User registration & login with secure password hashing (BCrypt)
- 🔐 JWT-based authentication
- 👥 Role-based access (MEMBER, ADMIN, etc.)
- 📁 Project management with user members
- ✅ Task creation, status updates, and assignment
- 💬 Comment system for tasks
- 🔍 Swagger UI integration for API testing
- 🧪 Unit & integration tests with JUnit + MockMvc
- 🐘 PostgreSQL as the database

---

## 📦 Technologies Used

- Java 17
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger (SpringDoc)
- JUnit / Mockito

---

## 📂 Project Structure

- /controller/ → REST controllers
- /service/ → Business logic interfaces + implementations
- /repository/ → JPA repositories
- /entity/ → JPA entities
- /dto/ → Data Transfer Objects
- /security/ → JWT and authentication config
- /config/ → Swagger & other configs
- /TaskManagementSystemApplication.java

---

## 🔐 Authentication

- `POST /api/auth/register` – Register a new user
- `POST /api/auth/login` – Login and receive JWT

---

## 📖 API Docs

After starting the app, access Swagger UI:
http://localhost:8080/swagger-ui.html

---

## 🛠️ Getting Started

### Requirements
- Java 17+
- Maven
- PostgreSQL

### Run Locally

```bash
git clone https://github.com/your-username/task-management-system.git
cd task-management-system

1. Set your DB credentials in application.properties
2. Run the app: ./mvnw spring-boot:run


