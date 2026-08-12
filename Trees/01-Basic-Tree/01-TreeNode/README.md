# 01 - TreeNode

Basic implementation of a Binary Tree Node in Java.

## Main Code

```java
static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
Creating a Node
TreeNode root = new TreeNode(10);

Creates:

10

Initially:

root.val   → 10
root.left  → null
root.right → null
Connecting Nodes
TreeNode root = new TreeNode(10);

root.left = new TreeNode(20);
root.right = new TreeNode(30);

Tree:

       10
      /  \
    20    30
Adding Another Level
root.left.left = new TreeNode(40);
root.left.right = new TreeNode(50);

Tree:

        10
       /  \
     20    30
    /  \
   40   50
Important Java Points
this.val
this.val = val;

Means:

object's val = constructor's val
Child References
root.left
root.right

store references to other TreeNode objects.

Empty Child
root.left = null;
root.right = null;

means that child does not exist.

Memory Pattern
TreeNode
   |
   ├── val
   ├── left
   └── right

Every Binary Tree node has:

1 value
2 child references
Common Mistakes
root.left = 20;              // ❌
root.left = new TreeNode(20); // ✅

left and right are TreeNode references, so they need a TreeNode object.

TreeNode root = new TreeNode(10); // ✅

Do not confuse:

root.val

with:

root

root.val is the value.

root is the node/reference itself.

Quick Revision
Create:
TreeNode root = new TreeNode(10);

Left:
root.left = new TreeNode(20);

Right:
root.right = new TreeNode(30);

Value:
root.val

Left child:
root.left

Right child:
root.right

No child:
null
