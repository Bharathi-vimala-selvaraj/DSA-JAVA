# Search in Doubly Linked List

## Overview

Search determines whether a given value exists in a Doubly Linked List.

Although each node stores both `prev` and `next`, searching still proceeds one node at a time.

Both iterative and recursive approaches visit nodes sequentially.

---

## Visual Representation

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Search

```
30
```

Traversal

```
10

↓

20

↓

30 ✓
```

---

# What's Different from Singly Linked List?

Almost nothing.

Searching only requires moving forward.

The `prev` pointer is never used.

```
10 ⇄ 20 ⇄ 30
```

Traversal still follows

```
next
```

---

# Similarity with Singly Linked List

Exactly the same algorithm.

```
temp = head

↓

while(temp != null)

↓

Compare

↓

Move Forward
```

The only difference is the node structure contains an additional `prev` field.

---

# 🧠 Think Like the Pointer

Imagine checking each locker in a hallway.

```
10

↓

20

↓

30

↓

40
```

You stop immediately when the required value is found.

If you reach the end,

the value doesn't exist.

The existence of a `prev` pointer doesn't help because you still don't know where the value is located.

---

## Core Idea

Visit every node until

```
temp.data == value
```

or

```
temp == null
```

---

## Key Snippets

### Iterative Traversal

```java
Node temp = head;

while(temp != null){
```

---

### Compare

```java
if(temp.data == value){
    return true;
}
```

---

### Move Forward

```java
temp = temp.next;
```

---

### Recursive Base Case

```java
if(head == null){
    return false;
}
```

---

### Recursive Step

```java
return searchRecursive(head.next, value);
```

---

## Dry Run

List

```
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Search

```
30
```

Traversal

```
10

↓

20

↓

30 ✓
```

Return

```
true
```

---

## Algorithm

### Iterative

1. Start from the head.
2. Compare each node.
3. Return `true` if found.
4. Otherwise move to the next node.
5. Return `false` after reaching `null`.

---

### Recursive

1. If the current node is `null`, return `false`.
2. Compare the current node.
3. If matched, return `true`.
4. Otherwise recursively search the next node.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Search | **O(n)** |

---

## Space Complexity

| Method | Complexity |
|--------|------------|
| Iterative | **O(1)** |
| Recursive | **O(n)** |

---

## Edge Cases

### Empty List

```
head = null
```

Returns

```
false
```

---

### Single Node

```
10
```

Search

```
10
```

Returns

```
true
```

---

### Value Not Found

```
10 ⇄ 20 ⇄ 30
```

Search

```
50
```

Returns

```
false
```

---

## Common Mistakes

- Forgetting `temp = temp.next`.
- Forgetting the base case in recursion.
- Assuming `prev` makes searching faster.
- Returning `false` too early inside the loop.

---

## Pointer Rule Learned

Not every Doubly Linked List algorithm uses the `prev` pointer.

Choose the simplest pointer that solves the problem.

For searching,

```
next
```

is sufficient.

---

## Interview Insight

**Q:** Why doesn't a Doubly Linked List improve search performance?

**A:** The `prev` pointer allows backward traversal but does not help locate an unknown value. Every node may still need to be examined, so the time complexity remains **O(n)**.

---

## Summary

Searching in a Doubly Linked List is identical to searching in a Singly Linked List.

```
Start

↓

Compare

↓

Move Forward

↓

Repeat
```

The extra `prev` pointer provides no advantage for this operation.

---

## Related Problems

- Count Nodes
- Find Maximum
- Delete by Value
- Reverse Doubly Linked List
