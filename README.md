<div align="center">

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=22&duration=2500&pause=1000&color=58A6FF&center=true&vCenter=true&width=500&lines=task-manager-api;RESTful+Task+Management+API;Spring+Boot+%7C+PostgreSQL+%7C+Docker" alt="Typing SVG" />

<br/>

[![Java](https://img.shields.io/badge/Java_25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://github.com/0xpremf/task-manager-api)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot_4.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://github.com/0xpremf/task-manager-api)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL_17-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://github.com/0xpremf/task-manager-api)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://github.com/0xpremf/task-manager-api)
[![Swagger](https://img.shields.io/badge/Swagger_UI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](https://github.com/0xpremf/task-manager-api)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://github.com/0xpremf/task-manager-api)

<br/>

> A RESTful Task Management API built with Spring Boot 4.1 and PostgreSQL 17. Supports full CRUD, paginated queries, DTO mapping, bean validation, and interactive Swagger docs — fully containerised with Docker Compose.

</div>

---

## ⚡ Architecture

```
┌─────────────────────────────────────────────────────┐
│                      Client                         │
└─────────────────────────┬───────────────────────────┘
                          │ HTTP
┌─────────────────────────▼───────────────────────────┐
│                  Spring Boot 4.1                     │
│                                                     │
│   Controller  ──▶  Service  ──▶  Repository (JPA)  │
│                                         │           │
│                              ┌──────────▼─────────┐ │
│                              │   PostgreSQL 17     │ │
│                              └────────────────────┘ │
└─────────────────────────────────────────────────────┘
```

---

## ✨ Features

| Feature | Details |
|---------|---------|
| 📋 **Full CRUD** | Create, read, update, delete tasks |
| 📄 **Pagination** | All list endpoints support `page`, `size`, and `sort` query params |
| 📦 **DTO Pattern** | Clean separation of entities and API contracts via ModelMapper |
| ✅ **Bean Validation** | `@Valid` on all request bodies with descriptive error responses |
| 📖 **Swagger UI** | Interactive API docs auto-generated via SpringDoc OpenAPI |
| 🩺 **Actuator** | Health and metrics at `/actuator` |
| 🐳 **Docker Compose** | One-command local setup — app + PostgreSQL wired together |

---

## 🛠️ Tech Stack

```yaml
Runtime:    Java 25  (eclipse-temurin:26-jdk)
Framework:  Spring Boot 4.1
Database:   PostgreSQL 17
ORM:        Spring Data JPA + Hibernate
Mapping:    ModelMapper 3.2
Docs:       SpringDoc OpenAPI 2.8  →  /swagger-ui.html
Build:      Maven
Infra:      Docker · Docker Compose
```

---

## 🚀 Quick Start

### Prerequisites

- Docker and Docker Compose installed

### Run with Docker Compose

```bash
# 1. Clone the repo
git clone https://github.com/0xpremf/task-manager-api.git
cd task-manager-api

# 2. Set up environment variables
cp .env.example .env
# Edit .env with your values

# 3. Start the stack
docker-compose up --build
```

App runs at **http://localhost:8421**
Swagger UI at **http://localhost:8421/swagger-ui.html**

### Environment Variables

```env
POSTGRES_DB=taskmanager
POSTGRES_USER=your_user
POSTGRES_PASSWORD=your_password
DB_URL=jdbc:postgresql://postgres:5432/taskmanager
DB_USERNAME=your_user
DB_PASSWORD=your_password
```

---

## 📡 API Endpoints

### Tasks

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/tasks` | Get all tasks (paginated) |
| `GET` | `/api/tasks/{id}` | Get a task by ID |
| `POST` | `/api/tasks` | Create a new task |
| `PUT` | `/api/tasks/{id}` | Update a task |
| `DELETE` | `/api/tasks/{id}` | Delete a task |

### Pagination

All `GET /api/tasks` responses support query parameters:

```
GET /api/tasks?page=0&size=10&sort=createdAt,desc
```

### Example Requests

```bash
# Get all tasks (page 1, 10 per page)
curl http://localhost:8421/api/tasks?page=0&size=10

# Create a task
curl -X POST http://localhost:8421/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title": "Build rate limiter", "description": "Token bucket algorithm", "status": "TODO"}'

# Update a task
curl -X PUT http://localhost:8421/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{"title": "Build rate limiter", "description": "Done!", "status": "DONE"}'

# Delete a task
curl -X DELETE http://localhost:8421/api/tasks/1
```

---

## 🗂️ Project Structure

```
src/main/java/com/example/TaskManager/
├── controller/       # REST controllers
├── service/          # Business logic layer
├── repository/       # Spring Data JPA repositories
├── model/            # JPA entities
├── dto/              # Request / Response DTOs
├── config/           # OpenAPI, ModelMapper config
└── exception/        # Global exception handler
```

---

## 🐳 Docker

```dockerfile
FROM eclipse-temurin:26-jdk
WORKDIR /app
COPY target/*.jar task-manager.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "task-manager.jar"]
```

`docker-compose.yml` wires the Spring Boot app (exposed on port `8421`) with a PostgreSQL 17 container and a named volume for data persistence.

---

## 📖 API Docs

Interactive Swagger UI is available locally at:

```
http://localhost:8421/swagger-ui.html
```

Browse all endpoints, inspect request/response schemas, and test calls directly from the browser — no Postman needed.

---

<div align="center">

Built by [**@0xpremf**](https://github.com/0xpremf)

[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/0xpremf)

</div>
