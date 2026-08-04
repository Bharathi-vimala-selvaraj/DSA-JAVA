# Reverse Doubly Linked List

## Overview

Reversing a Doubly Linked List means changing the direction of every connection.

Unlike a Singly Linked List, we do not build a new chain using a `prev` pointer.

Instead, **every node simply swaps its `prev` and `next` pointers**.

After every node performs this swap, the entire list automatically becomes reversed.

---

## Visual Representation

Before

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

After

```
null ← 40 ⇄ 30 ⇄ 20 ⇄ 10 → null
```

---

# What's Different from Singly Linked List?

### Singly Linked List

We carefully preserve

```
next
```

before changing it.

```
next = curr.next

curr.next = prev

prev = curr

curr = next
```

Four pointer updates are required because there is only one direction.

---

### Doubly Linked List

Every node already has two directions.

Instead of rebuilding the list,

we simply exchange them.

```
prev ↔ next
```

That's the entire idea.

---

# Similarity with Singly Linked List

Both algorithms

- Visit every node exactly once.
- Reverse every connection.
- Update the head at the end.

The difference lies in **how the links are reversed**.

| Singly Linked List | Doubly Linked List |
|--------------------|--------------------|
| Rebuild links | Swap links |
| Uses `prev`, `curr`, `next` | Uses `curr` and `temp` |
| More pointer updates | Simple pointer swap |

---

# 🧠 Think Like the Pointer

Imagine every road in a city has two arrows.

Before

```
10 ⇄ 20
```

means

```
10.next → 20

20.prev → 10
```

Reverse it.

Instead of drawing new roads,

simply reverse every arrow.

```
10.next becomes prev

10.prev becomes next
```

Do this for every node.

Eventually,

the entire city map becomes reversed.

---

## Core Idea

For every node,

```
temp = curr.prev

↓

curr.prev = curr.next

↓

curr.next = temp
```

The node now points in the opposite direction.

Because the directions changed,

the next node to visit is now

```java
curr.prev
```

instead of

```java
curr.next
```

---

## Key Snippets

### Swap Previous Pointer

```java
temp = curr.prev;
```

Store the old previous node.

---

### Reverse Previous

```java
curr.prev = curr.next;
```

The previous pointer now becomes the next pointer.

---

### Reverse Next

```java
curr.next = temp;
```

The next pointer becomes the previous pointer.

---

### Move Forward

```java
curr = curr.prev;
```

Notice this carefully.

After swapping,

the old `next` is now stored inside `prev`.

So moving through the original list means following

```java
curr.prev
```

---

### Update Head

```java
head = temp.prev;
```

After the loop,

`temp` points to the previous node of the original head.

Its `prev` now points to the original last node,

which becomes the new head.

---

## Dry Run

Initial List

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

---

### Iteration 1

Current

```
10
```

Swap

```
prev = 20

next = null
```

Move

```
20
```

---

### Iteration 2

Current

```
20
```

Swap

```
prev = 30

next = 10
```

Move

```
30
```

---

### Iteration 3

Current

```
30
```

Swap

```
prev = 40

next = 20
```

Move

```
40
```

---

### Iteration 4

Current

```
40
```

Swap

```
prev = null

next = 30
```

Loop Ends

Update Head

```
head = 40
```

Final

```
null ← 40 ⇄ 30 ⇄ 20 ⇄ 10 → null
```

---

## Algorithm

1. Handle empty and single-node lists.
2. Start from the head.
3. For every node:
   - Store the previous node.
   - Swap `prev` and `next`.
   - Move using the new `prev`.
4. Update the head to the original last node.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Reverse | **O(n)** |

Every node is visited exactly once.

---

## Space Complexity

| Operation | Complexity |
|-----------|------------|
| Extra Space | **O(1)** |

Only one temporary pointer is used.

---

## Edge Cases

### Empty List

```
head = null
```

Nothing changes.

---

### Single Node

```
10
```

The list remains unchanged.

---

### Two Nodes

Before

```
10 ⇄ 20
```

After

```
20 ⇄ 10
```

---

## Common Mistakes

- Moving with `curr.next` after swapping.
- Forgetting to update the head.
- Swapping only one pointer.
- Assuming the Singly Linked List algorithm works here.

---

## Pointer Rule Learned

**Reversing a Doubly Linked List is not about rebuilding the list.**

It is about **swapping the two directions at every node**.

After swapping,

the traversal direction also changes.

That is why

```java
curr = curr.prev;
```

is correct.

---

## Interview Insight

**Q:** Why do we move using `curr.prev` instead of `curr.next`?

**A:** After swapping the pointers, the original `next` pointer is now stored in `prev`. Moving with `curr.next` would travel backward through the already reversed portion of the list. Following `curr.prev` continues the traversal through the remaining unreversed nodes.

---

## Summary

Reverse Doubly Linked List follows a simple pattern:

```
Store Previous

↓

Swap prev and next

↓

Move using new prev

↓

Repeat

↓

Update Head
```

Unlike a Singly Linked List, no separate reverse chain is built. Every node reverses itself by exchanging its two pointers.

---

## Related Problems

- Reverse Singly Linked List
- Reverse Circular Doubly Linked List
- Delete by Value
- Reverse Traversal
