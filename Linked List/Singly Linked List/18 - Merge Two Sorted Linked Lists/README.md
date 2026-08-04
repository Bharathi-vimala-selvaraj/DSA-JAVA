# Merge Two Sorted Linked Lists

## Overview

Merge two **already sorted** linked lists into a single sorted linked list.

The merge is performed by **reusing the existing nodes**.

No new nodes are created.

---

## Visual Representation

List 1

```
10 → 30 → 50
```

List 2

```
20 → 40 → 60
```

Merged List

```
10 → 20 → 30 → 40 → 50 → 60
```

---

# 🧠 Think Like the Pointer

Imagine two students are standing in two separate queues.

Queue A

```
10

↓

30

↓

50
```

Queue B

```
20

↓

40

↓

60
```

You have one empty result queue.

Every time, compare the students at the **front**.

Whoever has the smaller number joins the result first.

Repeat until one queue becomes empty.

Then simply attach the remaining queue.

---

## Core Idea

Three pointers are used.

```
head1
```

Current node of the first list.

```
head2
```

Current node of the second list.

```
tail
```

Always points to the last node of the merged list.

---

## Key Snippets

### Handle Empty Lists

```java
if(head1 == null){
    return head2;
}

if(head2 == null){
    return head1;
}
```

---

### Choose the First Node

```java
if(head1.data <= head2.data){
```

The smaller node becomes the head of the merged list.

---

### Attach the Smaller Node

```java
tail.next = head1;
```

or

```java
tail.next = head2;
```

---

### Move Tail

```java
tail = tail.next;
```

Tail always remains at the end of the merged list.

---

### Attach Remaining Nodes

```java
tail.next = head1;
```

or

```java
tail.next = head2;
```

Once one list finishes,

the other list is already sorted.

No more comparisons are required.

---

# 🧠 Why do we need a Tail Pointer?

Suppose we only keep

```
head
```

```
10
```

↓

```
20
```

↓

```
30
```

How do we attach

```
40
```

Without a tail pointer,

we would have to traverse from the beginning every time.

That would make the algorithm

```
O(n²)
```

Tail gives direct access to the end.

---

## Dry Run

List A

```
10 → 30 → 50
```

List B

```
20 → 40 → 60
```

Compare

```
10 vs 20
```

Take

```
10
```

Compare

```
30 vs 20
```

Take

```
20
```

Compare

```
30 vs 40
```

Take

```
30
```

Compare

```
50 vs 40
```

Take

```
40
```

Compare

```
50 vs 60
```

Take

```
50
```

List A ends.

Attach

```
60
```

Final

```
10 → 20 → 30 → 40 → 50 → 60
```

---

# 🚨 What Happens If...

### You forget

```java
tail = tail.next;
```

Example

```
10
```

↓

Attach

```
20
```

↓

Attach

```
30
```

Everything keeps replacing

```
10.next
```

The merged list becomes incorrect.

---

### You forget the remaining nodes

Example

List A

```
10 → 20
```

List B

```
30 → 40 → 50
```

After comparisons,

```
30 → 40 → 50
```

is lost.

Always attach the remaining list.

---

## Algorithm

1. Handle empty lists.
2. Choose the smaller first node as the merged head.
3. Maintain a `tail` pointer.
4. Compare current nodes of both lists.
5. Attach the smaller node.
6. Move the corresponding pointer.
7. Move `tail`.
8. Attach the remaining list.
9. Return the merged head.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Merge | **O(n + m)** |

---

## Space Complexity

| Operation | Complexity |
|----------|------------|
| Extra Space | **O(1)** |

---

## Edge Cases

### First List Empty

```
null
```

+

```
10 → 20
```

Return

```
10 → 20
```

---

### Second List Empty

Return the first list.

---

### Duplicate Values

```
10 → 20 → 20
```

+

```
20 → 30
```

Merged

```
10 → 20 → 20 → 20 → 30
```

---

### Different Sizes

```
10 → 30
```

+

```
20 → 40 → 50 → 60
```

Works correctly.

---

## Common Mistakes

- Forgetting to move `tail`.
- Forgetting to move `head1` or `head2`.
- Forgetting to attach the remaining list.
- Creating unnecessary new nodes.
- Losing the head pointer.

---

## Pointer Rules Learned

### Rule 1

Always keep a pointer to the end of the result list.

---

### Rule 2

Move only the pointer whose node was selected.

---

### Rule 3

Once one sorted list ends, the remaining list can be attached directly.

---

## Interview Insight

**Q:** Why don't we compare the remaining nodes after one list becomes empty?

**A:** Because both input lists are already sorted. Every remaining node in the non-empty list is greater than or equal to the last inserted node, so they can be appended directly.

---

## Summary

This algorithm merges two sorted linked lists by repeatedly choosing the smaller current node and extending the result list using a `tail` pointer.

It is an in-place algorithm with **O(n + m)** time and **O(1)** extra space.

---

## Related Problems

- Merge K Sorted Lists
- Intersection of Two Linked Lists
- Sort a Linked List
- Remove Duplicates
