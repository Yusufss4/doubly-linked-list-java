# Doubly Linked List Implementation in Java

This project provides a implementation of a doubly linked list in Java, along with unit tests using JUnit. 

This project is written for the Boğaziçi University Master of Science in Software Engineering SWE 510.01 Data Structures and Algorithms course to showcase the usage of reserseAll function in a doubly linked list.

The repository link of the project can be located via given [link](https://github.com/Yusufss4/doubly-linked-list-java)

The Main.java file on top of the project is added to showcase the usage of the reverseAll function in the linked list with more simplifed DoublyLinkedList implementation. It both includes Node.java and DoublyLinkedList.java files.

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
    - [Code Snippet](#code-snippet)
    - [Step-by-Step Explanation](#step-by-step-explanation)
  - [Visualization at Each Step](#visualization-at-each-step)
    - [Initial List](#initial-list)
    - [Before Iteration](#before-iteration)
    - [After Iteration 1](#after-iteration-1)
    - [After Iteration 2](#after-iteration-2)
    - [After Iteration 3](#after-iteration-3)
    - [After Swapping `head` and `tail`](#after-swapping-head-and-tail)

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

# Understanding the `reverseAll` Function

The `reverseAll` function reverses the order of elements in the doubly linked list. 
This operation is done in-place without creating new nodes or using additional data structures. To achieve that, we can image reversing the direction of arrows in a doubly linked list. `next` pointers will become `prev` pointers and vice versa. In the end the `head` and `tail` references will be also be swapped.

### Code Snippet

```java
public void reverseAll() {
    Node<T> current = head;
    while (current != null) {
        Node<T> temp = current.getNext();
        current.setNext(current.getPrev());
        current.setPrev(temp);
        current = temp;
    }

    Node<T> temp = head;
    head = tail;
    tail = temp;
}
```

### Step-by-Step Explanation

1. **Init and Iterate**:

   - Start with the `current` node set to the `head` of the list.
   - Traverse the list until `current` becomes `null`.

2. **Swap `next` and `prev` Pointers**:

   - **Store the Next Node**:
     - `Node<T> temp = current.getNext();`
     - Temporarily store the original `next` node to move forward in the list after swapping.
   - **Swap the Pointers**:
     - `current.setNext(current.getPrev());`
     - `current.setPrev(temp);`
     - Swap the `next` and `prev` pointers of the `current` node. It is like directions are reversed.

3. **Move to the Next Node**:

   - `current = temp;`
   - Move `current` to the original `next` node (stored in `temp`) to continue the traversal.

4. **Swap `head` and `tail`**:

   - After the loop, swap the `head` and `tail` references:
     - `Node<T> temp = head;`
     - `head = tail;`
     - `tail = temp;`
   - This updates the `head` and `tail` to reflect the reversed list.

## Visualization at Each Step

### Initial List

```
head -> [1] <-> [2] <-> [3] <- tail
```
### Before Iteration

```
[1] -> prev: null, next: Node2
[2] -> prev: Node1, next: Node3
[3] -> prev: Node2, next: null
```

### After Iteration 1

```
*[1] -> prev: Node2, next: null
[2] -> prev: Node1, next: Node3
[3] -> prev: Node2, next: null
```

### After Iteration 2

```
[1] -> prev: Node2, next: null
*[2] -> prev: Node3, next: Node1
[3] -> prev: Node2, next: null
```

### After Iteration 3

```
[1] -> prev: Node2, next: null
[2] -> prev: Node3, next: Node1
*[3] -> prev: null, next: Node2
```

### After Swapping `head` and `tail`

```
head -> [3] <-> [2] <-> [1] <- tail
```

---