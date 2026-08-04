# Sum of Nodes in Singly Linked List

## Overview

The Sum of Nodes operation calculates the total of all values stored in a linked list.

Since the values are distributed across multiple nodes, every node must be visited exactly once to compute the final sum.

---

## Visual Representation

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Sum

```
10 + 20 + 30 + 40 = 100
```

---

# 🧠 Think Like the Pointer

Imagine you have a wallet.

Initially,

```
Money = ₹0
```

Now someone gives you

```
₹10
```

Your wallet becomes

```
₹10
```

Another person gives you

```
₹20
```

Now your wallet contains

```
₹30
```

Then

```
₹30
```

Your wallet becomes

```
₹60
```

Finally

```
₹40
```

Your wallet becomes

```
₹100
```

The wallet always stores the **running total**.

The variable

```java
sum
```

works exactly like that wallet.

---

## Core Idea

Create a variable to store the running total.

Visit every node.

Add the current node's value to the running total.

Continue until the end of the list.

The final total is the answer.

---

## Key Snippets

### Initialize the Running Total

```java
int sum = 0;
```

Initially, no node has been visited.

Therefore, the total is zero.

---

### Add the Current Node

```java
sum += temp.data;
```

Equivalent to

```java
sum = sum + temp.data;
```

---

### Move to the Next Node

```java
temp = temp.next;
```

Continue until every node has been processed.

---

## Algorithm

1. Initialize the sum with `0`.
2. Start from the head node.
3. Add the current node's value to the sum.
4. Move to the next node.
5. Repeat until the end of the list.
6. Return the final sum.

---

## Dry Run

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Initial

```
sum = 0
```

Visit **10**

```
sum = 0 + 10

sum = 10
```

Visit **20**

```
sum = 10 + 20

sum = 30
```

Visit **30**

```
sum = 30 + 30

sum = 60
```

Visit **40**

```
sum = 60 + 40

sum = 100
```

Return

```
100
```

---

# 🧠 Why do we initialize `sum` to 0?

Before visiting any node,

```
No values have been added.
```

So the correct starting total is

```
0
```

Every node contributes its value exactly once.

---

# 🚨 What Happens If...

### You initialize

```java
int sum = head.data;
```

and still start traversing from

```java
temp = head;
```

Example

```
10 → 20 → 30
```

Computation

```
sum = 10

Visit 10

sum = 20

Visit 20

sum = 40

Visit 30

sum = 70
```

Correct answer

```
60
```

The first node was counted twice.

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
| Sum of Nodes | **O(n)** |

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
25 → null
```

Return

```
25
```

---

### Negative Values

```
10 → -5 → 20 → -15
```

Sum

```
10
```

---

### All Zeroes

```
0 → 0 → 0
```

Return

```
0
```

---

## Common Mistakes

- Initializing the sum incorrectly.
- Counting the first node twice.
- Forgetting `temp = temp.next`.
- Returning before visiting every node.

---

## Summary

- Maintain a running total while traversing.
- Every node contributes exactly once.
- Initialize the sum with `0`.
- Return the accumulated total after reaching the end of the list.

---

## Related Problems

- Count Nodes
- Find Maximum
- Find Minimum
- Search
