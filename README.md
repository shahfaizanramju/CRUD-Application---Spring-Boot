# CRUD-Application---Spring-Boot
Created an extensive CRUD application using Spring Boot, Java, and PostgreSQL. The application feature as create, read, update and update.

**Objective:** - The objectives of a CRUD application are to enable efficient management of data by allowing users to create, read, update, and delete records easily. It aims to provide a user-friendly interface with robust data validation to ensure accuracy. Security measures will protect sensitive information through authentication and authorization.

### Technology Stack
- **Backend:** Spring Boot (Java), Hibernate (for server-side rendering)
- **Database:** PostgreSQL
- **Frontend:** No Frontend
- **Build Tool:** Maven

  ### Key Components

1. **Project Setup**
   - Create a Spring Boot project using Spring Initializr (https://start.spring.io/).
   - Include dependencies for Spring Web, Spring Data JPA, Starter Test, Lombok and PostgreSQL Driver.

2. **Database Configuration**
   - Configure PostgreSQL in `application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/bankdb
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Entity Classes**
   - Create entity classes to represent the database tables:
     - **User:** Represents a bank user with fields like `id`, `email`, `name` and `phone`.
     - **Account:** Represents a user account with fields like `id`, `user_id`, `account_type`, `balance`.
     - **Transaction:** Represents a transaction with fields like `id`, `account_id`, `type`, `amount`, `timestamp`.

4. **Repositories**
   - Create repository interfaces extending `JpaRepository` for each entity to perform CRUD operations.
     ```java
     public interface UserRepository extends JpaRepository<EEnity, Long> {
     }
     ```

5. **Service Layer**
   - Implement service classes to handle business logic:
     - **UserService:** Handles user registration, authentication, and fetching user details.
       
    ```java
    package com.example.crudoperation;
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
    
   @SpringBootApplication
    public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    }
   ```

# Installation Instructions for CRUD Application

### Clone the Repository

1. Open your terminal or command prompt.
2. Clone the repository:
   ```bash
   git clone https://github.com/shahfaizanramju/CRUD-Application---Spring-Boot.git
   ```
3. Navigate to the project directory:
   ```bash
   cd CRUD
   ```

#### Set Up PostgreSQL Database

1. Log in to your PostgreSQL server using:
   ```bash
   psql -U postgres
   ```
   (Replace `postgres` with your username if different.)

2. Create a new database:
   ```sql
   CREATE DATABASE bank_application;
   ```

3. Exit the PostgreSQL prompt:
   ```sql
   \q
   ```

#### Configure Application Properties

1. Open the `src/main/resources/application.properties` file in your project.
2. Configure the database connection settings:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
   Replace `your_username` and `your_password` with your PostgreSQL credentials.

#### Build the Application

1. In your terminal, ensure you're in the project root directory.
2. Build the application using Maven:
   ```bash
   mvn clean install
   ```

#### Run the Application
- Start the application
   ```bash
   mvn spring-boot:run
   ```

# Access the Application
### Setting Up Postman for the CRUD Application
- Opne Postman and navigate to `localhost:8080` to access the CRUD application.
![Default GET](https://github.com/user-attachments/assets/8d37b5fc-8376-47c8-8f08-0251261505f0)


#### POST - localhost:8080
- To create data by .JSON format
  {
    "name": "name_",
    "phone": "phone__",
    "email": "email@gmail.com__"
} 
After enter data showing message as `Saved Successfully` as follow,
![POST](https://github.com/user-attachments/assets/38d5580e-d677-4592-9fd0-0a5628dcc02a)


#### GET - localhost:8080 
- To read all data that we save into database as follow,
![GET Data](https://github.com/user-attachments/assets/479988a4-2916-4a9d-b8d0-0d151ac0ec00)
  
- Also we can read individual by mapping through id as `localhost:8080/id` as folow,
![GET by ID](https://github.com/user-attachments/assets/397a463a-769a-4b2a-8fa0-573c70df676f)


#### PUT - localhost:8080 
- To update data in database if data enter incorrect as follow,
  ![PUT Data](https://github.com/user-attachments/assets/e9a98175-0d39-447b-98a6-1dff7fc96127)


#### DELETE - localhost:8080
- To delete data from database by using id `localhost:8080{id}` as follow,
  ![DELETE by ID](https://github.com/user-attachments/assets/81dbf80d-ea29-4521-989f-8ad8718acc21)

## Additional Notes
Make sure that PostgreSQL is running before starting the application.
If you encounter any issues, check the logs in the terminal for error messages that can help with troubleshooting.
