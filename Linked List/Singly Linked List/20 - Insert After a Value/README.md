# Insert After a Value in Singly Linked List

## Overview

Insert a new node immediately after the first occurrence of a given value.

If the value is not present, the linked list remains unchanged.

---

## Visual Representation

Before

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Insert **25** after **20**

After

```
head
 ↓
10 → 20 → 25 → 30 → 40 → null
```

---

# 🧠 Think Like the Pointer

Imagine you're standing on the node containing the target value.

```
10 → 20 → 30 → 40
      ↑
    current
```

You want to place a new node immediately after `20`.

But notice something.

```
20
 ↓
30
```

If you simply write

```java
curr.next = node;
```

what happens?

```
20 → newNode

30 ❌ Lost
```

The connection to `30` disappears.

So before changing anything,

save the old connection inside the new node.

---

## Core Idea

The new node must point to the node that originally followed the target node.

Only after preserving that connection should the current node point to the new node.

---

## Key Snippets

### Save the Remaining List

```java
node.next = curr.next;
```

The new node remembers where the list continues.

---

### Connect the Current Node

```java
curr.next = node;
```

The current node now points to the new node.

---

# 🧠 Why this order?

Suppose

```
20 → 30
```

Wrong order

```java
curr.next = node;
node.next = curr.next;
```

After the first line

```
20 → newNode

30 ❌ Lost
```

Now

```java
curr.next
```

already points to the new node.

The original `30` can never be reached again.

Correct order

```java
node.next = curr.next;
curr.next = node;
```

Nothing is lost.

---

## Dry Run

Before

```
10 → 20 → 30 → 40
```

Find

```
20
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

1. Traverse the linked list.
2. Search for the target value.
3. Create a new node.
4. Make the new node point to the current node's next.
5. Make the current node point to the new node.
6. Stop.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Insert After Value | **O(n)** |

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

### Value Not Found

The list remains unchanged.

---

### Insert After Last Node

Before

```
10 → 20 → 30
```

Insert `40` after `30`

Result

```
10 → 20 → 30 → 40
```

---

## Common Mistakes

- Writing `curr.next = node` before `node.next = curr.next`.
- Forgetting to stop after insertion.
- Not handling an empty list.
- Losing the remaining list by overwriting `curr.next`.

---

## Pointer Rule Learned

**Always preserve the existing connection before creating a new one.**

---

## Interview Insight

**Q:** Why do we assign `node.next` before `curr.next`?

**A:** Because `curr.next` contains the only reference to the remaining list. Once it is overwritten, the remaining nodes become unreachable.

---

## Summary

Insert After Value is a two-pointer reassignment problem.

The order of assignments is crucial:

```
Save Remaining List

↓

Connect New Node

↓

Finish Insertion
```

---

## Related Problems

- Insert at Position
- Insert at Beginning
- Insert at End
- Delete After a Value
