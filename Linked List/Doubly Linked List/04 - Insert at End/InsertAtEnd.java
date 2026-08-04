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

    public void insertAtEnd(int data){

        Node node = new Node(data);

        if(head == null){

            head = node;

            return;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = node;

        node.prev = temp;
    }
}
