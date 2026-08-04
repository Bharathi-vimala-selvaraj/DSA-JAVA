// Node Creation in Singly Linked List

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    public static void main(String[] args) {

        // Creating individual nodes
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Linking the nodes
        first.next = second;
        second.next = third;

        // Head of the linked list
        Node head = first;

        // Printing the data
        System.out.println(head.data);
        System.out.println(head.next.data);
        System.out.println(head.next.next.data);
    }
}
