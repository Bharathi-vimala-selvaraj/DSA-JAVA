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

    public void deleteFromBeginning(){

        if(head == null){
            return;
        }

        if(head.next == null){
            head = null;
            return;
        }

        head = head.next;

        head.prev = null;
    }
}
