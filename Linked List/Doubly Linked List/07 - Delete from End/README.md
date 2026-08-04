# Delete from End in Doubly Linked List

## Overview

Delete the last node from a Doubly Linked List.

Since each node stores a reference to its previous node, once the last node is reached, we can remove it by updating **only one forward link**.

---

## Visual Representation

Before

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Delete from End

After

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

---

# What's Different from Singly Linked List?

In a Singly Linked List, after reaching the last node, we still need to know **which node came before it**.

That is why we maintain a separate `prev` pointer while traversing.

In a Doubly Linked List, every node already stores its previous node.

```
30 ⇄ 40
```

So when we reach `40`, we can immediately access `30` using

```java
temp.prev
```

No additional traversal pointer is required.

---

# Similarity with Singly Linked List

Both algorithms

- Traverse to the last node.
- Handle empty and single-node lists separately.
- Remove the last node.

The only difference is how we reach the previous node.

| Singly Linked List | Doubly Linked List |
|--------------------|--------------------|
| Keep a `prev` variable | Use `temp.prev` |

---

# 🧠 Think Like the Pointer

Imagine a train.

```
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Coach **40** is the last coach.

If it leaves,

who should change?

Not **40**.

Coach **30** must stop pointing to it.

Before

```
30 ⇄ 40
```

means

```
30.next = 40

40.prev = 30
```

After deletion

```
30.next = null
```

Now `30` naturally becomes the last coach.

Finally, we disconnect the deleted node from the list.

```
40.prev = null
```

This isn't mandatory in Java because the Garbage Collector will reclaim the node, but it's good programming practice because it completely isolates the removed node.

---

## Core Idea

After reaching the last node,

```
temp
```

points to

```
40
```

Its previous node is

```
temp.prev

↓

30
```

We simply make

```java
temp.prev.next = null;
```

The previous node becomes the new last node.

---

## Key Snippets

### Empty List

```java
if(head == null){
    return;
}
```

---

### Single Node

```java
if(head.next == null){
    head = null;
    return;
}
```

---

### Reach the Last Node

```java
Node temp = head;

while(temp.next != null){
    temp = temp.next;
}
```

---

### Remove the Last Node

```java
temp.prev.next = null;
```

The previous node now becomes the last node.

---

### Disconnect the Deleted Node

```java
temp.prev = null;
```

Completely isolates the removed node.

---

# 🧠 Why don't we write `temp = null`?

Suppose we write

```java
temp = null;
```

Only the local variable changes.

The list still looks like

```
30 → 40
```

because

```
30.next
```

still points to `40`.

To remove a node, we must modify the pointer that **owns the connection**.

That pointer is

```java
temp.prev.next
```

not `temp`.

---

## Dry Run

Initial List

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Traverse

```
temp

↓

40
```

Step 1

```java
temp.prev.next = null;
```

Result

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Step 2

```java
temp.prev = null;
```

The removed node becomes

```
null ← 40 → null
```

and is no longer connected to the list.

---

## Algorithm

1. Check if the list is empty.
2. Handle the single-node case.
3. Traverse to the last node.
4. Make the previous node's `next` pointer `null`.
5. Disconnect the removed node.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Delete from End | **O(n)** |

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

### Single Node

Before

```
null ← 10 → null
```

After

```
head = null
```

---

### Two Nodes

Before

```
null ← 10 ⇄ 20 → null
```

After

```
null ← 10 → null
```

---

## Common Mistakes

- Forgetting the single-node case.
- Writing `temp = null` instead of updating `temp.prev.next`.
- Traversing with `temp != null` instead of `temp.next != null`.
- Forgetting that the previous node becomes the new last node.

---

## Pointer Rule Learned

**The node being deleted rarely changes anything.**

The node that owns the pointer to it must change instead.

In this problem,

```
temp.prev
```

owns the pointer.

So we modify

```java
temp.prev.next
```

not `temp`.

---

## Interview Insight

**Q:** Why don't we need a separate `prev` variable like in a Singly Linked List?

**A:** Because every node in a Doubly Linked List already stores a reference to its previous node. Once we reach the last node, `temp.prev` immediately gives us the previous node, eliminating the need for an extra traversal pointer.

---

## Summary

Delete from End follows a simple pattern:

```
Reach Last Node

↓

Find Previous Node using prev

↓

Break Forward Link

↓

Disconnect Removed Node
```

Although traversal takes **O(n)** time, the deletion itself is a constant-time pointer update.

---

## Related Problems

- Delete from Beginning
- Delete by Value
- Reverse Doubly Linked List
- Insert at End
