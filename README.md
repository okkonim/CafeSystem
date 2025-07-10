# Cafe Management System

## Overview

The **Cafe Management System** is a modern backend application for automating cafe operations. It provides RESTful APIs for managing categories, products, users, and orders, with robust security and extensibility.

---

## Features
- Category and product CRUD
- User registration, authentication (JWT), and role-based access
- Order processing and PDF invoicing
- Email notifications (password reset, status changes)
- Admin/user separation
- API documentation via Swagger

---

## Technologies Used
- **Java 17**
- **Spring Boot** (REST, Security, Validation)
- **Hibernate/JPA** (MySQL)
- **JWT** (Authentication)
- **Lombok** (Boilerplate reduction)
- **Maven** (Build)
- **Swagger/OpenAPI** (API docs)
- **Docker** (optional, for easy deployment)

---

## Project Structure
```
CafeSystem/
  ├── src/main/java/cafeSystem/
  │     ├── constents/         # Constants
  │     ├── dao/               # Spring Data JPA repositories
  │     ├── jwt/               # JWT security
  │     ├── pojo/              # Entity classes
  │     ├── rest/              # REST API interfaces
  │     ├── restImpl/          # REST API implementations
  │     ├── service/           # Service interfaces
  │     ├── serviceImpl/       # Service implementations
  │     ├── utils/             # Utilities (CafeUtils, EmailUtils)
  │     └── wrapper/           # DTOs and response wrappers
  ├── src/main/resources/
  │     └── application.properties
  └── ...
```

---

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/your/repository.git
cd CafeSystem
```

### 2. Configure the database
- Create a MySQL database (e.g. `cafe`)
- Set DB credentials in `src/main/resources/application.properties`:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/cafe
  spring.datasource.username=your_user
  spring.datasource.password=your_password
  ```

### 3. Build and run
#### With Maven:
```bash
mvn clean install
mvn spring-boot:run
```
#### Or with Docker (optional):
```bash
docker build -t cafe-system .
docker run -p 8081:8081 cafe-system
```

### 4. Access API documentation
- Swagger UI: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- OpenAPI JSON: [http://localhost:8081/api-docs](http://localhost:8081/api-docs)

---

## Security
- Passwords are securely hashed (BCrypt)
- JWT-based stateless authentication
- Role-based access control (admin/user)
- Sensitive config (DB, mail, JWT secret) should use environment variables in production

---

## Example API Usage

**Register User**
```http
POST /user/signup
Content-Type: application/json
{
  "name": "John Doe",
  "contactNumber": "1234567890",
  "email": "john@example.com",
  "password": "password123"
}
```

**Login**
```http
POST /user/login
Content-Type: application/json
{
  "email": "john@example.com",
  "password": "password123"
}
```

**Get All Products**
```http
GET /product/get
Authorization: Bearer <JWT_TOKEN>
```

---

## Testing
- Unit and integration tests can be added in `src/test/java/cafeSystem/`
- To run tests:
```bash
mvn test
```

---

## Frontend
The frontend is available at: [CafeSystem-Frontend](https://github.com/okkonim/CafeSystem-Frontend)

---

## Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

## License
[MIT](LICENSE)
