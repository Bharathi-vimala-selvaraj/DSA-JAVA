# Insert at End in Doubly Linked List

## Overview

Insert a new node at the end of the Doubly Linked List.

Since only the `head` pointer is available, we first traverse to the last node and then establish connections in both directions.

---

## Visual Representation

Before

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Insert **40**

After

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

---

# What's Different from Singly Linked List?

In a Singly Linked List,

```
30 → 40
```

is enough.

In a Doubly Linked List,

```
30 ⇄ 40
```

means both nodes must know each other.

The previous last node must point forward.

The new node must point backward.

---

# 🧠 Think Like the Pointer

Imagine adding a new coach to the end of a train.

Current train

```
10 ⇄ 20 ⇄ 30
```

New coach

```
40
```

Coach **30** must know **40** is attached.

Coach **40** must know **30** is before it.

Only then is the train connected in both directions.

---

## Core Idea

After reaching the last node,

create two connections.

```
30 → 40

and

30 ← 40
```

---

## Key Snippets

### Traverse to the Last Node

```java
while(temp.next != null){
    temp = temp.next;
}
```

Stop when `temp` becomes the last node.

---

### Forward Connection

```java
temp.next = node;
```

The previous last node points to the new node.

---

### Backward Connection

```java
node.prev = temp;
```

The new node points back to the previous last node.

---

# 🧠 Why this order?

Suppose we execute

```java
node.prev = temp;
```

before

```java
temp.next = node;
```

Will it work?

✅ Yes.

Unlike insertion in the middle, these two statements are independent because neither overwrites the other.

So either order is acceptable.

We usually write

```java
temp.next = node;
node.prev = temp;
```

because it follows the natural reading direction of the list.

---

## Dry Run

Initial List

```
null ← 10 ⇄ 20 ⇄ 30 → null
```

Reach

```
30
```

Step 1

```
30 → 40
```

Step 2

```
30 ← 40
```

Final

```
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

---

## Algorithm

1. Create a new node.
2. If the list is empty, make it the head.
3. Traverse to the last node.
4. Connect the last node to the new node.
5. Connect the new node back to the last node.

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Insert at End | **O(n)** |

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

Result

```
null ← newNode → null
```

---

### Single Node

Before

```
null ← 10 → null
```

After

```
null ← 10 ⇄ 20 → null
```

---

## Common Mistakes

- Forgetting `node.prev = temp`.
- Traversing with `temp != null` instead of `temp.next != null`.
- Forgetting the empty list case.
- Assuming the new node's `next` needs to be assigned (it is already `null`).

---

## Pointer Rule Learned

**Every connection in a Doubly Linked List has two directions.**

Whenever you write

```java
temp.next = node;
```

immediately ask:

```
Who should point back?
```

The answer is

```java
node.prev = temp;
```

---

## Interview Insight

**Q:** Why is Insert at End still O(n)? Isn't it a Doubly Linked List?

**A:** The extra `prev` pointer allows backward movement, but it does not help us reach the last node faster. Since we only maintain a `head` pointer, we still need to traverse from the beginning. If a `tail` pointer were also maintained, insertion at the end would become **O(1)**.

---

## Summary

Insert at End consists of three simple steps:

```
Reach Last Node

↓

Forward Connection

↓

Backward Connection
```

The operation takes **O(n)** time because traversal is required, but updating the links takes constant time.

---

## Related Problems

- Insert at Beginning
- Insert at Position
- Delete from End
- Reverse Doubly Linked List
