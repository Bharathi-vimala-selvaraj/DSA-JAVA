# Insert Before a Value in Singly Linked List

## Overview

Insert a new node immediately before the first occurrence of a given value.

Unlike **Insert After**, this operation requires access to the **previous node**, because a singly linked list only stores the `next` pointer.

---

## Visual Representation

Before

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Insert **25** before **30**

After

```
head
 ↓
10 → 20 → 25 → 30 → 40 → null
```

---

# 🧠 Think Like the Pointer

Suppose you're standing at

```
30
```

Can you insert before it?

No.

Why?

Because a singly linked list only allows movement like this:

```
10 → 20 → 30 → 40
```

There is **no arrow pointing backward**.

Node **30** has no idea who points to it.

Therefore, while traversing, we must always remember:

```
prev

↓

10 → 20 → 30 → 40
          ↑
         curr
```

Now we can insert between them.

---

## Core Idea

To insert before a node, two links must be updated.

```
prev → newNode → curr
```

That means we need both `prev` and `curr`.

---

## Key Snippets

### Handle Empty List

```java
if(head == null){
    return;
}
```

---

### Insert Before Head

```java
node.next = head;
head = node;
```

If the target value is in the first node, the new node simply becomes the new head.

---

### Connect the New Node

```java
node.next = curr;
```

The new node points to the target node.

---

### Connect the Previous Node

```java
prev.next = node;
```

The previous node now points to the new node.

---

# 🧠 Why do we need `prev`?

Suppose

```
10 → 20 → 30
          ↑
         curr
```

Can `30` insert something before itself?

No.

Because `30` doesn't know who points to it.

Only `20` knows.

That's why we carry

```
prev
```

throughout the traversal.

---

## Dry Run

Initial List

```
10 → 20 → 30 → 40
```

Find

```
30
```

Pointers

```
prev → 20

curr → 30
```

Create

```
25
```

Step 1

```
25 → 30
```

Step 2

```
20 → 25
```

Final

```
10 → 20 → 25 → 30 → 40
```

---

## Algorithm

1. Handle the empty list.
2. Check whether the head contains the target value.
3. Initialize `prev` and `curr`.
4. Traverse the list.
5. If the value is found:
   - Create a new node.
   - Point the new node to `curr`.
   - Point `prev` to the new node.
6. Stop after insertion.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Insert Before Value | **O(n)** |

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

Nothing is inserted.

---

### Insert Before Head

Before

```
10 → 20 → 30
```

Insert **5** before **10**

Result

```
5 → 10 → 20 → 30
```

---

### Value Not Found

The list remains unchanged.

---

### Single Node

Before

```
10
```

Insert **5** before **10**

Result

```
5 → 10
```

---

## Common Mistakes

- Forgetting to handle insertion before the head.
- Using only `curr` without keeping `prev`.
- Updating `prev.next` before `node.next`.
- Forgetting to stop after insertion.

---

## Pointer Rule Learned

**In a singly linked list, you cannot move backward. If an operation needs the previous node, you must remember it while traversing.**

---

## Interview Insight

**Q:** Why is Insert Before more difficult than Insert After?

**A:** Because each node stores only the `next` pointer. There is no way to reach the previous node from the current node, so we must maintain a separate `prev` pointer during traversal.

---

## Summary

Insert Before Value is a two-pointer insertion problem.

The sequence is:

```
Find Previous

↓

Create Node

↓

newNode → curr

↓

prev → newNode
```

Understanding this pattern also prepares you for deletion algorithms, where both `prev` and `curr` are required.

---

## Related Problems

- Delete by Value
- Delete by Position
- Insert After a Value
- Insert at Position
