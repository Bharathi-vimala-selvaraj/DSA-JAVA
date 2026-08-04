# Doubly Linked List - Patterns & Cheat Sheet

## Overview

A Doubly Linked List is a linear data structure where every node stores:

- Data
- Reference to the previous node (`prev`)
- Reference to the next node (`next`)

Unlike a Singly Linked List, traversal is possible in both forward and backward directions.

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

---

# Node Structure

```java
class Node{

    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
```

---

# Complete Operations

| No | Operation | Complexity |
|----|-----------|------------|
| 01 | Node Creation | O(1) |
| 02 | Traversal | O(n) |
| 03 | Insert at Beginning | O(1) |
| 04 | Insert at End | O(n) |
| 05 | Insert at Position | O(n) |
| 06 | Delete from Beginning | O(1) |
| 07 | Delete from End | O(n) |
| 08 | Delete by Value | O(n) |
| 09 | Search | O(n) |
| 10 | Count Nodes | O(n) |
| 11 | Reverse | O(n) |

---

# Pointer Patterns

## Pattern 1 — Move Forward

```java
temp = temp.next;
```

Used in

- Traversal
- Search
- Count
- Insert at End
- Insert at Position
- Delete by Value

---

## Pattern 2 — Move Backward

```java
temp = temp.prev;
```

Possible because every node remembers its previous node.

---

## Pattern 3 — Insert at Beginning

```
new ⇄ head
```

Pattern

```java
node.next = head;

head.prev = node;

head = node;
```

---

## Pattern 4 — Insert at End

```
Last ⇄ New
```

Pattern

```java
last.next = node;

node.prev = last;
```

---

## Pattern 5 — Insert Between Two Nodes

Before

```
A ⇄ B
```

After

```
A ⇄ X ⇄ B
```

Pattern

```java
node.next = temp.next;

node.prev = temp;

temp.next.prev = node;

temp.next = node;
```

---

## Pattern 6 — Delete Beginning

```java
head = head.next;

head.prev = null;
```

---

## Pattern 7 — Delete End

```java
temp.prev.next = null;
```

---

## Pattern 8 — Delete Middle

Before

```
A ⇄ X ⇄ B
```

After

```
A ⇄ B
```

Pattern

```java
curr.prev.next = curr.next;

curr.next.prev = curr.prev;
```

---

## Pattern 9 — Reverse

Swap both pointers.

```java
temp = curr.prev;

curr.prev = curr.next;

curr.next = temp;
```

Move

```java
curr = curr.prev;
```

Update Head

```java
head = temp.prev;
```

---

# Golden Pointer Rules

## Rule 1

Every connection has **two directions**.

Whenever you write

```java
next
```

ask yourself

> "Should a `prev` pointer also be updated?"

---

## Rule 2

The node being deleted rarely changes.

The node that points to it changes.

---

## Rule 3

Whenever the head changes,

the new head must have

```java
head.prev = null;
```

---

## Rule 4

Whenever the last node changes,

the new last node must have

```java
last.next = null;
```

---

## Rule 5

Never overwrite a pointer before preserving it.

Example

```java
node.next = temp.next;
```

must happen before

```java
temp.next = node;
```

Otherwise,

the remaining list is lost.

---

# Singly vs Doubly Linked List

| Feature | Singly | Doubly |
|----------|---------|---------|
| Previous Pointer | ❌ | ✅ |
| Forward Traversal | ✅ | ✅ |
| Backward Traversal | ❌ | ✅ |
| Memory Usage | Less | More |
| Delete Node | Harder | Easier |
| Reverse | More Pointer Work | Simple Swap |
| Search | O(n) | O(n) |

---

# Time Complexity

| Operation | Time |
|------------|------|
| Insert Beginning | O(1) |
| Insert End | O(n) |
| Insert Position | O(n) |
| Delete Beginning | O(1) |
| Delete End | O(n) |
| Delete Value | O(n) |
| Search | O(n) |
| Count | O(n) |
| Reverse | O(n) |

---

# Space Complexity

All operations

```
O(1)
```

except Recursive Search

```
O(n)
```

because of the recursion stack.

---

# Edge Cases Checklist

Always think about

```
□ Empty List

□ Single Node

□ First Node

□ Last Node

□ Middle Node

□ Invalid Position

□ Value Not Found
```

---

# Common Interview Questions

### Why use a Doubly Linked List?

To allow efficient backward traversal and simpler insertion/deletion when the previous node is required.

---

### Why is Search still O(n)?

Because nodes must still be visited sequentially.

---

### Why is Delete easier?

Because

```java
curr.prev
```

already gives the previous node.

---

### Why is Reverse easier?

Because every node simply swaps

```
prev

↓

next
```

instead of rebuilding links.

---

### How can Insert/Delete at End become O(1)?

Maintain

```java
Node tail;
```

along with

```java
Node head;
```

---

# Common Mistakes

❌ Forgetting

```java
head.prev = null;
```

---

❌ Forgetting

```java
curr.next.prev = curr.prev;
```

---

❌ Moving with

```java
curr.next
```

after swapping pointers during reverse.

---

❌ Traversing using

```java
temp != null
```

instead of

```java
temp.next != null
```

when the last node is required.

---

❌ Writing

```java
temp = null;
```

instead of changing the pointer that owns the connection.

---

# Interview Patterns

### Traversal Pattern

```java
Node temp = head;

while(temp != null){

    temp = temp.next;
}
```

---

### Find Last Node

```java
while(temp.next != null){

    temp = temp.next;
}
```

---

### Insert Pattern

```
Preserve

↓

Connect New Node

↓

Reconnect Existing Node
```

---

### Delete Pattern

```
Find Target

↓

Reconnect Neighbors

↓

Disconnect Removed Node
```

---

### Reverse Pattern

```
Swap

↓

Move

↓

Repeat
```

---

# 15-Second Revision

```
Traversal
↓

temp = temp.next

--------------------------------

Insert Beginning

new.next = head

head.prev = new

head = new

--------------------------------

Insert End

last.next = new

new.prev = last

--------------------------------

Delete Beginning

head = head.next

head.prev = null

--------------------------------

Delete End

last.prev.next = null

--------------------------------

Delete Middle

prev.next = next

next.prev = prev

--------------------------------

Reverse

Swap prev & next

Move using prev

Update head
```

---

# Final Takeaways

- Every node knows both its neighbors.
- Always think in **both directions**.
- Whenever a `next` pointer changes, ask whether a `prev` pointer must also change.
- Preserve existing links before modifying them.
- Reversal is achieved by swapping pointers, not rebuilding the list.
- Most interview mistakes occur because one direction is updated while the other is forgotten.

Master these pointer patterns, and almost every Doubly Linked List problem becomes a variation of the same ideas.
