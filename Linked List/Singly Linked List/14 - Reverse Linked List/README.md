# Reverse Linked List

## Overview

Reversing a linked list changes the direction of every `next` pointer.

Before:

```
head
 ↓
10 → 20 → 30 → 40 → null
```

After:

```
head
 ↓
40 → 30 → 20 → 10 → null
```

The nodes remain the same.

Only the connections between nodes change.

---

# 🧠 Think Like the Pointer

A linked list is a chain of arrows.

Before:

```
10 → 20 → 30 → 40 → null
```

Each node knows only about the node after it.

To reverse it, every arrow must point backwards.

We need three pointers:

```
prev
curr
next
```

Their responsibilities:

| Pointer | Job |
|---|---|
| prev | Stores the already reversed part |
| curr | Node currently being reversed |
| next | Saves the remaining list |

---

# Why do we need three pointers?

Suppose we are at node 20.

```
10 → 20 → 30 → 40
     ↑
    curr
```

We want:

```
20 → 10
```

But before changing:

```java
curr.next = prev;
```

we must remember where 30 is.

Otherwise:

```
10 ← 20    30 → 40
```

The connection to the remaining list is lost.

That is why we first save:

```java
next = curr.next;
```

---

# Core Algorithm

The algorithm follows four pointer movements:

## Step 1: Save the next node

```java
Node next = curr.next;
```

Protect the remaining list.

---

## Step 2: Reverse the current pointer

```java
curr.next = prev;
```

Make the current node point backwards.

---

## Step 3: Move prev forward

```java
prev = curr;
```

The reversed part grows.

---

## Step 4: Move curr forward

```java
curr = next;
```

Continue with the remaining list.

---

# 🧠 Pointer Visualization

Initial State

```
prev

↓

null


curr

↓

10 → 20 → 30 → 40 → null
```

---

## First Iteration

Save next:

```
next

↓

20


curr

↓

10 → 20 → 30
```

Reverse:

```
10 → null
```

Move prev:

```
prev

↓

10 → null
```

Move curr:

```
curr

↓

20 → 30 → 40
```

---

## Second Iteration

Save next:

```
next

↓

30
```

Reverse:

```
20 → 10 → null
```

Move:

```
prev

↓

20 → 10 → null


curr

↓

30 → 40
```

---

## Third Iteration

Reverse:

```
30 → 20 → 10 → null
```

Move:

```
prev

↓

30 → 20 → 10


curr

↓

40
```

---

## Fourth Iteration

Reverse:

```
40 → 30 → 20 → 10 → null
```

Now:

```
curr = null
```

Loop stops.

---

Finally:

```java
head = prev;
```

New head:

```
40 → 30 → 20 → 10 → null
```

---

# 🧠 Why does the loop stop at curr == null?

At the end:

```
prev

↓

40 → 30 → 20 → 10 → null


curr

↓

null
```

Every node has already been reversed.

There is no remaining node to process.

---

# 🚨 What Happens If...

## Mistake 1: Reverse before saving next

Wrong:

```java
curr.next = prev;

next = curr.next;
```

Problem:

After

```
curr.next = prev
```

the original connection is destroyed.

Example:

Before:

```
20 → 30
```

After:

```
20 → 10
```

Where did 30 go?

Lost.

---

## Mistake 2: Move curr before reversing

Wrong order:

```
curr = curr.next

curr.next = prev
```

You moved away from the node before changing it.

The algorithm loses control.

---

## Mistake 3: Forgetting

```java
head = prev;
```

The nodes are reversed, but the head still points to the old first node.

Result:

```
10 → null
```

The remaining reversed list becomes unreachable.

---

# Algorithm

1. Initialize:
   
```
prev = null
curr = head
```

2. While current node exists:

   - Save next node.
   - Reverse current node's pointer.
   - Move prev.
   - Move current.

3. Update head to prev.

---

# Time Complexity

| Operation | Complexity |
|---|---|
| Reverse Linked List | O(n) |

Every node is visited once.

---

# Space Complexity

| Operation | Complexity |
|---|---|
| Extra Space | O(1) |

Only three pointer variables are used.

---

# Edge Cases

## Empty List

```
head = null
```

Result:

```
null
```

---

## Single Node

Before:

```
10 → null
```

After:

```
10 → null
```

No change.

---

## Two Nodes

Before:

```
10 → 20 → null
```

After:

```
20 → 10 → null
```

---

# Common Mistakes

- Changing `curr.next` before saving `next`.
- Forgetting to update `head`.
- Moving pointers in the wrong order.
- Confusing node movement with pointer reversal.
- Using extra nodes unnecessarily.

---

# Pointer Rules Learned

## Rule 1

Never modify a pointer before saving the information it contains.

---

## Rule 2

The pointer you are changing determines what information you must protect.

---

## Rule 3

A linked list algorithm is mostly about controlling references, not data.

---

## Rule 4

Always know:

```
What part is completed?

What part is remaining?
```

---

# Interview Insight

### Q:
Why do we need a temporary variable?

### Answer:

Because after reversing `curr.next`, the original connection to the remaining list is destroyed. The temporary variable preserves that reference before modification.

---

### Q:
Can we reverse a linked list without extra space?

### Answer:

Yes.

The algorithm uses constant extra space because only three pointers are maintained.

---

## Summary

Reverse Linked List is a pointer manipulation problem.

The entire algorithm depends on maintaining three references:

```
prev → reversed part

curr → current node

next → remaining list
```

The order is critical:

```
Save

↓

Reverse

↓

Move prev

↓

Move curr
```

Understanding this pattern makes many advanced linked list problems easier.

---

## Related Problems

- Reverse Linked List Recursive
- Reverse Doubly Linked List
- Reverse Nodes in Groups
- Palindrome Linked List
- Detect Cycle
