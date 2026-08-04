class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MiddleNode {

    Node head;

    public Node findMiddle() {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;

            fast = fast.next.next;
        }

        return slow;
    }
}
