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

### Visualization
---

## Initial State of the List

Let's start with the initial state of the doubly linked list:

- **Head and Tail Pointers**:
  - `head` points to `Node1` (data = 1)
  - `tail` points to `Node3` (data = 3)

- **Nodes**:
  - `Node1`: data = 1, `prev` = `null`, `next` = `Node2`
  - `Node2`: data = 2, `prev` = `Node1`, `next` = `Node3`
  - `Node3`: data = 3, `prev` = `Node2`, `next` = `null`

### Graphical Representation

```
null <- [1] <-> [2] <-> [3] -> null
```

---

## The `reverseAll` Function

Here is the `reverseAll` function for reference:

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

## Visualization at Each Step

### **Initial List**

```
head -> [1] <-> [2] <-> [3] <- tail
```
### Before Iteration

```
[1] -> prev: null, next: Node2
[2] -> prev: Node1, next: Node3
[3] -> prev: Node2, next: null
```

### **After Iteration 1**

```
*[1] -> prev: Node2, next: null
[2] -> prev: Node1, next: Node3
[3] -> prev: Node2, next: null
```

### **After Iteration 2**

```
[1] -> prev: Node2, next: null
*[2] -> prev: Node3, next: Node1
[3] -> prev: Node2, next: null
```

### **After Iteration 3**

```
[1] -> prev: Node2, next: null
[2] -> prev: Node3, next: Node1
*[3] -> prev: null, next: Node2
```

### **After Swapping `head` and `tail`**

```
head -> [3] <-> [2] <-> [1] <- tail
```