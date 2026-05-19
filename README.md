# Personal-Library-System
A console application developed in Java to manage your personal reading library.

## Features
- Register books with title, author, category, and reading status
- List all registered books
- Update a book's reading status
- Remove books
- Filter books by author, category, status, or title
- Generate a report grouped by category

## To execute
``` bash
git clone https://github.com/marcosv-dev-java/Personal-Library-System.git
cd Personal-Library-System
mvn compile exec:java -Dexec.mainClass="com.marcos.biblioteca.ui.Main"
```
  
 ## Technologies
 - Java 21
 - Maven
 - JUnit 5
 - Mockito
 - Java I/O (persistence in CSV)
   
## Concepts Applied

- Object-Oriented Programming (OOP)
- SOLID Principles
- Unit testing with JUnit 5 and Mockito
- Data persistence with Java I/O
- Repository design pattern
- Dependency injection via constructor

## Architecture
   The project follows the SOLID principles with a clear separation of responsibilities:
- `model` — domain entities
- `repository` — data access (CSV file or memory)
- `service` — business rules
- `storage` — reading and writing files
- `filter` — interchangeable filters via interface
- `report` — reporting
- `ui` — user interaction
   

