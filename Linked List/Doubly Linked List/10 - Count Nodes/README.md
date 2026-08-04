# Count Nodes in Doubly Linked List

## Overview

Counting nodes determines the total number of elements present in a Doubly Linked List.

Although each node stores both `prev` and `next` references, counting only requires moving in the forward direction.

---

## Visual Representation

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Count

```
10 → 1

↓

20 → 2

↓

30 → 3

↓

40 → 4
```

Final Answer

```
4
```

---

# What's Different from Singly Linked List?

Nothing.

The additional `prev` pointer is not required.

Traversal still follows

```
next
```

until the end of the list.

---

# Similarity with Singly Linked List

The algorithm is identical.

```
Start

↓

Visit Node

↓

Increase Count

↓

Move Forward

↓

Repeat
```

---

# 🧠 Think Like the Pointer

Imagine counting students standing in a line.

```
10

↓

20

↓

30

↓

40
```

You don't need to remember who is behind each student.

You only move forward.

Each time you meet one student,

increase the count.

---

## Core Idea

Every node contributes exactly one to the total count.

```
Visit Node

↓

count++

↓

Move Forward
```

Continue until

```
temp == null
```

---

## Key Snippets

### Initialize Counter

```java
int count = 0;
```

---

### Start Traversal

```java
Node temp = head;
```

---

### Count Each Node

```java
count++;
```

---

### Move Forward

```java
temp = temp.next;
```

---

### Return Answer

```java
return count;
```

---

## Dry Run

Initial List

```
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Start

```
count = 0
```

Visit 10

```
count = 1
```

Visit 20

```
count = 2
```

Visit 30

```
count = 3
```

Visit 40

```
count = 4
```

Reach

```
null
```

Return

```
4
```

---

## Algorithm

1. Initialize the count to zero.
2. Start from the head.
3. Visit each node.
4. Increase the count.
5. Move to the next node.
6. Repeat until reaching `null`.
7. Return the final count.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Count Nodes | **O(n)** |

Every node is visited exactly once.

---

## Space Complexity

| Operation | Complexity |
|-----------|------------|
| Extra Space | **O(1)** |

Only one traversal pointer and one counter are used.

---

## Edge Cases

### Empty List

```
head = null
```

Result

```
0
```

---

### Single Node

```
10
```

Result

```
1
```

---

### Multiple Nodes

```
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Result

```
4
```

---

## Common Mistakes

- Forgetting `count++`.
- Forgetting `temp = temp.next`.
- Returning before traversal completes.
- Assuming the `prev` pointer must be used.

---

## Pointer Rule Learned

**Use only the pointers required for the problem.**

Although a Doubly Linked List provides both

```
prev
```

and

```
next
```

counting requires only forward traversal.

---

## Interview Insight

**Q:** Can counting nodes be performed in O(1) time?

**A:** Yes, if the linked list maintains a separate `size` variable that is updated during every insertion and deletion. Otherwise, traversal is required, resulting in **O(n)** time complexity.

---

## Summary

Counting nodes follows a simple repeating pattern:

```
Visit Node

↓

Increase Count

↓

Move Forward

↓

Repeat
```

Every node contributes exactly one to the final answer.

---

## Related Problems

- Search
- Find Length (Recursive)
- Find Middle Node
- Reverse Doubly Linked List
