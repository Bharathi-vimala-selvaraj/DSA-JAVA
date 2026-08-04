# Insert at End in Singly Linked List

## Overview

Insertion at the end adds a new node after the last node of the linked list.

Unlike insertion at the beginning, this operation requires traversing the list to locate the last node.

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
40
```

After Insertion

```
head
 ↓
10 → 20 → 30 → 40 → null
```

---

## Core Idea

The last node is identified by checking whether its `next` reference is `null`.

Once the last node is found, its `next` reference is updated to point to the newly created node.

---

## Key Snippets

### Create a New Node

```java
Node newNode = new Node(data);
```

---

### Traverse to the Last Node

```java
while(temp.next != null){
    temp = temp.next;
}
```

Notice that the condition is **`temp.next != null`**, not **`temp != null`**.

This ensures that `temp` stops at the **last node**, allowing us to update its `next` reference.

---

### Connect the Last Node

```java
temp.next = newNode;
```

---

## Algorithm

1. Create a new node.
2. If the list is empty, make the new node the head.
3. Traverse until the last node.
4. Connect the last node to the new node.

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
40 → null
```

Pointer Movement

```
temp = 10

↓

temp = 20

↓

temp = 30
```

The loop stops because

```
30.next == null
```

Connect

```
30.next = 40
```

Final List

```
head
 ↓
10 → 20 → 30 → 40 → null
```

---

## Why do we use `temp.next != null`?

Suppose the condition is

```java
while(temp != null)
```

Pointer movement

```
10

↓

20

↓

30

↓

40

↓

null
```

The loop terminates with

```
temp = null
```

Now,

```java
temp.next = newNode;
```

results in a **NullPointerException** because `temp` no longer points to a valid node.

---

Using

```java
while(temp.next != null)
```

stops the traversal **one node before `null`**, leaving `temp` pointing to the last node.

```
10

↓

20

↓

30
```

Now,

```java
temp.next = newNode;
```

is valid.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Insert at End | **O(n)** |

---

## Space Complexity

| Operation | Complexity |
|----------|------------|
| Extra Space | **O(1)** |

---

## Edge Cases

### Empty List

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

After inserting `20`

```
head
 ↓
10 → 20 → null
```

---

## Common Mistakes

- Forgetting to handle an empty list.
- Using `temp != null` instead of `temp.next != null`.
- Forgetting to link the last node to the new node.
- Traversing using the `head` reference instead of a temporary pointer.

---

## Summary

- Finding the last node requires traversal.
- The last node is identified when `next` is `null`.
- Use `temp.next != null` so the pointer stops at the last node.
- Insertion at the end takes **O(n)** time because traversal is required.

---

## Related Problems

- Insert at Beginning
- Insert at Position
- Delete from End
- Reverse Linked List
