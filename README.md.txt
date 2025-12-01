# 📚 Library Management System (Backend)

A Spring Boot–based backend application for managing books, users, and transactions in a library.  
Built with **Java, Spring Boot, JPA/Hibernate, MySQL**, and tested with **Postman**.

---

## 🚀 Features
- CRUD operations for **Books** and **Users**
- Transaction management: **Issue** and **Return** books
- Search and pagination support (extendable)
- Role-based access (Admin/Member) [future extension]
- Fine calculation and analytics [future extension]
- Swagger/OpenAPI documentation for interactive API testing

---

## 📂 Project Structure
- `src/main/java` → Application code (entities, repositories, services, controllers)
- `src/test/java` → Unit tests
- `application.properties` → Database and server configuration

---

## 🔗 API Endpoints

### Books
- `POST /api/books` → Add a new book
- `GET /api/books` → Get all books
- `GET /api/books/{id}` → Get book by ID
- `PUT /api/books/{id}` → Update book
- `DELETE /api/books/{id}` → Delete book

### Users
- `POST /api/users` → Register user
- `GET /api/users` → Get all users
- `GET /api/users/{id}` → Get user by ID
- `PUT /api/users/{id}` → Update user
- `DELETE /api/users/{id}` → Delete user

### Transactions
- `POST /api/transactions/issue` → Issue book
- `POST /api/transactions/return/{id}` → Return book
- `GET /api/transactions` → Get all transactions
- `GET /api/transactions/{id}` → Get transaction by ID

---

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot, JPA/Hibernate
- **Database:** MySQL
- **Testing:** Postman
- **Documentation:** Swagger/OpenAPI

---

## ▶️ Running the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/library-management-system.git
   cd library-management-system

2. Configure application.properties with your MySQL credentials.
   
3. Build and run:
   mvn clean install
   mvn spring-boot:run

4. Access Swagger UI:
   http://localhost:8082/swagger-ui/index.html

## 📌 Future Enhancements
Book search and filtering

Pagination and sorting

Reservation system

Fine calculation for overdue books

Analytics dashboard

Role-based access control

Cloud deployment with Docker/Kubernetes
