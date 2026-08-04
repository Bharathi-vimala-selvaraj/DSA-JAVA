class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindMinimum {

    Node head;

    public int findMinimum() {

        if (head == null) {
            throw new IllegalStateException("Linked List is Empty");
        }

        int min = head.data;

        Node temp = head.next;

        while (temp != null) {

            if (temp.data < min) {
                min = temp.data;
            }

            temp = temp.next;
        }

        return min;
    }
}
