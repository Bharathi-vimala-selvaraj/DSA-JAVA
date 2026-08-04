# 01. Node Creation (Singly Linked List)

## 📌 Problem

Learn how a node is created and how nodes are connected to form a Singly Linked List.

---

## 🧠 Core Logic

A linked list is made of **nodes**.

Each node contains:

- Data
- Address of the next node

```text
+------+-------+
| Data | Next  |
+------+-------+
```

The last node always points to

```text
null
```

---

## 📖 Node Structure

```java
class Node{
    int data;
    Node next;
}
```

- `data` stores the value.
- `next` stores the reference (address) of the next node.

---

## 🔗 Creating a Linked List

```text
Before Linking

10      20      30

After Linking

10 → 20 → 30 → null
```

Connections are created using

```java
first.next = second;
second.next = third;
```

---

## ⚙️ Algorithm

1. Create the Node class.
2. Store data in each node.
3. Initialize `next` as `null`.
4. Create multiple nodes.
5. Connect nodes using the `next` pointer.
6. Store the first node in `head`.

---

## 🎯 Interview Traps

### ❌ Trap 1

Forgetting to initialize

```java
next = null;
```

Although Java initializes object references to `null` by default, explicitly assigning it improves readability and makes your intent clear.

---

### ❌ Trap 2

Thinking a node stores another node.

Wrong:

```text
Node
 ↓
20
```

Correct:

```text
Node
 ↓
Address of 20
```

The `next` variable stores a **reference**, not the entire node.

---

### ❌ Trap 3

Confusing `head` with a node.

`head` is **only a reference** to the first node.

```text
head
 ↓
10 → 20 → 30 → null
```

If `head` changes, the first node of the list changes.

---

## ⏱ Complexity

| Operation | Complexity |
|-----------|------------|
| Create Node | O(1) |
| Connect Two Nodes | O(1) |

Space per node:

```
O(1)
```

---

# 🔥 Alli's Interview Notes

- A node is an object.
- `head` is not a node; it points to the first node.
- `next` stores a reference, not the node itself.
- If you understand Node creation, every Linked List algorithm becomes pointer manipulation.

---

## ✅ Revision Checklist

- [ ] Can I draw a node?
- [ ] Can I explain what `next` stores?
- [ ] Can I explain why the last node points to `null`?
- [ ] Can I create and connect three nodes without looking at code?
- [ ] Can I explain the difference between `head` and a node?
