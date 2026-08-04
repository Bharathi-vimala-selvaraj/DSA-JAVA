class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteFromEnd {

    Node head;

    public void deleteFromEnd() {

        // Empty List
        if (head == null) {
            return;
        }

        // Single Node
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        // Reach the second-last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Remove the last node
        temp.next = null;
    }
}
