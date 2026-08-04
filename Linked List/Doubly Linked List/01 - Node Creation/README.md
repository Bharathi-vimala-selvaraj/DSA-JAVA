# Node Creation in Doubly Linked List

## Overview

A Doubly Linked List is an extension of a Singly Linked List.

Each node stores:

- The data
- A reference to the previous node
- A reference to the next node

This allows traversal in both forward and backward directions.

---

## Visual Representation

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Each node contains three fields.

```
+---------------------------+
| prev | data | next |
+---------------------------+
```

Example

```
      +-------------+
null ←| 10 | prev=null |
      | next --------|------+
      +-------------+      |
                            |
                      +-------------+
                +-----| 20 | prev---|
                |     | next -------|------+
                |     +-------------+      |
                |                          |
          +-------------+                  |
          | 30 | prev---|<-----------------+
          | next = null |
          +-------------+
```

---

# Singly vs Doubly Linked List

| Singly | Doubly |
|---------|---------|
| One pointer | Two pointers |
| Forward traversal | Forward & Backward traversal |
| Less memory | More memory |
| Insert Before is difficult | Insert Before is easy |
| Delete needs previous node | Delete is easier |

---

# Node Structure

```java
class Node{

    int data;

    Node prev;

    Node next;
}
```

---

## Constructor

```java
Node(int data){

    this.data = data;

    this.prev = null;

    this.next = null;
}
```

Every newly created node starts disconnected.

```
null ← NewNode → null
```

Only after insertion will `prev` and `next` point to other nodes.

---

# Memory Representation

```
Address      Prev      Data      Next

1000         null       10       2000

2000         1000       20       3000

3000         2000       30       null
```

Unlike arrays, nodes are not stored in contiguous memory.

The pointers connect them logically.

---

# Edge Cases

### Empty List

```
head = null
```

### Single Node

```
null ← 10 → null
```

Both `prev` and `next` are `null`.

---

# Common Mistakes

- Forgetting to initialize `prev`.
- Assuming `prev` is automatically updated.
- Confusing `prev` with the previous variable used during traversal.
- Forgetting that `head.prev` is always `null`.

---

# Key Takeaways

- A Doubly Linked List stores two references per node.
- `prev` points to the previous node.
- `next` points to the next node.
- The head node always has `prev = null`.
- The last node always has `next = null`.

---

## Related Problems

- Traversal
- Insert at Beginning
- Delete by Value
- Reverse Doubly Linked List
