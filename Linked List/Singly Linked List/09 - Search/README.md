# Search in Singly Linked List

## Overview

Searching determines whether a given value exists in the linked list.

Since a linked list does not support direct indexing like an array, every node must be visited sequentially until the value is found or the list ends.

Both **Iterative** and **Recursive** approaches achieve the same result.

---

## Visual Representation

Search **30**

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Result

```
Found
```

---

Search **50**

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Result

```
Not Found
```

---

# 🧠 Think Like the Pointer

Imagine you're walking through a street looking for House **30**.

```
10

↓

20

↓

30

↓

40
```

At every house you ask only one question.

> "Are you the value I'm looking for?"

If **Yes**, stop immediately.

If **No**, move to the next house.

That's exactly how linked list searching works.

---

## Core Idea

Visit each node one by one.

If the current node contains the required value, stop searching.

Otherwise, move to the next node.

If the end of the list is reached, the value does not exist.

---

## Key Snippets

### Compare Current Node

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

### Base Case (Recursive)

```java
if(head == null){
    return false;
}
```

---

### Recursive Call

```java
return search(head.next, value);
```

---

## Algorithm (Iterative)

1. Start from the head.
2. Compare the current node with the target value.
3. If they match, return `true`.
4. Otherwise, move to the next node.
5. Repeat until the end of the list.
6. Return `false` if the value is not found.

---

## Dry Run

Search **30**

```
head
 ↓
10 → 20 → 30 → 40
```

Pointer Movement

```
temp = 10

↓

20

↓

30
```

Value found.

Return

```
true
```

---

Search **50**

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
false
```

---

# 🧠 Why don't we stop after checking only one node?

A linked list stores data in separate nodes connected by pointers.

Unlike an array, there is no direct access to a specific position.

The only way to know whether a value exists is to visit each node one by one.

---

# 🚨 What Happens If...

Suppose you forget

```java
temp = temp.next;
```

Then `temp` always points to the same node.

Example

```
10 → 20 → 30
↑
temp
```

The loop never progresses.

This results in an **infinite loop**.

---

## Iterative vs Recursive

| Iterative | Recursive |
|-----------|-----------|
| Uses a loop | Uses function calls |
| O(1) extra space | O(n) call stack |
| Faster | Easier to understand recursively |

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Search | **O(n)** |

---

## Space Complexity

| Method | Complexity |
|---------|------------|
| Iterative | **O(1)** |
| Recursive | **O(n)** |

---

## Edge Cases

### Empty List

```
head = null
```

Return

```
false
```

---

### First Node Matches

```
10 → 20 → 30
```

Search

```
10
```

Return immediately.

---

### Last Node Matches

```
10 → 20 → 30
```

Search

```
30
```

Traverse the entire list before returning.

---

### Value Not Present

```
10 → 20 → 30
```

Search

```
50
```

Return

```
false
```

---

## Common Mistakes

- Forgetting `temp = temp.next`.
- Comparing the wrong value.
- Forgetting the recursive base case.
- Assuming linked lists support direct indexing.

---

## Summary

- Search visits nodes sequentially.
- Stop immediately when the value is found.
- If the end of the list is reached, the value is not present.
- Iterative and recursive approaches produce the same result with different space usage.

---

## Related Problems

- Count Nodes
- Find Maximum
- Find Minimum
- Delete by Value
- Remove Duplicates
