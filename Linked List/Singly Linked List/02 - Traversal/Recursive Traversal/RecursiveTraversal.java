class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RecursiveTraversal {

    public void traverse(Node head) {

        // Base Case
        if (head == null) {
            return;
        }

        // Process Current Node
        System.out.print(head.data + " ");

        // Recursive Call
        traverse(head.next);
    }
}
