# Linked List Patterns & Cheat Sheet

> A quick revision guide for Linked Lists.
> 
> Instead of memorizing algorithms, learn the patterns behind them.
> Almost every Linked List problem is a variation of these patterns.

---

# 1. Time Complexity Cheat Sheet

| Operation | Time |
|-----------|------|
| Traverse | O(n) |
| Search | O(n) |
| Insert at Beginning | O(1) |
| Insert at End | O(n) |
| Insert at Position | O(n) |
| Insert Before/After Value | O(n) |
| Delete from Beginning | O(1) |
| Delete from End | O(n) |
| Delete by Position | O(n) |
| Delete by Value | O(n) |
| Reverse | O(n) |
| Middle Node | O(n) |
| Nth Node from End | O(n) |
| Detect Cycle | O(n) |
| Merge Sorted Lists | O(n + m) |
| Remove Duplicates | O(n) |

---

# 2. Pointer Responsibilities

## head

- Entry point of the linked list.
- Always points to the first node.
- Changes only when the first node changes.

Used in

- Insert at Beginning
- Delete from Beginning
- Reverse
- Empty List

---

## temp

Temporary traversal pointer.

```
head

↓

10 → 20 → 30 → null
```

Moves through the list without modifying it.

Used in

- Traversal
- Search
- Count
- Maximum
- Minimum
- Sum

---

## prev

Points to the node before the current node.

```
prev      curr

↓

10 → 20 → 30
```

Used whenever an operation needs access to the previous node.

Examples

- Delete by Value
- Delete by Position
- Insert Before Value
- Reverse

---

## curr

Current working node.

```
prev      curr

↓

10 → 20 → 30
```

The node currently being processed.

---

## next

Protects the remaining list.

```
curr

↓

20 → 30 → 40

      ↑

     next
```

Mainly used in Reverse Linked List.

---

## slow

Moves one step.

Used in

- Middle Node
- Detect Cycle

---

## fast

Moves two steps.

Used in

- Middle Node
- Detect Cycle
- Nth Node from End

---

## tail

Always points to the last node of the result list.

Used in

- Merge Sorted Lists

---

# 3. The 8 Fundamental Patterns

---

## Pattern 1

### Traversal Pattern

```
Node temp = head;

while(temp != null){

    ...

    temp = temp.next;
}
```

Used in

- Search
- Count
- Maximum
- Minimum
- Sum

---

## Pattern 2

### Previous–Current Pattern

```
prev

↓

10 → 20 → 30

      ↑

     curr
```

Used whenever a node must be inserted or deleted.

Examples

- Delete by Value
- Delete by Position
- Insert Before Value

---

## Pattern 3

### Three Pointer Pattern

```
prev

curr

next
```

Used in

- Reverse Linked List

Order

```
Save

↓

Reverse

↓

Move prev

↓

Move curr
```

---

## Pattern 4

### Slow & Fast Pointer Pattern

```
slow

↓

10 → 20 → 30 → 40

↓

fast
```

Used in

- Middle Node
- Detect Cycle

---

## Pattern 5

### Two Pointer Gap Pattern

```
fast

↓

10 → 20 → 30 → 40

↓

slow
```

Maintain a fixed distance.

Used in

- Nth Node From End

---

## Pattern 6

### Tail Building Pattern

```
head

↓

10 → 20 → 30

            ↑

          tail
```

Used whenever a new list is being constructed.

Example

- Merge Sorted Lists

---

## Pattern 7

### Adjacent Comparison Pattern

```
curr

↓

20 → 20
```

Compare neighboring nodes.

Used in

- Remove Duplicates

---

## Pattern 8

### Skip Node Pattern

```
Before

20 → 30 → 40

After

20 → 40
```

The node itself is never changed.

The previous node changes.

Used in

- Delete
- Remove Duplicates

---

# 4. The 7 Golden Pointer Rules

## Rule 1

Never overwrite a pointer before saving the information it contains.

Example

Reverse Linked List.

---

## Rule 2

If you lose a reference,

you lose the remaining list.

---

## Rule 3

Insertion requires creating a new connection.

Deletion requires breaking an old connection.

---

## Rule 4

The node being deleted is almost never modified.

The previous node changes instead.

---

## Rule 5

Always know

```
Completed Part

↓

Current Node

↓

Remaining Part
```

---

## Rule 6

Move a pointer only after finishing the work on the current node.

---

## Rule 7

Changing the order of pointer updates changes the algorithm.

---

# 5. Edge Case Checklist

Always ask these questions before coding.

☐ Empty List

☐ Single Node

☐ First Node

☐ Last Node

☐ Position Out of Range

☐ Value Not Found

☐ Duplicate Values

☐ All Nodes Same

☐ Negative Values (if applicable)

---

# 6. Interview Checklist

Before submitting a Linked List solution, verify:

☐ Did I lose any node?

☐ Did I save the next node before changing pointers?

☐ Does head need to change?

☐ Does the last node need special handling?

☐ Did I update every required pointer?

☐ Will this work for an empty list?

☐ Will this work for a single node?

☐ Am I stopping at the correct node?

---

# 7. Common Mistakes

❌ Forgetting `head == null`

❌ Forgetting the single-node case

❌ Moving `curr` too early

❌ Forgetting `temp = temp.next`

❌ Overwriting `curr.next` before saving it

❌ Forgetting `head = prev` after reverse

❌ Using `curr = null` to delete a node

❌ Forgetting to return after insertion/deletion

❌ Missing edge cases

---

# 8. Algorithm Recognition Guide

If the problem says...

| Keywords | Pattern |
|----------|---------|
| Visit every node | Traversal |
| Find largest/smallest | Traversal |
| Count | Traversal |
| Search | Traversal |
| Insert Before | Previous–Current |
| Delete | Previous–Current |
| Reverse | Three Pointers |
| Middle | Slow & Fast |
| Cycle | Floyd's Algorithm |
| Nth From End | Two Pointer Gap |
| Merge | Tail Building |
| Remove Duplicates | Adjacent Comparison |

---

# 9. Visual Memory

Traversal

```
head

↓

10 → 20 → 30 → null
```

---

Deletion

```
Before

20 → 30 → 40

After

20 → 40
```

---

Insertion

```
Before

20 → 30

After

20 → 25 → 30
```

---

Reverse

```
prev ← curr → next
```

---

Middle

```
slow →

fast → →
```

---

Cycle Detection

```
slow →

fast → →
```

Eventually

```
slow == fast
```

---

# 10. Final Thought

A Linked List is not about data.

It is about **references**.

Every problem can be solved by answering three questions:

1. Which pointer currently owns the connection?
2. Which connection must change?
3. What information must be preserved before changing it?

If you can answer these three questions, you can solve almost every Linked List interview problem.

---

> "Master the pointers, and the algorithms become simple."
