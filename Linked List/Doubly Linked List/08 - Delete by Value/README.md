# Delete by Value in Doubly Linked List

## Overview

Delete the first node containing the specified value.

Unlike a Singly Linked List, we do not need to maintain a separate `prev` pointer while traversing because every node already stores its previous node.

---

## Visual Representation

Before

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Delete

```
30
```

After

```
null ← 10 ⇄ 20 ⇄ 40 → null
```

---

# What's Different from Singly Linked List?

In a Singly Linked List

```
prev → curr
```

must always be maintained.

In a Doubly Linked List

```
curr.prev
```

already exists.

That removes one entire pointer from the algorithm.

---

# Similarity with Singly Linked List

The traversal remains exactly the same.

```
head

↓

10 → 20 → 30 → 40
```

The difference appears only when deleting.

Instead of

```java
prev.next = curr.next;
```

we write

```java
curr.prev.next = curr.next;
```

because the previous node is already stored.

---

# 🧠 Think Like the Pointer

Suppose

```
20 ⇄ 30 ⇄ 40
```

Delete

```
30
```

Current links

```
20.next = 30

30.prev = 20

30.next = 40

40.prev = 30
```

After deletion

```
20.next = 40

40.prev = 20
```

Now

```
30
```

has no incoming connections.

The list becomes

```
20 ⇄ 40
```

---

## Core Idea

Deleting a middle node requires reconnecting its neighbors.

```
curr.prev.next = curr.next

↓

curr.next.prev = curr.prev
```

Then isolate the deleted node.

```
curr.prev = null

curr.next = null
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

### Delete Head

```java
head = head.next;
head.prev = null;
```

---

### Delete Last Node

```java
curr.prev.next = null;
```

---

### Delete Middle Node

```java
curr.prev.next = curr.next;

curr.next.prev = curr.prev;
```

---

### Disconnect Deleted Node

```java
curr.prev = null;
curr.next = null;
```

---

# 🧠 Why don't we need `prev`?

Suppose

```
10 ⇄ 20 ⇄ 30
```

Current node

```
30
```

Need previous node?

Simply write

```java
curr.prev
```

The node already knows who came before it.

---

## Dry Run

Initial List

```
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Find

```
30
```

Reconnect

```
20.next = 40

40.prev = 20
```

Disconnect

```
30.prev = null

30.next = null
```

Final

```
10 ⇄ 20 ⇄ 40
```

---

## Algorithm

1. Handle the empty list.
2. Handle deletion of the head.
3. Traverse the list.
4. Find the target value.
5. If deleting the last node, update the previous node.
6. Otherwise reconnect the previous and next nodes.
7. Disconnect the removed node.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Delete by Value | **O(n)** |

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

---

### Single Node

```
10
```

Delete

```
10
```

Result

```
head = null
```

---

### Delete Head

```
10 ⇄ 20 ⇄ 30
```

↓

```
20 ⇄ 30
```

---

### Delete Tail

```
10 ⇄ 20 ⇄ 30
```

↓

```
10 ⇄ 20
```

---

### Value Not Found

The list remains unchanged.

---

## Common Mistakes

- Forgetting to handle the head separately.
- Forgetting `curr.next.prev = curr.prev`.
- Forgetting the last-node case.
- Using an unnecessary `prev` variable.
- Forgetting to disconnect the removed node.

---

## Pointer Rule Learned

In a Doubly Linked List,

**every node already knows its previous node.**

Whenever you need the previous node,

use

```java
curr.prev
```

instead of maintaining another traversal pointer.

---

## Interview Insight

**Q:** Why is deletion simpler in a Doubly Linked List?

**A:** Because the node being deleted already stores a reference to its previous node. This removes the need for a separate `prev` traversal pointer, reducing the amount of bookkeeping required.

---

## Summary

Delete by Value follows this sequence:

```
Find Target

↓

Reconnect Previous

↓

Reconnect Next

↓

Disconnect Deleted Node

↓

Done
```

The search takes **O(n)** time, while the pointer updates themselves are constant time.

---

## Related Problems

- Delete from Beginning
- Delete from End
- Insert at Position
- Reverse Doubly Linked List
