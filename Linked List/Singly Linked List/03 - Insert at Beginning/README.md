# Insert at Beginning in Singly Linked List

## Overview

Insertion at the beginning is one of the simplest operations in a singly linked list.

Instead of shifting existing elements (as in an array), a new node is created and linked before the current head. The head reference is then updated to point to the newly inserted node.

---

## Visual Representation

Before Insertion

```
head
 ↓
10 → 20 → 30 → null
```

Insert

```
5
```

After Insertion

```
head
 ↓
5 → 10 → 20 → 30 → null
```

---

## Core Idea

The new node should become the first node of the list.

To achieve this:

1. Connect the new node to the current head.
2. Move the head to the new node.

---

## Key Snippets

### Step 1: Connect the New Node

```java
newNode.next = head;
```

The new node points to the existing first node.

---

### Step 2: Update the Head

```java
head = newNode;
```

The new node becomes the first node of the linked list.

---

## Algorithm

1. Create a new node.
2. Point the new node to the current head.
3. Update the head to the new node.

---

## Dry Run

Initial List

```
head
 ↓
10 → 20 → 30 → null
```

Create

```
newNode

5 → null
```

Step 1

```
newNode.next = head
```

```
5 → 10 → 20 → 30 → null
```

Step 2

```
head = newNode
```

Final List

```
head
 ↓
5 → 10 → 20 → 30 → null
```

---

## Why do we connect first and update the head later?

Suppose we write

```java
head = newNode;
newNode.next = head;
```

After the first statement,

```
head
 ↓
5 → null
```

The original list

```
10 → 20 → 30
```

becomes unreachable because no reference points to it anymore.

The existing nodes are effectively lost.

Therefore, always connect the new node to the current head **before** updating the head reference.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Insert at Beginning | **O(1)** |

---

## Space Complexity

| Operation | Complexity |
|----------|------------|
| Extra Space | **O(1)** |

---

## Edge Cases

### Empty List

Before

```
head = null
```

After inserting `10`

```
head
 ↓
10 → null
```

---

### Single Node

Before

```
head
 ↓
10 → null
```

After inserting `5`

```
head
 ↓
5 → 10 → null
```

---

## Common Mistakes

- Updating `head` before connecting the new node.
- Forgetting to update the head.
- Assuming insertion requires traversing the list.
- Forgetting to handle an empty list (although this algorithm naturally supports it).

---

## Summary

- Insertion at the beginning requires only two pointer updates.
- The original head should never be lost.
- This operation does not require traversal.
- It is one of the most efficient linked list operations with **O(1)** time complexity.

---

## Related Problems

- Insert at End
- Insert at Position
- Delete from Beginning
- Reverse Linked List
