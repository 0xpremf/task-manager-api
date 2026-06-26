<div align="center">
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=22&duration=2500&pause=1000&color=58A6FF&center=true&vCenter=true&width=500&lines=task-manager-api;RESTful+Task+Management+API;Spring+Boot+%7C+PostgreSQL+%7C+Docker" alt="Typing SVG" />
<br/>
Show Image
Show Image
Show Image
Show Image

Show Image
Show Image
Show Image
Show Image

<br/>

A production-grade RESTful Task Management API featuring JWT authentication, Redis caching, paginated queries, full Docker support, and automated CI/CD — deployed on Railway.



</div>

⚡ Architecture

┌─────────────────────────────────────────────────────────────────┐
│                          Client                                  │
└──────────────────────────┬──────────────────────────────────────┘
                           │ HTTP
┌──────────────────────────▼──────────────────────────────────────┐
│                    Spring Boot 4.1                               │
│  ┌─────────────┐   ┌──────────────┐   ┌──────────────────────┐  │
│  │  Controller │──▶│   Service    │──▶│    Repository (JPA)  │  │
│  └─────────────┘   └──────┬───────┘   └──────────┬───────────┘  │
│                           │                       │              │
│                    ┌──────▼───────┐    ┌──────────▼───────────┐  │
│                    │    Redis     │    │     PostgreSQL 17     │  │
│                    │   (Cache)    │    │      (Primary DB)     │  │
│                    └──────────────┘   └──────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘


✨ Features

FeatureDetails🔐 JWT AuthenticationStateless auth with Bearer token — register, login, protected routes📦 DTO PatternClean separation of entities and API contracts via ModelMapper✅ Bean Validation@Valid annotations with custom error responses📄 PaginationAll list endpoints support page, size, sort query params⚡ Redis CachingTask lists cached via @Cacheable — reduced DB load on reads🐳 Docker ComposeOne-command local setup (app + PostgreSQL)🚀 CI/CD PipelineGitHub Actions → Railway auto-deploy on push to main📖 Swagger UIInteractive API docs at /swagger-ui.html via SpringDoc OpenAPI🩺 ActuatorHealth & metrics endpoints at /actuator


🛠️ Tech Stack

yamlRuntime:     Java 25 (eclipse-temurin:26-jdk)
Framework:   Spring Boot 4.1
Database:    PostgreSQL 17
Cache:       Redis
ORM:         Spring Data JPA + Hibernate
Build:       Maven
Mapping:     ModelMapper 3.2
Docs:        SpringDoc OpenAPI 2.8 (Swagger UI)
Infra:       Docker · Docker Compose · GitHub Actions · Railway


🚀 Quick Start

Prerequisites


Docker & Docker Compose installed
Java 25+ (for local dev without Docker)


Run with Docker Compose

bash# 1. Clone the repository
git clone https://github.com/0xpremf/task-manager-api.git
cd task-manager-api

# 2. Create a .env file
cp .env.example .env
# Edit .env with your values

# 3. Start the app + PostgreSQL
docker-compose up --build

# API is live at http://localhost:8421
# Swagger UI at http://localhost:8421/swagger-ui.html

Environment Variables

envPOSTGRES_DB=taskmanager
POSTGRES_USER=your_user
POSTGRES_PASSWORD=your_password
DB_URL=jdbc:postgresql://postgres:5432/taskmanager
DB_USERNAME=your_user
DB_PASSWORD=your_password
JWT_SECRET=your_jwt_secret_key


📡 API Endpoints

Auth

MethodEndpointDescriptionPOST/api/auth/registerRegister a new userPOST/api/auth/loginLogin and receive JWT token

Tasks


All task endpoints require Authorization: Bearer <token> header



MethodEndpointDescriptionGET/api/tasksGet all tasks (paginated)GET/api/tasks/{id}Get task by IDPOST/api/tasksCreate a new taskPUT/api/tasks/{id}Update a taskDELETE/api/tasks/{id}Delete a task

Example Request

bash# Register
curl -X POST http://localhost:8421/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username": "prem", "email": "prem@example.com", "password": "secret123"}'

# Create a task
curl -X POST http://localhost:8421/api/tasks \
  -H "Authorization: Bearer <your_jwt_token>" \
  -H "Content-Type: application/json" \
  -d '{"title": "Build rate limiter", "description": "Implement token bucket algorithm", "status": "TODO"}'


🗂️ Project Structure

src/
└── main/
    └── java/com/example/TaskManager/
        ├── controller/       # REST controllers
        ├── service/          # Business logic
        ├── repository/       # Spring Data JPA repos
        ├── model/            # JPA entities
        ├── dto/              # Request/Response DTOs
        ├── config/           # Security, Redis, OpenAPI config
        └── exception/        # Global exception handling


🐳 Docker

dockerfileFROM eclipse-temurin:26-jdk
WORKDIR /app
COPY target/*.jar task-manager.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "task-manager.jar"]

The docker-compose.yml wires the app (port 8421) and PostgreSQL 17 together with a named volume for data persistence.


⚙️ CI/CD Pipeline

Push to main
     │
     ▼
GitHub Actions
  ├── mvn test
  ├── mvn package
  └── Deploy to Railway ──▶ Live on Railway

Every push to main triggers a build, runs tests, packages the JAR, and auto-deploys to Railway.


📖 API Documentation

Swagger UI is available at:

http://localhost:8421/swagger-ui.html

Or on the live Railway deployment — browse and test all endpoints interactively without needing a client.


<div align="center">
Built by @0xpremf

Show Image

</div>
