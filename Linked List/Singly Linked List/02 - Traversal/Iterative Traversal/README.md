# Iterative Traversal in Singly Linked List

## Overview

Traversal is the process of visiting every node in a linked list exactly once. Since a singly linked list stores only the reference to the next node, traversal is always performed from the **head** to the **last node**.

The recommended approach is to use a **temporary pointer (`temp`)** instead of modifying the `head` pointer. This preserves the original linked list.

---

## Visual Representation

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Traversal Output

```
10 20 30 40
```

---

## Solution

```java
public void traverse(Node head) {

    Node temp = head;

    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
}
```

---

## Algorithm

1. Check whether the list is empty.
2. Create a temporary pointer and initialize it with `head`.
3. Visit the current node.
4. Move the temporary pointer to the next node.
5. Repeat until the temporary pointer becomes `null`.

---

## Dry Run

Initial List

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Initially

```
temp = head
```

### Iteration 1

```
temp
 ↓
10 → 20 → 30 → 40 → null
```

Print

```
10
```

Move

```
temp = temp.next
```

---

### Iteration 2

```
      temp
       ↓
10 → 20 → 30 → 40 → null
```

Print

```
20
```

Move to next node.

---

### Iteration 3

```
            temp
             ↓
10 → 20 → 30 → 40 → null
```

Print

```
30
```

Move to next node.

---

### Iteration 4

```
                  temp
                   ↓
10 → 20 → 30 → 40 → null
```

Print

```
40
```

Move

```
temp = temp.next
```

Now

```
temp = null
```

The loop terminates.

Output

```
10 20 30 40
```

---

# Why do we use a Temporary Pointer?

Instead of writing

```java
head = head.next;
```

we use

```java
temp = temp.next;
```

because the `head` pointer should always point to the first node of the linked list.

Using a temporary pointer allows us to traverse the list without modifying its starting point.

### Correct

```
head
 ↓
10 → 20 → 30 → null

temp
 ↓
10
```

During traversal, only `temp` moves.

After traversal

```
head
 ↓
10 → 20 → 30 → null
```

The list remains unchanged.

---

### Incorrect

```java
while(head != null){
    System.out.print(head.data);
    head = head.next;
}
```

After execution

```
head = null
```

The original starting reference is lost.

Although the nodes still exist in memory, they can no longer be accessed because there is no reference pointing to the first node.

---

# Understanding `temp` vs `temp.next`

This is one of the most common interview questions.

## What does `temp` represent?

`temp` always points to the **current node** being processed.

```
temp
 ↓
10 → 20 → 30 → null
```

The current node is **10**.

---

## What does `temp.next` represent?

`temp.next` points to the **next node**.

```
temp
 ↓
10 → 20 → 30 → null
      ↑
   temp.next
```

The next node is **20**.

---

# Why does the loop use `temp != null`?

```java
while(temp != null)
```

The loop continues **as long as a valid current node exists**.

The pointer moves like this:

```
10

↓

20

↓

30

↓

40

↓

null
```

The loop stops only after every node has been processed.

---

# Why NOT use `temp.next != null`?

Many beginners write

```java
while(temp.next != null)
```

This is incorrect for traversal because it stops one node early.

Example

```
10 → 20 → 30 → 40 → null
```

Pointer movement

```
temp = 10

temp = 20

temp = 30
```

When

```
temp = 40
```

```
temp.next == null
```

The condition becomes false.

The loop exits **before processing the last node**.

Output

```
10 20 30
```

The last node (**40**) is skipped.

---

# When should we use `temp != null`?

Use it whenever the **current node** must be processed.

Examples

- Traversal
- Printing
- Searching
- Finding maximum
- Finding minimum
- Counting nodes
- Summing node values

---

# When should we use `temp.next != null`?

Use it when you need access to the **next node** or want to stop **one node before the end**.

Examples

- Insert at End
- Delete Last Node
- Find the Last Node
- Circular Linked List (finding the last node)

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Traversal | O(n) |

---

## Space Complexity

| Operation | Complexity |
|----------|------------|
| Iterative Traversal | O(1) |

---

## Edge Cases

### Empty List

```
head = null
```

Nothing is printed.

---

### Single Node

```
head
 ↓
10 → null
```

Output

```
10
```

---

## Common Mistakes

- Using `head` instead of a temporary pointer.
- Forgetting to move the pointer (`temp = temp.next`).
- Using `temp.next != null` for normal traversal.
- Assuming `temp.next` refers to the current node. It refers to the next node.

---

## Key Takeaways

- Always use a temporary pointer to preserve the `head`.
- `temp` represents the current node.
- `temp.next` represents the next node.
- For complete traversal, the stopping condition should be `temp != null`.
- Use `temp.next != null` only when you intentionally need to stop at the second-last node.

---

## Related Problems

- Search in Linked List
- Count Nodes
- Find Maximum Element
- Find Minimum Element
- Sum of Nodes
- Insert at End
- Delete Last Node
