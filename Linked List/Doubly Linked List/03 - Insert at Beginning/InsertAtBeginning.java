class Node{

    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList{

    Node head;

    public void insertAtBeginning(int data){

        Node node = new Node(data);

        if(head == null){

            head = node;

            return;
        }

        node.next = head;

        head.prev = node;

        head = node;
    }
}
