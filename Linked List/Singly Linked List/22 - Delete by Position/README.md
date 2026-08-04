# Delete Node by Position in Singly Linked List

## Overview

Delete the node present at a given position in the linked list.

The first node is considered to be at **position 1**.

If the position is invalid, the linked list remains unchanged.

---

## Visual Representation

Before

```
Position

1     2     3     4

10 → 20 → 30 → 40 → null
```

Delete Position **3**

After

```
10 → 20 → 40 → null
```

---

# 🧠 Think Like the Pointer

Suppose we want to delete

```
30
```

Can we simply make

```
30 = null
```

No.

Because

```
20
```

still points to it.

The node that actually needs to change is

```
20
```

We simply make

```
20

↓

40
```

The node

```
30
```

becomes unreachable and is removed by Java's Garbage Collector.

---

## Core Idea

Deletion never changes the node being removed.

Instead,

the **previous node changes its next pointer**.

```
Before

20 → 30 → 40

After

20 → 40
```

---

## Key Snippets

### Empty List

```java
if(head == null){
    return;
}
```

---

### Delete First Node

```java
head = head.next;
```

The second node becomes the new head.

---

### Remove Middle or Last Node

```java
prev.next = curr.next;
```

The current node is skipped.

---

## Algorithm

1. Handle the empty list.
2. If the position is `1`, move the head.
3. Maintain `prev` and `curr`.
4. Traverse while counting positions.
5. When the desired position is reached:
   - Connect `prev.next` to `curr.next`.
6. Stop.

---

# 🧠 Why do we keep a Position Counter?

Unlike arrays,

linked lists have **no index**.

```
10 → 20 → 30 → 40
```

The nodes only know their next node.

So while traversing,

we manually count.

```
10 → Position 1

20 → Position 2

30 → Position 3
```

When the counter equals the required position,

we delete that node.

---

## Dry Run

Initial List

```
10 → 20 → 30 → 40
```

Delete Position

```
3
```

Traversal

```
prev → 20

curr → 30

index = 3
```

Update

```
20.next = 40
```

Final

```
10 → 20 → 40
```

---

# 🚨 What Happens If...

### You delete the current node

Wrong

```java
curr = null;
```

Result

```
20 → null
```

The remaining list

```
40
```

is lost.

---

### You forget the head case

Deleting Position

```
1
```

without

```java
head = head.next;
```

means the first node is never removed.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Delete by Position | **O(n)** |

---

## Space Complexity

| Operation | Complexity |
|-----------|------------|
| Extra Space | **O(1)** |

---

## Edge Cases

### Empty List

```
head = null
```

Nothing happens.

---

### Delete Head

```
10 → 20 → 30
```

↓

```
20 → 30
```

---

### Delete Last Node

```
10 → 20 → 30
```

↓

```
10 → 20
```

---

### Invalid Position

```
Position > Length
```

The list remains unchanged.

---

## Common Mistakes

- Forgetting to handle Position 1 separately.
- Using `curr = null` instead of changing `prev.next`.
- Forgetting to increment the position counter.
- Losing the remaining list by modifying the wrong pointer.

---

## Pointer Rule Learned

**Deletion is performed by changing the previous node, never the node being deleted.**

---

## Interview Insight

**Q:** Why do we need both `prev` and `curr`?

**A:** Because the current node cannot remove itself. The previous node owns the pointer that must be updated.

---

## Summary

Delete by Position is another **Previous–Current Pointer Pattern**.

The sequence is:

```
Find Previous

↓

Find Current

↓

Skip Current

↓

Continue
```

---

## Related Problems

- Delete by Value
- Delete After a Value
- Insert Before a Value
- Insert at Position
