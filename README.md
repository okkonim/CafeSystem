# Cafe Management System


## Overview

The **Cafe Management System** project is developed to automate cafe management operations. This backend application provides APIs for managing product categories, products, users, and orders.

## Features

- Category and product management
- User authentication and authorization
- User management with roles
- Order processing and invoicing
- Notifications and status management

## Technologies

- **Java** - primary programming language
- **Spring Boot** - framework for Java applications
- **Spring Security** - for application security
- **Hibernate** - for database interaction
- **MySQL** - relational database
- **JWT** - for authentication and token handling
- **Maven** - for dependency management and project build

## Installation and Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your/repository.git
   cd cafe-management-system
   
Install dependencies

2. **Use Maven to install dependencies:**

    ```bash
    mvn clean install

3. **Configure the database**

 - Create a MySQL database named cafe_db.
 - Configure database settings in the application.properties file.
4. **Run the application**

Launch the application using Maven:

    ```bash
    mvn spring-boot:run
5. **Verify functionality**

After starting the application, you can send requests to the API to verify its functionality.

## API Endpoints

**Categories**
 - GET /api/categories - Retrieve all categories
 - POST /api/categories - Add a new category
 - PUT /api/categories/{id} - Update category information
 - DELETE /api/categories/{id} - Delete a category
   
**Products**
 - GET /api/products - Retrieve all products
 - POST /api/products - Add a new product
 - PUT /api/products/{id} - Update product information
 - DELETE /api/products/{id} - Delete a product
 - GET /api/products/{id} - Retrieve product information by ID
   
**Users**
 - POST /api/users/signup - Register a new user
 - POST /api/users/login - User login
 - GET /api/users - Retrieve all users
 - PUT /api/users/{id} - Update user information
 - PUT /api/users/{id}/status - Update user status
 - POST /api/users/change-password - Change user password
- POST /api/users/forgot-password - Reset user password
  
**Orders**
 - POST /api/orders - Create a new order
 - GET /api/orders - Retrieve all orders
 - GET /api/orders/{id} - Retrieve order information by ID
 - PUT /api/orders/{id} - Update order information
