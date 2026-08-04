# Find Maximum in Singly Linked List

## Overview

Finding the maximum element returns the node containing the largest value in the linked list.

Since a linked list does not allow direct access to its elements, every node must be visited exactly once to determine the maximum value.

---

## Visual Representation

```
head
 ↓
15 → 8 → 27 → 12 → 5 → null
```

Maximum Value

```
27
```

---

# 🧠 Think Like the Pointer

Imagine you're the judge of a competition.

Every participant comes one by one.

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

Initially, you don't know who will win.

So you say,

> "The first participant is the current champion."

As every new participant arrives, ask only one question.

> **Is this participant better than the current champion?**

If **Yes**

Replace the champion.

If **No**

Keep the current champion.

Continue until everyone has been checked.

The final champion is the maximum value.

---

## Core Idea

The first node is assumed to be the maximum.

Traverse the remaining nodes one by one.

Whenever a larger value is found, update the maximum.

After reaching the end of the list, the stored value is the largest element.

---

## Key Snippets

### Handle an Empty List

```java
if(head == null){
    throw new IllegalStateException("Linked List is Empty");
}
```

---

### Assume the First Node is Maximum

```java
int max = head.data;
```

Every comparison starts from this initial maximum.

---

### Traverse the Remaining Nodes

```java
Node temp = head.next;
```

The first node has already been considered.

Therefore, traversal begins from the second node.

---

### Update the Maximum

```java
if(temp.data > max){
    max = temp.data;
}
```

If a larger value is found, it becomes the new maximum.

---

## Algorithm

1. Check if the linked list is empty.
2. Assume the first node contains the maximum value.
3. Traverse the remaining nodes.
4. Compare each node with the current maximum.
5. Update the maximum whenever a larger value is found.
6. Return the maximum value.

---

# 🧠 Why do we start from `head.next`?

Initially,

```
max = head.data
```

Suppose

```
head
 ↓
15 → 8 → 27 → 12
```

The first node (**15**) has already been stored as the current maximum.

If we start traversal from the head again,

```
15 > 15 ?
```

The first comparison becomes unnecessary.

Starting from

```java
head.next
```

avoids this redundant comparison.

---

## Dry Run

```
head
 ↓
15 → 8 → 27 → 12 → 5 → null
```

Initial

```
max = 15
```

Visit **8**

```
8 > 15 ?

No

max = 15
```

Visit **27**

```
27 > 15 ?

Yes

max = 27
```

Visit **12**

```
12 > 27 ?

No
```

Visit **5**

```
5 > 27 ?

No
```

Final Answer

```
27
```

---

# 🚨 What Happens If...

### You initialize

```java
int max = 0;
```

Consider

```
-10 → -30 → -5
```

Your answer becomes

```
0
```

which is incorrect because `0` is not even in the list.

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
| Find Maximum | **O(n)** |

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

Throws an exception (or can return a sentinel value based on implementation).

---

### Single Node

```
head
 ↓
25 → null
```

Maximum

```
25
```

---

### All Equal Values

```
10 → 10 → 10
```

Maximum

```
10
```

---

### Negative Numbers

```
-8 → -2 → -15 → -4
```

Maximum

```
-2
```

---

## Common Mistakes

- Initializing `max` with `0` instead of `head.data`.
- Forgetting to handle an empty list.
- Starting traversal from `head` after already considering the first node.
- Forgetting `temp = temp.next`.

---

## Summary

- Assume the first node is the current maximum.
- Compare every remaining node with the current maximum.
- Update the maximum whenever a larger value is found.
- The final stored value is the largest element in the linked list.

---

## Related Problems

- Find Minimum
- Sum of Nodes
- Count Nodes
- Search
