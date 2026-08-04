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

    public int countNodes(){

        int count = 0;

        Node temp = head;

        while(temp != null){

            count++;

            temp = temp.next;
        }

        return count;
    }
}
