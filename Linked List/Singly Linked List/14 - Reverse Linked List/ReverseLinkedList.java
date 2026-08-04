class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedList {

    Node head;

    public void reverse() {

        Node prev = null;
        Node curr = head;

        while(curr != null){

            Node next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        head = prev;
    }
}
