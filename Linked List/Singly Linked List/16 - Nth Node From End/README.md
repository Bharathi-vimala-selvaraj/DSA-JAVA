# Nth Node From End in Singly Linked List

## Overview

Finding the Nth node from the end means locating a node by counting backwards.

Example:

Find 2nd node from end.

Before:

```
10 → 20 → 30 → 40 → 50 → null
```

Answer:

```
40
```

---

# 🧠 Think Like the Pointer

The biggest problem:

We do not know the length.

A beginner approach:

1. Count nodes.
2. Calculate position from beginning.
3. Traverse again.

This requires two passes.

Instead, we create a gap between two pointers.

---

# Core Idea

Maintain a distance of `n` nodes between:

```
fast
slow
```

First move fast `n` steps.

Then move both together.

When fast reaches the end,

slow will be at the required node.

---

# Visual Example

Find 2nd node from end.

```
10 → 20 → 30 → 40 → 50
```

Move fast 2 steps:

```
slow
 ↓
10 → 20 → 30 → 40 → 50
          ↑
         fast
```

Now move both:

```
      slow
       ↓
10 → 20 → 30 → 40 → 50
                   ↑
                  fast
```

When fast reaches null:

```
slow = 40
```

---

# Algorithm

1. Initialize slow and fast at head.
2. Move fast n steps ahead.
3. Move slow and fast together.
4. When fast becomes null, slow is the answer.

---

# Key Snippets

## Create Gap

```java
fast = fast.next;
```

Fast moves ahead first.

---

## Move Together

```java
slow = slow.next;
fast = fast.next;
```

The gap remains constant.

---

## Return Answer

```java
return slow;
```

---

# 🚨 Common Mistake

Moving both pointers from the beginning.

Wrong:

```java
slow = slow.next;
fast = fast.next;
```

without creating the gap.

Result:

You cannot find the distance from the end.

---

# Edge Cases

## n equals list length

```
10 → 20 → 30
```

n = 3

Answer:

```
10
```

---

## n equals 1

Returns last node.

```
10 → 20 → 30
```

Answer:

```
30
```

---

## Invalid n

Return null.

---

# Complexity

Time:

```
O(n)
```

Space:

```
O(1)
```

---

# Pointer Rules Learned

- Create distance between pointers to convert a backward problem into a forward traversal.
- Two pointers moving together preserve the gap.
- Fast pointer reaching the end gives information about slow pointer position.
