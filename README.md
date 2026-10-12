# 🩸 Blood Donor Management System — Backend

## 📌 Project Overview

The **Blood Donor Management System** is a web-based application designed to help organize blood donor information and support user authentication.

This repository contains the backend component of the project, developed using **Java and Spring Boot**. It connects to a MySQL database and provides application logic for managing user accounts and donor records.

The project is intended for educational purposes and demonstrates how a Java backend can work with a relational database and a web frontend.

## 🎯 Project Objectives

- Organize blood donor information in a structured database.
- Provide backend functionality for user authentication.
- Support creating, retrieving, and managing donor records.
- Connect a Spring Boot application to a MySQL database.
- Demonstrate a layered application architecture using controllers, services, repositories, and entities.
- Integrate backend functionality with a separate frontend project.

## ✨ Features

### 1. User Authentication
- Backend functionality for user authentication.
- User-related data management.
- Authentication logic organized into dedicated service and controller classes.

### 2. Donor Management
- Donor-related entity and repository classes.
- Backend services for donor management.
- Database integration for storing donor information.

### 3. Database Integration
- MySQL database connectivity.
- Spring Data JPA for database operations.
- Hibernate configuration for entity persistence.
- Configurable database credentials.

### 4. Web Application Integration
- Spring Boot application running on port `8081` by default.
- Static frontend files included in the backend project.
- Support for connecting frontend pages to backend functionality.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Backend programming language |
| Spring Boot | Application framework |
| Spring Web | Web controllers and HTTP endpoints |
| Spring Security | Security configuration |
| Spring Data JPA | Database access and persistence |
| Hibernate | Object-relational mapping |
| MySQL | Relational database |
| Maven | Dependency management and build automation |
| Git and GitHub | Version control and source-code hosting |
| HTML, CSS, JavaScript | Frontend technologies used by the application |

## 🏗️ Project Architecture

The backend follows a layered structure to separate responsibilities.

- **Controller layer:** Handles incoming HTTP requests.
- **Service layer:** Contains application and business logic.
- **Repository layer:** Provides database access.
- **Entity layer:** Represents database-related objects.
- **Configuration classes:** Configure application security and password handling.

Typical request flow:

```text
Frontend
   |
   v
Controller
   |
   v
Service
   |
   v
Repository
   |
   v
MySQL Database
```

## 📂 Project Structure

```text
blood-donor-backend/
├── .mvn/
│   └── wrapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── blooddonor/
│   │   │           └── backend/
│   │   │               ├── BackendApplication.java
│   │   │               ├── DonorController.java
│   │   │               ├── PasswordConfig.java
│   │   │               ├── SecurityConfig.java
│   │   │               ├── User.java
│   │   │               ├── controller/
│   │   │               │   └── AuthController.java
│   │   │               ├── entity/
│   │   │               │   └── Donor.java
│   │   │               ├── repository/
│   │   │               │   ├── DonorRepository.java
│   │   │               │   └── UserRepository.java
│   │   │               └── service/
│   │   │                   ├── AuthService.java
│   │   │                   └── DonorService.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── static/
│   │   │       ├── index.html
│   │   │       └── login.html
│   └── test/
│       └── java/
│           └── com/blooddonor/backend/
│               └── BackendApplicationTests.java
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## ⚙️ Prerequisites

Before running the application, install:

1. **Java Development Kit (JDK)** — use a version compatible with the project configuration.
2. **MySQL Server** — for storing user and donor information.
3. **Git** — optional, for cloning the repository.
4. **Visual Studio Code** or another Java-compatible IDE — for development.

## 🚀 Installation and Setup

### Step 1: Clone the Repository

Open Command Prompt and run:

```bash
git clone https://github.com/uppalaharshithareddy-cpu/blood-donor-backend.git
```

Navigate to the project directory:

```cmd
cd blood-donor-backend
```

### Step 2: Create the MySQL Database

Start your MySQL server and open MySQL Workbench or the MySQL command-line client.

Create the database:

```sql
CREATE DATABASE blooddonordb;
```

The application is configured to connect to a local MySQL server using the database name `blooddonordb`.

### Step 3: Configure Database Credentials

Open:

`src/main/resources/application.properties`

The database configuration uses the following settings:

```properties
spring.application.name=BloodDonorBackend
spring.datasource.url=jdbc:mysql://localhost:3306/blooddonordb
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8081
```

Set the `DB_PASSWORD` environment variable to your local MySQL password.

For Windows Command Prompt, run:

```cmd
set DB_PASSWORD=your_mysql_password
```

Replace `your_mysql_password` with your actual local MySQL password. This command applies only to the current Command Prompt session.

**Important:** Never commit actual database passwords or other secrets to a public repository.

### Step 4: Run the Backend

Make sure the MySQL service is running and that the `DB_PASSWORD` variable is set in the same terminal.

Start the Spring Boot application on Windows:

```cmd
mvnw.cmd spring-boot:run
```

If the application starts successfully, it should be available at:

`http://localhost:8081`

The first startup may take some time while Maven downloads required dependencies.

### Step 5: Open the Application

If the backend's static pages are available, open:

- Login page: `http://localhost:8081/login.html`
- Dashboard page: `http://localhost:8081/index.html`

These addresses work on the same computer where the backend is running. They are local development URLs, not public deployment links.

## 🗄️ Database Configuration

The application uses MySQL as its relational database.

| Setting | Value |
|---|---|
| Database name | `blooddonordb` |
| Database host | `localhost` |
| Database port | `3306` |
| Database username | `root` by default |
| Database password | Read from `DB_PASSWORD` |
| Hibernate schema setting | `update` |

Spring Data JPA and Hibernate are configured to manage entity persistence. With `spring.jpa.hibernate.ddl-auto=update`, Hibernate can update database tables based on mapped entities. For production applications, use a controlled database migration strategy and back up important data.

## 🔌 Backend Components

### Main Application
`BackendApplication.java`

The main Spring Boot entry point responsible for starting the application.

### Authentication
`AuthController.java` and `AuthService.java`

These classes handle authentication-related controller and service logic.

### Donor Management
`DonorController.java` and `DonorService.java`

These classes provide controller and service functionality for donor-related operations.

### Entities and Models
- `Donor.java`
- `User.java`

These classes represent donor and user data used by the application.

### Repositories
- `DonorRepository.java`
- `UserRepository.java`

These repositories support database access for donor and user data.

### Configuration
- `SecurityConfig.java`
- `PasswordConfig.java`

These classes contain application security and password-related configuration.

## 🌐 API Overview

The backend contains controller classes for authentication and donor-related functionality.

The exact API endpoints, HTTP methods, request bodies, and responses are defined in the controller source files. Review `AuthController.java` and `DonorController.java` before integrating another frontend or documenting specific API routes.

Base URL for local development:

`http://localhost:8081`

> Note: This README does not list unverified endpoint paths. API documentation can be expanded as the endpoints are confirmed and tested.

## 🖥️ Related Frontend Repository

The frontend is maintained in a separate GitHub repository.

**Frontend repository:**  
https://github.com/uppalaharshithareddy-cpu/blood-donor-frontend

The frontend contains the HTML pages used to interact with the application. During local development, the backend's `static` directory also contains copies of the login and dashboard pages.

## 🧪 Testing

The project includes a Spring Boot test class:

`src/test/java/com/blooddonor/backend/BackendApplicationTests.java`

Run the project's tests on Windows using:

```cmd
mvnw.cmd test
```

Review the test results to confirm whether the current test suite passes in your environment.

## 🔐 Security and Privacy

Because this application concerns donor information, privacy and security are important.

- Do not commit passwords, API keys, or other secrets.
- Do not publish real donor personal information in the repository.
- Use strong passwords for accounts and database access.
- Validate and sanitize incoming request data.
- Restrict access to protected endpoints through appropriate authentication and authorization.
- Use HTTPS and secure deployment configuration when hosting the application publicly.
- Review CSRF settings and access rules before production use.
- Store only the personal information required for the application's purpose.
- Obtain appropriate consent before collecting or sharing donor information.

**Production readiness:** This is an educational project under development. Its authentication, authorization, and deployment configuration should be reviewed and tested before it is used with real donor data.

## 🔮 Future Improvements

Potential enhancements include:

- Search donors by blood group and location.
- Add donor registration and profile management.
- Add validation for donor details.
- Implement role-based access for administrators and users.
- Improve authentication and authorization.
- Add API documentation using OpenAPI/Swagger.
- Add automated unit and integration tests.
- Add pagination and filtering for donor searches.
- Add controlled database migrations.
- Deploy the frontend and backend to suitable hosting services.
- Add privacy controls and consent management.

## 📌 Project Status

**Status:** Educational project — under development.

Features and API behavior may change as development continues.

## 👩‍💻 Author

**Harshitha**

GitHub: https://github.com/uppalaharshithareddy-cpu


---

*Built as a learning project to explore Java, Spring Boot, MySQL, and web application development.*
