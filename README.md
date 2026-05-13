May 11th-2026 - Stage 1
# Beneficiary Project — Login Feature

## Overview

The Login feature allows authenticated bankers to securely access the Beneficiary Project. A banker enters their email and password, which is validated against the database. On success, they are redirected to the Welcome page displaying their name.

\---

## Tech Stack

|Layer|Technology|
|-|-|
|Frontend|React 18, TypeScript, Axios, React Router v6|
|Backend|Spring Boot 3.x, Spring Data JPA, Lombok|
|Database|MySQL 8.x|
|Build Tool|Maven (Backend), npm (Frontend)|

\---

## Project Structure

### Backend (`beneficiary-api`)

```
src/main/java/com/wellsfargo/beneficiary/
├── config/
│   └── WebConfig.java              # CORS configuration
├── controller/
│   ├── LoginController.java         # POST /api/auth/login
│   └── BeneficiaryController.java  # GET /api/beneficiary/hello
├── service/
│   └── LoginService.java            # Login business logic

|       BeneficiaryService.java      # Beneficiary business logic
├── dao/
│   ├── BankerRepository.java       # Banker DB queries
│   └── BeneficiaryRepository.java  # Beneficiary CRUD (Stage 3)
├── model/
│   └── Banker.java                 # JPA entity mapped to banker table
├── dto/
│   ├── LoginRequestDTO.java        # Incoming login payload
│   |── LoginResponseDTO.java       # Outgoing login response 

|       BeneficiaryDTO.java         # Beneficiary Request(TBD)
├── exception/
│   └── GlobalExceptionHandler.java # Centralized error handling
└── util/
    └── PasswordUtil.java           # Password comparison utility
```

### Frontend (`beneficiary-ui`)

```
src/
├── api/
│   ├── axiosConfig.ts              # Centralized Axios instance
│   └── auth.ts                     # loginApi() function
├── context/
│   └── AuthContext.tsx             # Global auth state (bankerName)
├── pages/
│   ├── LoginPage.tsx               # Login form UI
│   └── WelcomePage.tsx             # Welcome screen after login
├── types/
│   └── auth.ts                     # TypeScript interfaces (LoginRequest, LoginResponse)
├── App.tsx                         # Route definitions
└── .env                            # Environment config (API base URL)
```

\---

## Database Setup

### Schema

```sql
CREATE DATABASE IF NOT EXISTS beneficiary;
```

### Banker Table

```sql
CREATE TABLE banker (
    eid         BIGINT          NOT NULL AUTO\_INCREMENT,
    name        VARCHAR(100)    NOT NULL,
    email       VARCHAR(150)    NOT NULL UNIQUE,
    pwd         VARCHAR(255)    NOT NULL,
    created\_by  VARCHAR(100),
    created\_on  DATETIME        DEFAULT CURRENT\_TIMESTAMP,
    updated\_by  VARCHAR(100),
    updated\_on  DATETIME        DEFAULT CURRENT\_TIMESTAMP ON UPDATE CURRENT\_TIMESTAMP,
    PRIMARY KEY (eid)
);
```

### Seed Data

```sql
INSERT INTO banker (name, email, pwd, created\_by, created\_on)
VALUES ('John Admin', 'john@wellsfargo.com', 'JohnPassword>', 'system', NOW());
```

\---

## API Endpoints

### POST `/api/auth/login`

Authenticates a banker against the database.

**Request Body**

```json
{
  "email": "john@wellsfargo.com",
  "pwd": "yourpassword"
}
```

**Success Response — 200 OK**

```json
{
  "success": true,
  "message": "Login successful",
  "bankerName": "John Admin"
}
```

**Failure Response — 401 Unauthorized**

```json
{
  "success": false,
  "message": "Invalid email or password",
  "bankerName": null
}
```

\---

### GET `/api/beneficiary/hello`

Returns a welcome message. Called by the Welcome page after login.

**Response — 200 OK**

```
Welcome to Beneficiary Project
```

\---

## Login Flow

```
User enters email + password
        ↓
LoginPage.tsx → handleSubmit()
        ↓
api/auth.ts → loginApi() \[Axios POST]
        ↓
AuthController → AuthService → BankerRepository
        ↓
MySQL: SELECT \* FROM banker WHERE email = ?
        ↓
Password comparison → LoginResponseDTO
        ↓
React: stores bankerName in AuthContext
        ↓
Navigate to /welcome → WelcomePage displays name
```

\---

## Running the Application

### Prerequisites

* Java 17+
* Node.js 22+
* MySQL 8.x running on port 3306

### Backend

```bash
# From beneficiary-api root
mvn clean install -DskipTests
# Run BeneficiaryApplication from IntelliJ
# OR
mvn spring-boot:run
```

Backend starts at: `http://localhost:8080/beneficiary`

### Frontend

```bash
# From beneficiary-ui root
npm install
npm start
```

Frontend starts at: `http://localhost:3000`

\---

## Environment Configuration

### Backend — `application-dev.yml`

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/beneficiary
    username: root
    password: <your\_password>
```

### Frontend — `.env`

```
REACT\_APP\_API\_URL=http://localhost:8080/beneficiary-api
```

\---

## Known Tech Debt (to address in Stage 2)

|Item|Description|Stage|
|-|-|-|
|Plain text passwords|Passwords stored and compared as plain text — BCrypt to be added|Stage 2|
|No JWT|Login returns banker name only — token-based auth to be added|Stage 2|
|Open endpoints|`/api/beneficiary/hello` is unprotected — Spring Security to be added|Stage 2|
|No token refresh|No session expiry or refresh mechanism|Stage 2|

\---

## Author

Beneficiary Project — Stage 1  
*Built with Spring Boot + React + MySQL*

***************************************************************************************************************
May 13th-2026 : Checkin 2
Added @transactional support for account operations
Added 11 files , modified 12 files , Total 23 files committed
