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

    public void deleteFromEnd(){

        if(head == null){
            return;
        }

        if(head.next == null){
            head = null;
            return;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.prev.next = null;

        temp.prev = null;
    }
}
