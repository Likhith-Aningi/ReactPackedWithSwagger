
# ReactPackedWithSwagger

A full-stack application integrating a React frontend with a Spring Boot backend, packaged into a single executable JAR. This setup includes JWT-based authentication and Swagger UI for API documentation.

## Features

- 🔧 Unified build: React frontend and Spring Boot backend packed into a single JAR
- 🔐 JWT authentication for secure APIs
- 📘 Swagger UI integration for interactive API documentation

## Technologies Used

- **Backend**: Java, Spring Boot, Spring Security, JWT
- **Frontend**: React
- **Build Tools**: Maven, Node.js
- **API Documentation**: Swagger (springdoc-openapi)

## Project Structure

```
ReactPackedWithSwagger/
├── src/
│   └── main/
│       ├── java/           # Backend Java source code
│       └── resources/      # Application properties, static files
├── frontend/               # React frontend application
├── pom.xml                 # Maven build configuration
└── README.md
```

## Getting Started

### Prerequisites

- Java 17 or later
- Node.js (v14+ recommended)
- Maven

### Setup Instructions

1. **Clone the repository**:

   ```bash
   git clone https://github.com/Likhith-Aningi/ReactPackedWithSwagger.git
   cd ReactPackedWithSwagger
   ```

2. **Build the React frontend**:

   ```bash
   cd frontend
   npm install
   npm run build
   cd ..
   ```

   This compiles the React app and places the production files in the `build` directory.

3. **Build the Spring Boot application**:

   ```bash
   mvn clean package
   ```

   This creates a single JAR file including both the backend and frontend builds.

4. **Run the application**:

   ```bash
   java -jar target/ReactPackedWithSwagger-0.0.1-SNAPSHOT.jar
   ```

   The app should be available at `http://localhost:8080`.

## Accessing the Application

- 🌐 **Frontend**: [http://localhost:8080/](http://localhost:8080/)
- 📄 **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Authentication

The application uses JWT (JSON Web Tokens) for authentication.

- **Login Endpoint**: `POST /api/auth/login`
- **Token Format**: `Authorization: Bearer <your-token>`

To access protected endpoints, include the JWT in the `Authorization` header.

## Using Swagger with JWT

1. Go to [Swagger UI](http://localhost:8080/swagger-ui.html)
2. Click **Authorize**
3. Enter your JWT like:  
   ```
   Bearer eyJhbGciOiJIUzI1NiIsInR5cCI...
   ```
