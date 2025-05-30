# Task Manager

A simple Spring Boot REST API for managing tasks.

## Features

- Create, read, update, and delete tasks
- In-memory storage (no database required)
- OpenAPI documentation (Swagger UI)
- Docker support

## Requirements

- Java 24
- Maven 3.8+
- (Optional) Docker

## Setup

1. **Clone the repository**
`git clone https://github.com/sixthson6/Task-Management-SpringBoot.git`
2. **Build the project**

mvn clean install
3. **Run the application**

   ```bash
   mvn spring-boot:run
4. **Access the API**

    - Base URL: `http://localhost:8080/api/v1/tasks`
    - Swagger UI: `http://localhost:8080/swagger-ui.html`

## Example API Usage

See `task-request.http` for sample HTTP requests.

## Docker

1. **Build Docker image**
2. ```bash
   docker build -t task-manager .
   ```
3. **Run Docker container**
   ```bash
    docker run -p 8080:8080 task-manager
    ```
4. **Access the API in Docker**
5. - Base URL: `http://localhost:8080/api/v1/tasks`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - Example API Usage: See `task-request.http` for sample HTTP requests.
## Contributing
   - Feel free to submit issues or pull requests for improvements or bug fixes.

   
