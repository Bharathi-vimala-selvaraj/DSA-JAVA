# Delete by Value in Singly Linked List

## Overview

Delete by Value removes the **first occurrence** of a given value from the linked list.

Unlike deleting the first or last node, we do not know where the target node is located. Therefore, we must search for it before removing it.

---

## Visual Representation

Delete **30**

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
10 → 20 → 40 → null
```

---

# 🧠 Think Like the Pointer

Suppose we want to delete **30**.

Most beginners immediately search for node **30**.

But here's the real question.

> **Who owns the pointer that reaches 30?**

```
10 ----> 20

20 ----> 30

30 ----> 40
```

Answer

```
20
```

Node **20** owns

```
20.next
```

That is the pointer we must change.

---

## Core Idea

Never stop at the node you want to delete.

Stop at the node **before** it.

Why?

Because only the previous node owns the pointer that can bypass the target node.

---

## Key Snippets

### Handle Head Deletion

```java
if(head.data == value){
    head = head.next;
    return;
}
```

If the first node contains the value, simply move the head.

---

### Find the Previous Node

```java
while(temp.next != null){
```

Notice that we are **not** checking

```java
temp.data
```

Instead, we look ahead.

---

### Look at the Next Node

```java
if(temp.next.data == value)
```

Why?

Because we need the node **before** the target.

---

### Bypass the Target Node

```java
temp.next = temp.next.next;
```

The previous node now points directly to the node after the target.

The target node is removed from the linked list.

---

## Algorithm

1. Check if the list is empty.
2. Check whether the head contains the value.
3. Traverse while looking one node ahead.
4. When the value is found, bypass the target node.
5. If the value does not exist, terminate the operation.

---

# 🧠 Why don't we stop at the node to delete?

Suppose we stop here.

```
head
 ↓
10 → 20 → 30 → 40
           ↑
         temp
```

Question

Can node **30** remove itself?

No.

Changing

```
30.next
```

only changes where **30** points.

It does **not** remove **30** from the list.

---

# 🧠 Why do we stop one node before?

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

Stop.

Now

```
temp = 20
```

Question

Which pointer do we own?

```
20.next
```

Now execute

```java
temp.next = temp.next.next;
```

Step 1

```
20

↓

30

↓

40
```

becomes

```
20

↓

40
```

Final List

```
10 → 20 → 40
```

---

# 🚨 What Happens If...

Suppose you write

```java
temp = temp.next;
temp = temp.next;
```

You eventually stand on

```
30
```

Now ask yourself.

Can you change

```
20.next ?
```

No.

You already walked past node **20**.

The pointer you needed has been lost.

---

## Dry Run

Delete **30**

```
head
 ↓
10 → 20 → 30 → 40
```

Pointer Movement

```
temp = 10

↓

temp = 20
```

Check

```
temp.next.data == 30
```

True.

Execute

```java
temp.next = temp.next.next;
```

Result

```
10 → 20 → 40
```

---

## Edge Cases

### Empty List

```
head = null
```

Nothing is deleted.

---

### Delete Head

Before

```
10 → 20 → 30
```

Delete

```
10
```

After

```
20 → 30
```

---

### Delete Last Node

Before

```
10 → 20 → 30
```

Delete

```
30
```

After

```
10 → 20
```

The same algorithm works.

---

### Value Not Found

```
10 → 20 → 30
```

Delete

```
50
```

No changes are made.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| Delete by Value | **O(n)** |

---

## Space Complexity

| Operation | Complexity |
|----------|------------|
| Extra Space | **O(1)** |

---

## Common Mistakes

- Searching for the target node instead of its previous node.
- Using `temp.data == value` inside the loop.
- Forgetting to handle head deletion separately.
- Forgetting to return after deleting the node.
- Accessing `temp.next.data` without checking whether `temp.next` is `null`.

---

## Summary

- The previous node performs the deletion.
- Always modify the pointer that **owns the target node**.
- Look one node ahead during traversal.
- One algorithm correctly handles deleting from the middle and the end of the list.

---

## Related Problems

- Delete from Beginning
- Delete from End
- Delete by Position
- Remove Duplicates
