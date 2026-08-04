class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteFromBeginning {

    Node head;

    public void deleteFromBeginning() {

        // Empty List
        if (head == null) {
            return;
        }

        // Move head to the next node
        head = head.next;
    }
}
