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

    public void reverse(){

        if(head == null || head.next == null){
            return;
        }

        Node curr = head;
        Node temp = null;

        while(curr != null){

            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        head = temp.prev;
    }
}
