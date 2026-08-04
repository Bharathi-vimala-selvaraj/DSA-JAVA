# Delete from Beginning in Singly Linked List

## Overview

Deletion from the beginning removes the first node of the linked list by updating the `head` reference to point to the second node.

Since the first node is directly accessible through `head`, no traversal is required.

---

## Visual Representation

Before Deletion

```
head
 ↓
10 → 20 → 30 → 40 → null
```

After Deletion

```
head
 ↓
20 → 30 → 40 → null
```

The node containing **10** is no longer referenced by the linked list and becomes eligible for garbage collection.

---

## Core Idea

The first node is always referenced by `head`.

Deleting it simply means moving the `head` reference to the next node.

No other links need to be modified.

---

## Key Snippets

### Check for an Empty List

```java
if(head == null){
    return;
}
```

Prevents operations on an empty linked list.

---

### Move the Head

```java
head = head.next;
```

The second node becomes the new first node.

---

## Algorithm

1. Check whether the linked list is empty.
2. If it is empty, terminate the operation.
3. Move the `head` reference to the next node.
4. The original first node is automatically removed from the list.

---

## Dry Run

Initial List

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Current Head

```
head = 10
```

Execute

```java
head = head.next;
```

New Head

```
head
 ↓
20 → 30 → 40 → null
```

Node **10** is no longer part of the linked list.

---

## Why don't we write `head.next = null`?

A common misconception is that we must disconnect the first node manually.

This is unnecessary.

Once `head` moves to the second node,

```java
head = head.next;
```

there is no reference from the linked list to the original first node.

Since it is unreachable, Java's Garbage Collector automatically reclaims its memory.

---

## Pointer Movement

Before

```
head
 ↓
10 → 20 → 30 → null
```

After

```
head
      ↓
20 → 30 → null
```

Only the `head` reference changes.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Delete from Beginning | **O(1)** |

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

No deletion is performed.

---

### Single Node

Before

```
head
 ↓
10 → null
```

After

```
head = null
```

The list becomes empty.

---

### Multiple Nodes

Before

```
10 → 20 → 30
```

After

```
20 → 30
```

---

## Common Mistakes

- Forgetting to check whether the list is empty.
- Assuming `head.next = null` is required.
- Confusing moving the `head` reference with modifying node links.

---

## Summary

- Deleting the first node requires updating only the `head` reference.
- No traversal is required.
- No node links are modified.
- This is one of the most efficient linked list operations with **O(1)** time complexity.

---

## Related Problems

- Insert at Beginning
- Delete from End
- Delete by Value
- Reverse Linked List
