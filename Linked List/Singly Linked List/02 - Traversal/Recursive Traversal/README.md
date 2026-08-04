# Recursive Traversal in Singly Linked List

## Overview

Recursive traversal visits every node of a linked list by allowing each node to recursively call the traversal function for the next node until the end of the list is reached.

Unlike iterative traversal, recursion uses the **function call stack** to move through the linked list.

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

## Core Idea

Instead of using a loop, each node asks the next node to continue the traversal.

```
10
 ↓
Traverse(20)

20
 ↓
Traverse(30)

30
 ↓
Traverse(40)

40
 ↓
Traverse(null)

Return
```

Every recursive call processes **one node** before delegating the remaining work to the next node.

---

## Key Snippets

### Base Case

```java
if(head == null){
    return;
}
```

Stops recursion when the traversal reaches beyond the last node.

---

### Process Current Node

```java
System.out.print(head.data + " ");
```

Processes the current node before moving to the next.

---

### Recursive Call

```java
traverse(head.next);
```

Moves the traversal to the next node.

---

## Algorithm

1. Check whether the current node is `null`.
2. If it is `null`, stop the recursion.
3. Process the current node.
4. Recursively call the function for the next node.
5. Continue until the end of the list is reached.

---

## Dry Run

Initial List

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Call Stack

```
traverse(10)

Print 10

↓

traverse(20)

Print 20

↓

traverse(30)

Print 30

↓

traverse(40)

Print 40

↓

traverse(null)

Return
```

Execution Order

```
10

↓

20

↓

30

↓

40

↓

Return
```

Output

```
10 20 30 40
```

---

## Understanding the Base Case

The recursion must know **when to stop**.

Without

```java
if(head == null){
    return;
}
```

the function would continue calling itself indefinitely, eventually causing a **StackOverflowError**.

---

## Iterative vs Recursive Traversal

| Iterative | Recursive |
|-----------|-----------|
| Uses a loop | Uses function calls |
| O(1) Extra Space | O(n) Call Stack |
| Faster | Easier to understand |
| Preferred in interviews | Useful for learning recursion |

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Traversal | **O(n)** |

---

## Space Complexity

| Operation | Complexity |
|----------|------------|
| Recursive Traversal | **O(n)** |

The additional space is used by the recursive call stack.

---

## Edge Cases

### Empty List

```
head = null
```

No output is produced.

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

- Forgetting the base case.
- Calling `traverse(head)` instead of `traverse(head.next)`, causing infinite recursion.
- Assuming recursive traversal uses O(1) space.
- Forgetting that each recursive call remains on the call stack until all subsequent calls return.

---

## Key Takeaways

- Recursive traversal replaces the loop with function calls.
- The base case prevents infinite recursion.
- Each function call processes exactly one node.
- Recursive traversal is simple to write but consumes additional stack memory.

---

## Related Problems

- Reverse Linked List (Recursive)
- Recursive Search in Linked List
- Print Linked List in Reverse
- Find Length of Linked List (Recursive)
- Reverse Printing Using Recursion
