# CRUD Demo — Spring Boot, Thymeleaf, and Bootstrap

A small inventory application for demonstrating local Bootstrap WebJars in a Spring Boot + Thymeleaf project. It uses an in-memory H2 database by default, so it starts without SQL Server or an internet connection once Maven dependencies have been downloaded.

## Requirements

- Java 17 or later
- Maven 3.9+ (or add Maven Wrapper files with `mvn wrapper:wrapper` once on a connected machine)

## Run with H2 (default)

```bash
mvn clean package
mvn spring-boot:run
```

Open <http://localhost:6969>. The H2 database is re-created on every restart.

## Run with SQL Server

Edit the connection values in `src/main/resources/application-sqlserver.properties`, create the target database, then run:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=sqlserver
```

## Demo accounts

| Account | Email | Password | Result |
|---|---|---|---|
| Administrator | `ad@a.com` | `ad` | Can create, edit, and delete products |
| Staff | `st@a.com` | `st` | Can view and search only |
| Blocked | `mb@a.com` | `mb` | Cannot sign in |

Bootstrap 5.3.3 and Bootstrap Icons 1.11.3 are packaged locally as WebJars. The templates also retain commented CDN alternatives for explaining the two approaches in class.
