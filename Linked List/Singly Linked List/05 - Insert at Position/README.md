# Insert at Position in Singly Linked List

## Overview

Insertion at a specific position places a new node anywhere within the linked list.

Unlike insertion at the beginning or end, this operation requires traversing the list to locate the node **immediately before** the desired position.

---

## Visual Representation

Insert **25** at **Position 3**

Before

```
head
 ↓
10 → 20 → 30 → 40 → null
```

After

```
head
 ↓
10 → 20 → 25 → 30 → 40 → null
```

---

## Core Idea

To insert a new node at a given position:

1. Traverse to the node just before the desired position.
2. Connect the new node to the remaining list.
3. Connect the previous node to the new node.

The insertion always modifies **two links**.

---

## Key Snippets

### Traverse to the Previous Node

```java
for(int i = 1; i < position - 1 && temp != null; i++){
    temp = temp.next;
}
```

The pointer stops at the node immediately before the insertion position.

---

### Connect the New Node

```java
newNode.next = temp.next;
```

The new node stores the reference to the remaining part of the list.

---

### Update the Previous Node

```java
temp.next = newNode;
```

The previous node now points to the newly inserted node.

---

## Algorithm

1. Validate the position.
2. If the position is `1`, perform insertion at the beginning.
3. Traverse to the node at `(position - 1)`.
4. If the position is invalid, terminate the operation.
5. Link the new node to the next node.
6. Update the previous node to point to the new node.

---

## Dry Run

Insert **25** at **Position 3**

Initial List

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Create

```
25 → null
```

Traverse

```
temp = 10

↓

temp = 20
```

The traversal stops because **20** is the node immediately before Position **3**.

Connect

```
25 → 30
```

Update Previous Node

```
20 → 25
```

Final List

```
head
 ↓
10 → 20 → 25 → 30 → 40 → null
```

---

## Why do we stop at `(position - 1)`?

Suppose we want to insert after node **20**.

```
10 → 20 → 30 → 40
```

To insert **25**, we need access to **20** because only **20** can change its `next` reference.

```
20.next = newNode
```

If we traverse to Position **3** instead,

```
temp = 30
```

there is no reference to node **20**, making it impossible to insert the new node correctly.

Therefore, insertion always stops **one node before** the desired position.

---

## Pointer Movement

```
temp

↓

10 → 20 → 30 → 40
```

↓

```
      temp

↓

10 → 20 → 30 → 40
```

Stop.

Now update

```
newNode.next = temp.next

temp.next = newNode
```

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Insert at Position | **O(n)** |

---

## Space Complexity

| Operation | Complexity |
|----------|------------|
| Extra Space | **O(1)** |

---

## Edge Cases

### Empty List

Insertion is possible only if the position is **1**.

---

### Insert at Beginning

```
Position = 1
```

Equivalent to **Insert at Beginning**.

---

### Insert at End

```
Position = Length + 1
```

Equivalent to **Insert at End**.

---

### Invalid Position

```
Position <= 0

or

Position > Length + 1
```

The insertion should not be performed.

---

## Common Mistakes

- Traversing to the insertion position instead of `(position - 1)`.
- Updating `temp.next` before saving the remaining list.
- Forgetting to validate the position.
- Not handling insertion at the beginning separately.

---

## Summary

- Inserting at a position requires modifying **two links**.
- Always stop at the node immediately before the insertion position.
- Save the remaining list before updating the previous node.
- Handle invalid positions to avoid runtime errors.

---

## Related Problems

- Insert at Beginning
- Insert at End
- Delete by Position
- Delete by Value
