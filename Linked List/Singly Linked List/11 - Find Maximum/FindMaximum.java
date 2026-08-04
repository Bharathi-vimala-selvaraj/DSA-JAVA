class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindMaximum {

    Node head;

    public int findMaximum() {

        if (head == null) {
            throw new IllegalStateException("Linked List is Empty");
        }

        int max = head.data;

        Node temp = head.next;

        while (temp != null) {

            if (temp.data > max) {
                max = temp.data;
            }

            temp = temp.next;
        }

        return max;
    }
}
