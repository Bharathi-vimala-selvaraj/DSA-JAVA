class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtEnd {

    Node head;

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        // Empty List
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        // Reach the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Connect the last node to the new node
        temp.next = newNode;
    }
}
