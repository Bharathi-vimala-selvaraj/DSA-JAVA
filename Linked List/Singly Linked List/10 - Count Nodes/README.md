# Count Nodes in Singly Linked List

## Overview

Counting nodes determines the total number of nodes present in a linked list.

Since a linked list does not store its size, every node must be visited once to calculate the total count.

---

## Visual Representation

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Number of Nodes

```
4
```

---

## 🧠 Think Like the Pointer

Imagine you're counting the number of people standing in a line.

```
👤  👤  👤  👤
```

You don't know how many people are there.

So for every person you see,

```
Count++

Move Forward
```

You never skip a person.

You never count the same person twice.

That's exactly how this algorithm works.

---

## Core Idea

Start from the head.

Visit every node exactly once.

Increase the counter for each node visited.

When there are no more nodes, the counter contains the total number of nodes.

---

## Key Snippets

### Initialize Counter

```java
int count = 0;
```

---

### Count the Current Node

```java
count++;
```

Every visited node increases the count by one.

---

### Move to the Next Node

```java
temp = temp.next;
```

Continue until the end of the list.

---

## Algorithm

1. Initialize a counter with `0`.
2. Start from the head node.
3. Increase the counter for every node visited.
4. Move to the next node.
5. Repeat until `temp` becomes `null`.
6. Return the counter.

---

## Dry Run

```
head
 ↓
10 → 20 → 30 → 40 → null
```

| Current Node | Count |
|--------------|------:|
| 10 | 1 |
| 20 | 2 |
| 30 | 3 |
| 40 | 4 |

Pointer Movement

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

Return

```
4
```

---

## 🧠 Why do we initialize the count to 0?

At the beginning, no node has been visited.

```
Visited Nodes = 0
```

Only after visiting a node do we increase the count.

This ensures that an empty linked list correctly returns `0`.

---

## 🚨 What Happens If...

### You forget

```java
count++;
```

The pointer traverses the entire list, but the count always remains

```
0
```

---

### You forget

```java
temp = temp.next;
```

```
10 → 20 → 30
↑
temp
```

The pointer never moves.

The loop becomes infinite.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Count Nodes | **O(n)** |

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

Return

```
0
```

---

### Single Node

```
head
 ↓
10 → null
```

Return

```
1
```

---

### Multiple Nodes

```
10 → 20 → 30 → 40
```

Return

```
4
```

---

## Common Mistakes

- Forgetting `count++`.
- Forgetting `temp = temp.next`.
- Starting the counter at `1`.
- Returning before the traversal completes.

---

## Summary

- Every node contributes exactly one to the count.
- Visit each node once.
- Count while traversing.
- Return the final count after reaching the end of the list.

---

## Related Problems

- Search
- Find Maximum
- Find Minimum
- Sum of Nodes
- Traversal
