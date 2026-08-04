# Delete from Beginning in Doubly Linked List

## Overview

Delete the first node from a Doubly Linked List.

Since the first node is being removed, the second node becomes the new head.

Unlike a Singly Linked List, we must also remove the backward connection of the new head.

---

## Visual Representation

Before

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Delete Beginning

After

```
null ← 20 ⇄ 30 → null
```

---

# What's Different from Singly Linked List?

In a Singly Linked List, deleting the first node is simply

```java
head = head.next;
```

In a Doubly Linked List,

the new head still remembers the deleted node.

```
10 ⇄ 20
```

After

```java
head = head.next;
```

we get

```
20.prev → 10 ❌
```

That reference is now invalid.

Therefore,

```java
head.prev = null;
```

must also be executed.

---

# Similarity with Singly Linked List

Both data structures

- move the head to the second node
- handle empty and single-node lists separately

The only extra work is clearing the new head's `prev` pointer.

---

# 🧠 Think Like the Pointer

Imagine a train.

```
10 ⇄ 20 ⇄ 30
```

Coach **10** is removed.

Now

```
20
```

becomes the first coach.

But if

```
20.prev
```

still points to

```
10
```

the train still remembers a coach that no longer exists.

The first coach should always have

```
prev = null
```

---

## Core Idea

Deleting the first node requires two updates.

```
head = head.next

↓

head.prev = null
```

---

## Key Snippets

### Empty List

```java
if(head == null){
    return;
}
```

---

### Single Node

```java
if(head.next == null){
    head = null;
}
```

---

### Move Head

```java
head = head.next;
```

---

### Remove Backward Link

```java
head.prev = null;
```

---

## Dry Run

Before

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Step 1

```
head = 20
```

Step 2

```
20.prev = null
```

Final

```
null ← 20 ⇄ 30 → null
```

---

## Algorithm

1. Check whether the list is empty.
2. Handle the single-node case.
3. Move the head to the second node.
4. Set the new head's `prev` to `null`.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Delete from Beginning | **O(1)** |

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

Nothing happens.

---

### Single Node

```
null ← 10 → null
```

↓

```
head = null
```

---

### Two Nodes

Before

```
null ← 10 ⇄ 20 → null
```

After

```
null ← 20 → null
```

---

## Common Mistakes

- Forgetting `head.prev = null`.
- Forgetting the single-node case.
- Accessing `head.prev` after setting `head = null`.
- Assuming Java automatically clears links.

---

## Pointer Rule Learned

**Whenever the head changes in a Doubly Linked List, the new head must always have `prev = null`.**

---

## Interview Insight

**Q:** Why is `head.prev = null` necessary?

**A:** After moving the head, the new first node still points back to the deleted node. Clearing `prev` ensures the list starts correctly and avoids an invalid backward reference.

---

## Summary

Delete from Beginning is a constant-time operation.

```
Move Head

↓

Remove Backward Link

↓

Done
```

---

## Related Problems

- Insert at Beginning
- Delete from End
- Delete by Value
- Reverse Doubly Linked List
