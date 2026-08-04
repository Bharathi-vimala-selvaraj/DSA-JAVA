# Node Creation in Singly Linked List

## Overview

A **Singly Linked List** is a linear data structure consisting of nodes, where each node stores:

- Data
- A reference to the next node

Unlike arrays, linked list elements are not stored in contiguous memory. Each node is connected to the next node through a reference.

---

## Node Structure

```java
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

### Explanation

- `data` stores the value of the node.
- `next` stores the reference to the next node.
- The constructor initializes the node with the given data and sets the next reference to `null`.

---

## Visual Representation

```
Node

+---------+---------+
|  data   |  next   |
+---------+---------+
```

Example:

```
head
 ↓
+----+------+      +----+------+      +----+------+
| 10 |  ●───┼────► | 20 |  ●───┼────► | 30 | null |
+----+------+      +----+------+      +----+------+
```

---

## Creating and Connecting Nodes

```java
Node first = new Node(10);
Node second = new Node(20);
Node third = new Node(30);

first.next = second;
second.next = third;

Node head = first;
```

Result:

```
head
 ↓
10 → 20 → 30 → null
```

---

## Algorithm

1. Define a `Node` class.
2. Store the data inside the node.
3. Initialize the `next` reference to `null`.
4. Create the required nodes.
5. Connect the nodes using the `next` reference.
6. Store the address of the first node in `head`.

---

## Dry Run

Create three nodes:

```
10

20

30
```

Connect them:

```
10 → 20

20 → 30
```

Assign the head:

```
head
 ↓
10 → 20 → 30 → null
```

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Create a Node | O(1) |
| Connect Two Nodes | O(1) |

---

## Space Complexity

- **Per Node:** O(1)
- **For N Nodes:** O(N)

---

## Common Mistakes

- Forgetting to connect the nodes using the `next` reference.
- Confusing the `head` reference with the first node.
- Assuming `next` stores another node instead of a reference.
- Forgetting that the last node should point to `null`.

---

## Key Takeaways

- A linked list is formed by connecting individual nodes.
- Each node stores data and a reference to the next node.
- The `head` reference always points to the first node.
- The last node in a singly linked list points to `null`.
