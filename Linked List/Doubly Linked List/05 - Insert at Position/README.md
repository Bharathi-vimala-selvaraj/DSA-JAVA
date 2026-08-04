# Insert at Position in Doubly Linked List

## Overview

Insert a new node at any valid position in a Doubly Linked List while maintaining both forward and backward links.

Unlike a Singly Linked List, every insertion updates **both `next` and `prev` references**.

---

## Visual Representation

Before

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Insert **25** at Position **3**

After

```
null ← 10 ⇄ 20 ⇄ 25 ⇄ 30 → null
```

---

# What's Different from Singly Linked List?

In a Singly Linked List, inserting between two nodes updates only two links.

```
20 → 25 → 30
```

In a Doubly Linked List, four links are involved.

```
20 ⇄ 25 ⇄ 30
```

Both directions must remain consistent.

---

# Similarity with Singly Linked List

The traversal to reach the desired position is exactly the same.

```
head

↓

10 → 20 → 30
```

The difference begins only after the position is found.

---

# 🧠 Think Like the Pointer

Imagine two friends holding hands.

```
20 ⇄ 30
```

A new friend joins between them.

```
20 ⇄ 25 ⇄ 30
```

Now,

- 20 must know 25
- 25 must know 20
- 25 must know 30
- 30 must know 25

Four relationships must be correct.

---

## Core Idea

Suppose

```
20 ⇄ 30
```

Insert

```
25
```

The order is

```
25 → 30

↓

25 ← 20

↓

30 ← 25

↓

20 → 25
```

Never overwrite existing links before preserving them.

---

## Key Snippets

### Connect Forward

```java
node.next = temp.next;
```

---

### Connect Backward

```java
node.prev = temp;
```

---

### Update Existing Next Node

```java
if(temp.next != null){
    temp.next.prev = node;
}
```

---

### Finish the Insertion

```java
temp.next = node;
```

---

## Dry Run

Before

```
10 ⇄ 20 ⇄ 30
```

Create

```
25
```

Step 1

```
25 → 30
```

Step 2

```
25 ← 20
```

Step 3

```
30 ← 25
```

Step 4

```
20 → 25
```

Final

```
10 ⇄ 20 ⇄ 25 ⇄ 30
```

---

## Algorithm

1. Validate the position.
2. Handle insertion at the beginning.
3. Traverse to the previous node.
4. Connect the new node to its neighbors.
5. Update neighboring nodes.
6. Finish the insertion.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Insert at Position | **O(n)** |

---

## Space Complexity

| Operation | Complexity |
|----------|------------|
| Extra Space | **O(1)** |

---

## Edge Cases

- Empty list
- Insert at first position
- Insert at last position
- Invalid position
- Single-node list

---

## Common Mistakes

- Forgetting `temp.next.prev = node`
- Forgetting to update `node.prev`
- Losing the next node before reconnecting
- Ignoring insertion at Position 1

---

## Pointer Rule Learned

Whenever a node is inserted between two existing nodes in a Doubly Linked List, **four references participate**.

Preserve existing links first, then redirect them.

---

## Interview Insight

**Q:** Why is insertion in a Doubly Linked List more pointer-intensive than in a Singly Linked List?

**A:** Because every neighboring node stores a forward and backward reference, both of which must remain synchronized after insertion.

---

## Summary

Insertion at Position consists of:

```
Find Position

↓

Connect New Node

↓

Reconnect Neighbors

↓

Finish
```

---

## Related Problems

- Insert at Beginning
- Insert at End
- Delete by Position
- Delete by Value
