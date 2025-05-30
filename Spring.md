# Spring, IoC, and REST: A Simple Technical Overview

## What is Spring?

Spring is a popular Java framework for building applications that developers use to create robust, testable, and maintainable applications. Spring provides tools for web apps (Spring MVC & REST), data access (Spring Data JPA), security (Spring Security), and more.

## What is IoC (Inversion of Control)?

IoC is a design principle where the control of object creation and management is handled by a framework (like Spring), not by your code. In Spring, this is done using the IoC "container" that creates and wires up your objects (beans).

**Example:**  
Instead of creating a `Service` object with `new Service()`, you let Spring create it and inject it where needed. In this case, I define a `@Service` class and let Spring manage it. Using the `@Autowired` annotation, I injected this service into the controller class.



**Benefits:**
- Easier to test and maintain code
- Loose coupling between components

## What is REST?

REST (Representational State Transfer) is a way to design web APIs. RESTful APIs use standard HTTP methods (GET, POST, PUT, DELETE) to perform actions on resources, usually represented as JSON.

**Example:**
- `GET /tasks` — get all tasks
- `POST /tasks` — create a new task
- `PUT /tasks/1` — update task with ID 1
- `DELETE /tasks/1` — delete task with ID 1

**Benefits:**
- Simple and uses standard web protocols
- Easy to use with many clients (web, mobile, etc.)
