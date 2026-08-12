
# 02 - Manual Tree Construction

Build a Binary Tree manually by creating `TreeNode` objects and connecting them using `left` and `right`.

## Core Pattern

```java
TreeNode root = new TreeNode(10);

root.left = new TreeNode(20);
root.right = new TreeNode(30);

Creates:

       10
      /  \
    20    30
Adding More Levels
root.left.left = new TreeNode(40);
root.left.right = new TreeNode(50);

root.right.right = new TreeNode(60);

Result:

        10
       /  \
     20    30
    / \      \
   40  50     60
Important Pattern
parent.left = new TreeNode(value);
parent.right = new TreeNode(value);

Think:

CREATE → CONNECT
Accessing Nodes
root.val
root.left
root.right

Example:

System.out.println(root.left.val);

Output:

20

Access deeper nodes:

System.out.println(root.left.left.val);

Output:

40
Common Mistake

❌ Wrong:

root.left = 20;

left expects a TreeNode.

✅ Correct:

root.left = new TreeNode(20);
Important Difference
root.val

means the value stored in the node.

root.left

means the left child node/reference.

root.left.val

means the value of the left child.

Quick Revision
Create root:
TreeNode root = new TreeNode(10);

Create left:
root.left = new TreeNode(20);

Create right:
root.right = new TreeNode(30);

Create deeper node:
root.left.left = new TreeNode(40);
Memory Trick
Node → CREATE
        ↓
     CONNECT
        ↓
   left / right
