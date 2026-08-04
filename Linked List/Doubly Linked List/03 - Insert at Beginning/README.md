# Insert at Beginning in Doubly Linked List

## Overview

Insert a new node as the first node of the Doubly Linked List.

Unlike a Singly Linked List, we must maintain **both forward and backward links**.

---

## Visual Representation

Before

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Insert **5**

After

```
null ← 5 ⇄ 10 ⇄ 20 ⇄ 30 → null
```

---

# What's Different from Singly Linked List?

In a Singly Linked List, inserting at the beginning only requires one connection.

```
newNode → head
```

In a Doubly Linked List,

both nodes must recognize each other.

```
null ← 5 ⇄ 10 ⇄ 20
```

That means two links must be created.

- New node points forward.
- Old head points backward.

---

# 🧠 Think Like the Pointer

Imagine a train.

```
10 ⇄ 20 ⇄ 30
```

Every coach knows

- the coach in front
- the coach behind

Now a new coach arrives.

```
5
```

Can we simply place it in front?

No.

Coach **10** must also know that **5** is now behind it.

Otherwise,

```
5 → 10
```

works,

but

```
10 ← 5
```

doesn't exist.

The train can move forward,

but not correctly backward.

---

## Core Idea

Whenever a node is inserted between two nodes,

both directions must be updated.

For insertion at the beginning:

```
node.next = head

↓

head.prev = node

↓

head = node
```

---

## Key Snippets

### Empty List

```java
if(head == null){

    head = node;

    return;
}
```

The first node has

```
prev = null
next = null
```

already set by the constructor.

---

### Step 1

```java
node.next = head;
```

Forward connection.

```
5 → 10
```

---

### Step 2

```java
head.prev = node;
```

Backward connection.

```
10 ← 5
```

---

### Step 3

```java
head = node;
```

The new node becomes the first node.

---

# 🧠 Why this order?

Suppose we change the head first.

Wrong

```java
head = node;

head.prev = node;
```

After

```java
head = node;
```

the variable `head` no longer points to the old first node.

Now

```java
head.prev = node;
```

means

```
node.prev = node
```

which is incorrect.

The reference to the old head has been lost.

Correct order

```
node.next = head

↓

head.prev = node

↓

head = node
```

Always update existing nodes **before** changing the head reference.

---

## Dry Run

Initial List

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Create

```
5
```

Step 1

```
5 → 10
```

Step 2

```
10 ← 5
```

Step 3

```
head = 5
```

Final

```
null ← 5 ⇄ 10 ⇄ 20 ⇄ 30 → null
```

---

## Algorithm

1. Create a new node.
2. If the list is empty, make it the head.
3. Point the new node to the current head.
4. Point the current head back to the new node.
5. Update the head.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Insert at Beginning | **O(1)** |

---

## Space Complexity

| Operation | Complexity |
|-----------|------------|
| Extra Space | **O(1)** |

---

## Edge Cases

### Empty List

```
head = null
```

Result

```
null ← newNode → null
```

---

### Single Node

Before

```
null ← 10 → null
```

After inserting **5**

```
null ← 5 ⇄ 10 → null
```

---

## Common Mistakes

- Forgetting `head.prev = node`.
- Updating `head` before connecting the old head.
- Forgetting the empty list case.
- Assuming `node.prev` needs assignment (it is already `null`).

---

## Pointer Rule Learned

**In a Doubly Linked List, every new connection must be reflected in both directions.**

Whenever you create

```
A → B
```

always ask yourself:

```
Does B also know about A?
```

---

## Interview Insight

**Q:** Why don't we write `node.prev = null`?

**A:** The constructor already initializes both `prev` and `next` to `null`. Since the new node becomes the head, its `prev` remains `null`.

---

## Summary

Inserting at the beginning of a Doubly Linked List requires maintaining two links:

```
Forward Link

↓

Backward Link

↓

Move Head
```

The operation is still **O(1)**, but pointer consistency is more important than in a Singly Linked List.

---

## Related Problems

- Insert at End
- Insert at Position
- Delete from Beginning
- Reverse Doubly Linked List
