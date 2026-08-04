# Traversal in Doubly Linked List

## Overview

Traversal means visiting every node in the linked list.

Unlike a Singly Linked List, a Doubly Linked List supports traversal in **both directions**.

- Forward Traversal (using `next`)
- Backward Traversal (using `prev`)

---

## Visual Representation

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Forward

```
10 → 20 → 30 → 40
```

Backward

```
40 → 30 → 20 → 10
```

---

# What's Different from Singly Linked List?

In a Singly Linked List,

```
10 → 20 → 30 → null
```

Once you reach

```
30
```

you cannot return to

```
20
```

because there is no pointer going backward.

In a Doubly Linked List,

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

every node knows both

- who comes before it
- who comes after it

which makes backward traversal possible.

---

# 🧠 Think Like the Pointer

Imagine every node is a person standing in a line.

In a Singly Linked List,

everyone only knows the person standing in front.

```
10 → 20 → 30
```

If you're standing at `30`, you have no idea who was behind you.

Now imagine everyone is holding hands.

```
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Now each person knows

- who is on the left
- who is on the right

Walking forward uses

```
next
```

Walking backward uses

```
prev
```

---

# Forward Traversal

Start from

```
head
```

Move using

```java
temp = temp.next;
```

until

```
temp == null
```

---

## Key Snippet

```java
Node temp = head;

while(temp != null){

    System.out.print(temp.data);

    temp = temp.next;
}
```

---

# Backward Traversal

Since only

```
head
```

is available,

we first reach the last node.

```java
while(temp.next != null){
    temp = temp.next;
}
```

Now

```
temp
```

points to

```
40
```

Then move backwards.

```java
temp = temp.prev;
```

until

```
temp == null
```

---

## Dry Run

Initial List

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Forward

```
10

↓

20

↓

30

↓

40
```

Backward

```
40

↓

30

↓

20

↓

10
```

---

# Why do we stop at `temp.next != null`?

Suppose

```
10 ⇄ 20 ⇄ 30 ⇄ 40
```

We want to reach the last node.

If we write

```java
while(temp != null)
```

the loop ends with

```
temp = null
```

Now

```java
temp.prev
```

will cause a

```
NullPointerException
```

Instead,

we stop **one node early**.

```java
while(temp.next != null)
```

This guarantees

```
temp
```

is the last node.

---

# Time Complexity

| Operation | Complexity |
|-----------|------------|
| Forward Traversal | **O(n)** |
| Backward Traversal | **O(n)** |

---

# Space Complexity

| Operation | Complexity |
|-----------|------------|
| Extra Space | **O(1)** |

---

# Edge Cases

### Empty List

```
head = null
```

No output.

---

### Single Node

```
null ← 10 → null
```

Forward

```
10
```

Backward

```
10
```

---

# Common Mistakes

- Forgetting to check `head == null`.
- Using `temp != null` while finding the last node.
- Using `temp.next` instead of `temp.prev` during backward traversal.
- Assuming the list stores a tail pointer.

---

# Pointer Rule Learned

A Doubly Linked List allows movement in both directions because every node owns two references:

```
prev ← Node → next
```

---

# Interview Insight

**Q:** Why is backward traversal O(n) instead of O(1)?

**A:** Because we only maintain a `head` pointer. To traverse backward, we must first travel to the last node, which takes O(n). If the implementation also maintained a `tail` pointer, backward traversal could begin immediately.

---

# Summary

Forward traversal uses `next`.

Backward traversal first reaches the last node and then repeatedly follows `prev`.

The extra `prev` pointer is the key feature that distinguishes a Doubly Linked List from a Singly Linked List.

---

## Related Problems

- Insert at End
- Delete from End
- Reverse Doubly Linked List
- Insert at Position
