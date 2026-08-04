# Delete After a Value in Singly Linked List

## Overview

Delete the node immediately after the first occurrence of a given value.

If the target value is not present, or if it is the last node, the linked list remains unchanged.

---

## Visual Representation

Before

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Delete the node after **20**

After

```
head
 ↓
10 → 20 → 40 → null
```

---

# 🧠 Think Like the Pointer

Imagine you're standing on

```
20
```

Your job is **not** to remove `20`.

Your job is to remove the node immediately after it.

Current situation

```
20 → 30 → 40
```

Instead of touching `30`,

simply change

```
20.next
```

to

```
40
```

Now

```
30
```

has no incoming reference.

Java's Garbage Collector removes it automatically.

---

## Core Idea

The node being deleted never changes.

Only the previous node changes its pointer.

```
Before

20 → 30 → 40
```

↓

```
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

### Last Node Check

```java
if(curr.next == null){
    return;
}
```

There is no node after the current node.

Nothing can be deleted.

---

### Skip the Next Node

```java
curr.next = curr.next.next;
```

The node after `curr` is removed.

---

## Algorithm

1. Check if the list is empty.
2. Traverse the list.
3. Find the target value.
4. If there is no next node, stop.
5. Connect the current node directly to the node after the next node.
6. Stop.

---

# 🧠 Why do we check `curr.next == null`?

Suppose

```
10 → 20 → 30
```

Delete after

```
30
```

But

```
30.next == null
```

There is no node after 30.

Trying

```java
curr.next.next
```

would throw a

```
NullPointerException
```

So we must check first.

---

## Dry Run

Initial List

```
10 → 20 → 30 → 40
```

Find

```
20
```

Current

```
20 → 30 → 40
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

### You don't check for the last node

Example

```
10 → 20 → 30
```

Delete after

```
30
```

Attempt

```java
curr.next.next
```

Since

```
curr.next == null
```

the program crashes with a

```
NullPointerException
```

---

### You keep traversing after deletion

Once the required node is deleted,

the operation is complete.

Continuing traversal performs unnecessary work.

Always

```java
return;
```

after deletion.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Delete After Value | **O(n)** |

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

### Target Not Found

The list remains unchanged.

---

### Target is Last Node

```
10 → 20 → 30
```

Delete after

```
30
```

Nothing happens.

---

### Single Node

```
10
```

There is no next node.

Nothing is deleted.

---

## Common Mistakes

- Forgetting to check `curr.next == null`.
- Trying to delete the current node instead of the next node.
- Forgetting to stop after deletion.
- Assuming the target always exists.

---

## Pointer Rule Learned

**To delete the next node, modify the current node's `next` pointer—not the node being deleted.**

---

## Interview Insight

**Q:** Why don't we need a `prev` pointer here?

**A:** Because we are deleting the node **after** the current node. The current node already owns the pointer that must be changed.

---

## Summary

Delete After Value is a simple pointer reassignment problem.

The pattern is:

```
Find Target

↓

Check Next Exists

↓

Skip Next Node

↓

Stop
```

It is completed in **O(n)** time using **O(1)** extra space.

---

## Related Problems

- Delete by Value
- Delete by Position
- Insert After a Value
- Remove Duplicates
