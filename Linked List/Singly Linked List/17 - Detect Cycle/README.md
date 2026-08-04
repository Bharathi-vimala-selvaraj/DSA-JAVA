# Detect Cycle in Singly Linked List

## Overview

A cycle occurs when a node points back to a previous node instead of pointing to `null

The traversal never reaches null.

---

# 🧠 Think Like the Pointer

Imagine two runners on a circular track.

One runs slowly.

One runs faster.
slow = 1 step

fast = 2 steps

If the track is circular:

The faster runner will eventually catch the slower runner.

If there is no cycle:

The fast runner reaches the finish line.

---

# Core Idea

Use two pointers.

Slow moves one node.

Fast moves two nodes.

If they meet:

Cycle exists.

If fast reaches null:

No cycle.

---

# Algorithm

1. Initialize slow and fast at head.
2. Move slow by one step.
3. Move fast by two steps.
4. If both pointers meet, cycle exists.
5. If fast reaches null, cycle does not exist.

---

# Key Snippet

Detect meeting:

```java
if(slow == fast){
    return true;
}
