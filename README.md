# Doubly Linked List Implementation in Java

This project provides a implementation of a doubly linked list in Java, along with unit tests using JUnit. 

This project is written for the Boğaziçi University Master of Science in Software Engineering SWE 510.01 Data Structures and Algorithms course to showcase the usage of reserseAll function in a doubly linked list.

The repository link of the project can be located via given [link](https://github.com/Yusufss4/doubly-linked-list-java)

## Table of Contents

- [Doubly Linked List Implementation in Java](#doubly-linked-list-implementation-in-java)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Compilation Instructions](#compilation-instructions)
    - [Compile Main Classes](#compile-main-classes)
    - [Compile Unit Tests](#compile-unit-tests)
  - [Running the Application](#running-the-application)
  - [Running Unit Tests](#running-unit-tests)
  - [Understanding the `reverseAll` Function](#understanding-the-reverseall-function)

## Features

- Generic implementation of a doubly linked list
- Basic operations: add, remove by value, remove by index
- Compare two lists for equality
- Reverse the list
- Custom `toString` method for easy visualization
- Comprehensive unit tests using JUnit

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher
- **JUnit and Hamcrest Libraries**: Download and place the following JAR files in the `lib` directory:
  - [JUnit 4.13.2](https://search.maven.org/remotecontent?filepath=junit/junit/4.13.2/junit-4.13.2.jar)
  - [Hamcrest Core 1.3](https://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar)

## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/doubly-linked-list-java.git
   ```

2. **Navigate to Project Directory**

   ```bash
   cd doubly-linked-list-java
   ```

3. **Create Necessary Directories**

   ```bash
   mkdir -p lib bin
   ```

4. **Download Dependencies**

   Download JUnit and Hamcrest JAR files and place them in the `lib` directory.

## Compilation Instructions

### Compile Main Classes

```bash
javac -d bin src/main/java/com/bu/doublylinkedlist/*.java
```

### Compile Unit Tests

```bash
javac -d bin -cp "bin:lib/*" src/test/java/com/bu/doublylinkedlist/DoublyLinkedListTest.java
```
## Running the Application

Execute the `Main` class to see the doubly linked list in action:

```bash
java -cp bin com.bu.doublylinkedlist.Main
```

## Running Unit Tests

Run the unit tests using JUnit:

```bash
java -cp "bin:lib/*" org.junit.runner.JUnitCore com.bu.doublylinkedlist.DoublyLinkedListTest
```

## Understanding the `reverseAll` Function

....