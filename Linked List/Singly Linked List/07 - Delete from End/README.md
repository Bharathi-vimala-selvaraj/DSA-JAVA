# Delete from End in Singly Linked List

## Overview

Deleting the last node requires finding the **second-last node**.

Why not the last node?

Because the last node cannot delete itself.

Only the node before it owns the pointer that must be changed.

---

## Visual Representation

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
10 → 20 → 30 → null
```

---

# 🧠 Think Like the Pointer

Imagine every node owns only **one arrow**.

```
10 ----> 20

20 ----> 30

30 ----> 40

40 ----> null
```

Now ask yourself...

**Who owns the arrow pointing to 40?**

Answer

```
30
```

Therefore...

Who should change?

```
30
```

Should we modify node **40**?

**No.**

Node 40 owns

```
40.next
```

Changing

```
40.next
```

cannot remove 40 from the list.

The only way to remove 40 is to change

```
30.next
```

This is the most important idea behind this algorithm.

---

## Core Idea

To delete the last node,

we must stop **one node before it**.

That node is called the **second-last node**.

---

## Key Snippets

### Reach the Second-Last Node

```java
while(temp.next.next != null){
    temp = temp.next;
}
```

Notice the condition.

We stop when

```
temp.next.next == null
```

That means

```
temp.next
```

is the last node.

---

### Delete the Last Node

```java
temp.next = null;
```

The second-last node now points to `null`.

The last node is disconnected from the linked list.

---

## Algorithm

1. If the list is empty, return.
2. If only one node exists, set `head` to `null`.
3. Traverse until the second-last node.
4. Update its `next` pointer to `null`.

---

# 🧠 Why don't we stop at the Last Node?

Suppose we write

```java
while(temp.next != null)
```

Pointer movement

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

↓

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

Now

```
temp = 40
```

Question

Can node **40** remove itself?

No.

Why?

Because the pointer that needs changing is

```
30.next
```

But we've already moved past node 30.

We've lost access to the pointer we needed.

---

# 🧠 Why do we stop at the Second-Last Node?

Pointer movement

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

↓

```
            temp

↓

10 → 20 → 30 → 40
```

Stop.

Question

Why stop here?

Because

```
temp.next
```

is the last node.

Now we still own

```
30.next
```

So we can simply do

```java
temp.next = null;
```

Result

```
10 → 20 → 30 → null
```

Node 40 is disconnected.

---

# 🚨 What Happens If...

Suppose you write

```java
temp = temp.next;
temp = null;
```

Result

```
10 → 20 → 30 → 40
```

Did the list change?

No.

You only changed the **temporary pointer**.

The linked list is exactly the same because none of the node links were modified.

---

## Pointer Ownership

```
10 owns → 10.next

20 owns → 20.next

30 owns → 30.next

40 owns → 40.next
```

To remove node 40,

we must modify

```
30.next
```

Never

```
40.next
```

---

## Dry Run

```
head
 ↓
10 → 20 → 30 → 40 → null
```

Pointer

```
temp = 10

↓

20

↓

30
```

Stop.

Execute

```java
temp.next = null;
```

Final List

```
head
 ↓
10 → 20 → 30 → null
```

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Delete from End | **O(n)** |

---

## Space Complexity

| Operation | Complexity |
|----------|------------|
| Extra Space | **O(1)** |

---

## Edge Cases

### Empty List

```
head = null
```

Nothing is deleted.

---

### Single Node

Before

```
10 → null
```

After

```
head = null
```

---

### Two Nodes

Before

```
10 → 20 → null
```

After

```
10 → null
```

---

## Common Mistakes

- Traversing to the last node instead of the second-last node.
- Forgetting the single-node case.
- Changing the temporary pointer instead of modifying the node's `next` reference.
- Using `temp != null` for traversal.

---

## Summary

- A node cannot remove itself from a singly linked list.
- The node before the target must perform the deletion.
- Stop at the second-last node because it owns the pointer that needs to change.
- Understanding **pointer ownership** is more important than memorizing the code.

---

## Related Problems

- Delete from Beginning
- Delete by Value
- Insert at End
- Reverse Linked List
