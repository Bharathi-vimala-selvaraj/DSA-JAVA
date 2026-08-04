# Remove Duplicates from a Sorted Linked List

## Overview

Remove all duplicate nodes from a **sorted** linked list.

Only one copy of each value should remain.

The algorithm works **in-place**, without creating any new nodes.

---

## Visual Representation

Before

```
head
 ↓
10 → 20 → 20 → 30 → 30 → 30 → 40 → null
```

After

```
head
 ↓
10 → 20 → 30 → 40 → null
```

---

# 🧠 Think Like the Pointer

Imagine people are standing in a line arranged by their roll numbers.

```
10

↓

20

↓

20

↓

30

↓

30
```

Since the list is already sorted,

duplicates always stand **next to each other**.

Therefore,

instead of comparing every node with every other node,

we only compare

```
Current Node

↓

Next Node
```

If both values are equal,

remove the next node.

Otherwise,

move forward.

---

## Core Idea

Only one pointer is required.

```
curr
```

At every step,

compare

```
curr.data

and

curr.next.data
```

If they are equal,

skip the duplicate node.

Otherwise,

move to the next node.

---

## Key Snippets

### Handle Empty and Single Node Lists

```java
if(head == null || head.next == null){
    return;
}
```

---

### Compare Adjacent Nodes

```java
if(curr.data == curr.next.data)
```

Since the list is sorted,

duplicates are always adjacent.

---

### Remove Duplicate

```java
curr.next = curr.next.next;
```

The duplicate node is bypassed.

---

### Move Forward

```java
curr = curr.next;
```

Move only when the current value is unique.

---

# 🧠 Why don't we move `curr` after deleting?

Suppose

```
10 → 20 → 20 → 20 → 30
```

Current

```
curr

↓

20
```

Delete one duplicate.

Result

```
10 → 20 → 20 → 30
```

Should `curr` move?

No.

Why?

Because another duplicate may still exist.

We must compare

```
20

↓

20
```

again.

Only after all duplicates are removed do we move forward.

---

## Dry Run

Initial List

```
10 → 20 → 20 → 30 → 30 → 40
```

Compare

```
10

20
```

Different

Move.

---

Compare

```
20

20
```

Equal

Delete duplicate.

List becomes

```
10 → 20 → 30 → 30 → 40
```

Stay on

```
20
```

Compare again.

```
20

30
```

Different.

Move.

---

Compare

```
30

30
```

Equal.

Delete duplicate.

Final

```
10 → 20 → 30 → 40
```

---

# 🚨 What Happens If...

### You move `curr` after deletion

Wrong

```java
curr.next = curr.next.next;

curr = curr.next;
```

Example

```
20 → 20 → 20
```

After deleting the second node,

you move to the third node.

The remaining duplicate is never checked.

Result

```
20 → 20
```

One duplicate remains.

---

### You compare non-adjacent nodes

Example

```
10 → 20 → 20 → 30
```

There is no need.

Because the list is already sorted,

duplicates always appear together.

---

## Algorithm

1. Handle empty and single-node lists.
2. Start from the head.
3. Compare the current node with the next node.
4. If equal, remove the next node.
5. Otherwise, move to the next node.
6. Repeat until the end of the list.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Remove Duplicates | **O(n)** |

Each node is visited at most once.

---

## Space Complexity

| Operation | Complexity |
|-----------|------------|
| Extra Space | **O(1)** |

No additional data structures are used.

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
10
```

No duplicates.

---

### No Duplicates

```
10 → 20 → 30
```

The list remains unchanged.

---

### All Duplicates

```
10 → 10 → 10 → 10
```

Result

```
10
```

---

## Common Mistakes

- Moving `curr` immediately after deleting a duplicate.
- Forgetting to handle empty or single-node lists.
- Assuming this works for unsorted linked lists.
- Creating new nodes unnecessarily.

---

## Pointer Rules Learned

### Rule 1

When deleting consecutive duplicates,

stay on the current node until all duplicates are removed.

---

### Rule 2

Never move a pointer unless the current work is complete.

---

### Rule 3

Sorted data often reduces unnecessary comparisons.

---

## Interview Insight

**Q:** Why does this algorithm only work for sorted linked lists?

**A:** Because duplicates appear next to each other. In an unsorted linked list, equal values may be far apart, requiring extra memory (such as a HashSet) or a nested traversal.

---

## Summary

The algorithm traverses the list once, compares adjacent nodes, removes duplicates in-place, and only moves forward when the current node is guaranteed to be unique.

It runs in **O(n)** time using **O(1)** extra space.

---

## Related Problems

- Remove Duplicates from an Unsorted Linked List
- Delete by Value
- Merge Two Sorted Linked Lists
- Remove Elements
