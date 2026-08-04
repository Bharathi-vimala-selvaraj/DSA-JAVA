# Find Minimum in Singly Linked List

## Overview

Finding the minimum element returns the smallest value present in the linked list.

Since linked lists do not support random access, every node must be visited exactly once to determine the minimum value.

---

## Visual Representation

```
head
 ↓
15 → 8 → 27 → 12 → 5 → null
```

Minimum Value

```
5
```

---

# 🧠 Think Like the Pointer

Imagine you're judging a race to find the **shortest person** in a line.

```
15

↓

8

↓

27

↓

12

↓

5
```

At the beginning, you don't know who is the shortest.

So you assume

> "The first person is the shortest."

Then every new person arrives.

Ask only one question.

> **Is this person smaller than the current shortest?**

If **Yes**

Replace the current shortest.

If **No**

Keep the existing one.

Continue until everyone has been checked.

The final person remaining is the minimum value.

---

## Core Idea

Assume the first node contains the minimum value.

Traverse the remaining nodes.

Whenever a smaller value is found, update the minimum.

After reaching the end of the list, the stored value is the smallest element.

---

## Key Snippets

### Handle an Empty List

```java
if(head == null){
    throw new IllegalStateException("Linked List is Empty");
}
```

---

### Assume the First Node is Minimum

```java
int min = head.data;
```

The first node becomes the initial minimum.

---

### Traverse Remaining Nodes

```java
Node temp = head.next;
```

The first node has already been considered.

---

### Update the Minimum

```java
if(temp.data < min){
    min = temp.data;
}
```

Whenever a smaller value is found, update the minimum.

---

## Algorithm

1. Check whether the linked list is empty.
2. Assume the first node contains the minimum value.
3. Traverse the remaining nodes.
4. Compare each node with the current minimum.
5. Update the minimum whenever a smaller value is found.
6. Return the minimum value.

---

# 🧠 Why do we start from `head.next`?

Initially,

```
min = head.data
```

Suppose

```
head
 ↓
15 → 8 → 27 → 12
```

The first node (**15**) has already been considered.

Starting again from `head` would compare

```
15 < 15 ?
```

which is unnecessary.

Starting from

```java
head.next
```

avoids one redundant comparison.

---

## Dry Run

```
head
 ↓
15 → 8 → 27 → 12 → 5 → null
```

Initial

```
min = 15
```

Visit **8**

```
8 < 15 ?

Yes

min = 8
```

Visit **27**

```
27 < 8 ?

No
```

Visit **12**

```
12 < 8 ?

No
```

Visit **5**

```
5 < 8 ?

Yes

min = 5
```

Final Answer

```
5
```

---

# 🚨 What Happens If...

### You initialize

```java
int min = 0;
```

Consider

```
8 → 12 → 15
```

Your answer becomes

```
0
```

which is incorrect because `0` does not exist in the list.

Always initialize using

```java
head.data
```

---

### You forget

```java
temp = temp.next;
```

```
15 → 8 → 27
↑
temp
```

The pointer never moves.

The loop becomes infinite.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Find Minimum | **O(n)** |

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

Throws an exception (or returns a sentinel value depending on implementation).

---

### Single Node

```
head
 ↓
25 → null
```

Minimum

```
25
```

---

### All Equal Values

```
10 → 10 → 10
```

Minimum

```
10
```

---

### Negative Numbers

```
-8 → -2 → -15 → -4
```

Minimum

```
-15
```

---

## Common Mistakes

- Initializing `min` with `0` instead of `head.data`.
- Forgetting to handle an empty list.
- Starting traversal from `head` after already considering the first node.
- Forgetting `temp = temp.next`.

---

## Summary

- Assume the first node is the current minimum.
- Compare every remaining node with the current minimum.
- Update the minimum whenever a smaller value is found.
- The final stored value is the smallest element in the linked list.

---

## Related Problems

- Find Maximum
- Sum of Nodes
- Count Nodes
- Search
