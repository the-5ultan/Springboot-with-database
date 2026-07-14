\# Alien Registration Portal



A simple Spring Boot CRUD web application for registering, viewing, searching, and deleting "Alien" entries. It demonstrates both a traditional server-side rendered MVC flow (Thymeleaf) and a REST API layer for JSON/XML data exchange.



\## Overview



| | |

|---|---|

| \*\*Project Name\*\* | demo (Alien Registration Portal) |

| \*\*Group ID\*\* | com.example |

| \*\*Artifact ID\*\* | demo |

| \*\*Package\*\* | com.nitu.demo |

| \*\*Version\*\* | 0.0.1-SNAPSHOT |

| \*\*Type\*\* | Spring Boot Web Application + REST API |



\## Features



\- \*\*Add Alien\*\* — Register a new alien via form (`/addAlien`) or REST (`POST /alien`)

\- \*\*View All Aliens\*\* — List all aliens (`/getAliens`)

\- \*\*View Single Alien by ID\*\* — Search by primary key (`/getAlien`, `GET /alien/{id}`)

\- \*\*Search Aliens by Name\*\* — Find aliens by name, sorted by ID descending (`/getAlienByName`)

\- \*\*Remove Alien\*\* — Delete an alien by ID and name (`/removeAlien`)

\- \*\*Calculator\*\* — Simple addition of two numbers (`/add`)

\- \*\*REST API (JSON/XML)\*\* — Programmatic access via `@RestController`

\- \*\*XML Content Negotiation\*\* — `GET /aliens` produces XML only; `POST /alien` consumes JSON only



\## Tech Stack



| Technology | Version / Detail |

|---|---|

| Java | 17 |

| Spring Boot | 4.0.6 |

| Build Tool | Maven (via `mvnw` wrapper) |

| Database | MySQL (`springmvc`) |

| Spring Data JPA | `spring-boot-starter-data-jpa` |

| Thymeleaf | `spring-boot-starter-thymeleaf` |

| Spring MVC | `spring-boot-starter-web`, `spring-boot-starter-webmvc` |

| XML Serialization | `jackson-dataformat-xml` (v3.2.0) |

| MySQL Connector | `mysql-connector-j` (v9.6.0) |

| Persistence | Jakarta Persistence (`jakarta.persistence.\*`) |

| Testing | JUnit 5, `spring-boot-starter-webmvc-test` |



> \*\*Note:\*\* This project does not include Spring Security, Lombok, Bean Validation, DTOs, or exception handlers.



\## Project Structure



```

demo/

├── pom.xml

├── mvnw / mvnw.cmd

├── HELP.md

├── .gitignore

└── src/

&#x20;   ├── main/

&#x20;   │   ├── java/com/nitu/demo/

&#x20;   │   │   ├── Springboot1stApplication.java   # Main entry point

&#x20;   │   │   ├── AlienRepo.java                  # JPA Repository

&#x20;   │   │   ├── controllers/

&#x20;   │   │   │   ├── HomeController.java         # MVC Controller (Thymeleaf views)

&#x20;   │   │   │   └── AlienController.java        # REST Controller (JSON/XML)

&#x20;   │   │   └── models/

&#x20;   │   │       └── Alien.java                  # JPA Entity

&#x20;   │   ├── resources/

&#x20;   │   │   ├── application.properties          # DB \& app config

&#x20;   │   │   └── templates/

&#x20;   │   │       ├── index.html                  # Calculator form (unused in routing)

&#x20;   │   │       ├── index2.html                 # Main homepage

&#x20;   │   │       ├── result.html                 # Calculator result page

&#x20;   │   │       ├── result2.html                # Add/remove confirmation page

&#x20;   │   │       ├── showAlien.html               # Single alien details

&#x20;   │   │       ├── showAlienByName.html         # Aliens filtered by name

&#x20;   │   │       └── showAliens.html              # All aliens list

&#x20;   │   └── static/                             # Empty (no CSS/JS/images)

&#x20;   └── test/

&#x20;       └── java/com/nitu/demo/

&#x20;           └── DemoApplicationTests.java        # Context load test

```



\## Architecture



\- \*\*MVC Module\*\* — `HomeController` + Thymeleaf templates provide a browser-based UI.

\- \*\*REST Module\*\* — `AlienController` provides a programmatic JSON/XML API.

\- \*\*Persistence Module\*\* — `Alien` (entity) + `AlienRepo` (repository) handle database operations.



There is no service, DTO, config, exception, or security package — controllers call the repository directly.



\## API Endpoints



\### MVC (Thymeleaf, browser-facing)



| Method | Endpoint | Purpose | Parameters | View |

|---|---|---|---|---|

| GET | `/` | Home page | None | `index2` |

| POST | `/add` | Add two numbers | `num1`, `num2` (int) | `result` |

| POST | `/addAlien` | Add a new alien | `id` (int), `name` (String) | `result2` |

| POST | `/removeAlien` | Delete an alien | `id` (int), `name` (String) | `result2` |

| GET | `/getAliens` | List all aliens | None | `showAliens` |

| GET | `/getAlien` | Get alien by ID | `aid` (int) | `showAlien` |

| GET | `/getAlienByName` | Get aliens by name | `name` (String) | `showAlienByName` |



\### REST (JSON/XML)



| Method | Endpoint | Consumes / Produces | Purpose | Response |

|---|---|---|---|---|

| GET | `/aliens` | `application/xml` | Get all aliens | `List<Alien>` (XML) |

| GET | `/alien/{id}` | JSON (default) | Get alien by ID | `Alien` (JSON) |

| POST | `/alien` | `application/json` | Add new alien | `Alien` (JSON) |



\## Data Model



\*\*Alien\*\* (table: `alien`)



| Field | Type | Key | Notes |

|---|---|---|---|

| `id` | int | Primary Key | `@Id`, no validation |

| `name` | String | — | No validation |



No relationships (`@OneToMany`, `@ManyToOne`, etc.) are defined.



\## Repository



`AlienRepo` extends `JpaRepository<Alien, Integer>` and provides:



\- `findAll()`, `findById(int)`, `save(Alien)`, `delete(Alien)`, `getReferenceById(int)` — inherited

\- `findByNameOrderByIdDesc(String name)` — derived query

\- `find(@Param("name") String name)` — custom JPQL: `SELECT a FROM Alien a WHERE a.name = :name`



\## Getting Started



\### Prerequisites



\- Java 17 (JDK 17+)

\- MySQL server running on `localhost:3306`

\- A database named `springmvc`



\### 1. Create the database and table



```sql

CREATE DATABASE springmvc;



USE springmvc;

CREATE TABLE alien (

&#x20;   id INT PRIMARY KEY,

&#x20;   name VARCHAR(255)

);

```



\### 2. Configure database credentials



Edit `src/main/resources/application.properties` if your MySQL credentials differ from the defaults:



```properties

spring.application.name=demo

spring.datasource.url=jdbc:mysql://localhost:3306/springmvc

spring.datasource.username=root

spring.datasource.password=your\_password

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

```



> \*\*Note:\*\* `spring.jpa.hibernate.ddl-auto` is not set, so tables are not auto-created — the `alien` table must exist before running the app.



\### 3. Run the application



```bash

./mvnw spring-boot:run

```



Or build and run the JAR:



```bash

./mvnw clean package

java -jar target/demo-0.0.1-SNAPSHOT.jar

```



\### 4. Access the application



\- Browser UI: \[http://localhost:8080/](http://localhost:8080/)

\- REST API (XML): \[http://localhost:8080/aliens](http://localhost:8080/aliens)



\## Design Patterns Used



\- \*\*MVC\*\* — `Alien` (Model), Thymeleaf templates (View), `HomeController` (Controller)

\- \*\*Dependency Injection\*\* — `@Autowired` / constructor injection for `AlienRepo`

\- \*\*Repository Pattern\*\* — `AlienRepo extends JpaRepository`

\- \*\*Front Controller\*\* — Spring's `DispatcherServlet`

\- \*\*REST\*\* — `AlienController` with `@RestController`

\- \*\*DAO\*\* — `AlienRepo` acts as the data access layer



\## Known Limitations / Future Improvements



\- \[ ] Add a service layer (`@Service`) to separate business logic from controllers

\- \[ ] Add DTOs to decouple API responses from the entity

\- \[ ] Add Bean Validation (`@Valid`, `@NotNull`, `@Size`, `@Min`)

\- \[ ] Add centralized exception handling (`@ControllerAdvice`)

\- \[ ] Add static assets (CSS, JS, images) instead of inline styles

\- \[ ] Add Spring Security (authentication/authorization)

\- \[ ] Set `spring.jpa.hibernate.ddl-auto=update` to auto-create tables

\- \[ ] Add structured logging (SLF4J/Logback)

\- \[ ] Add unit and integration tests

\- \[ ] Add pagination for listing endpoints

\- \[ ] Add database migrations (Flyway/Liquibase)

\- \[ ] Add Swagger/OpenAPI documentation

\- \[ ] Add profile-specific configs (`application-dev.properties`, `application-prod.properties`)

\- \[ ] Fix `removeAlien` to call `findById()` before `delete()` instead of passing a partial object



\## License

None for now

