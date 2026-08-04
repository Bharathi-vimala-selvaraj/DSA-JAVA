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

    // Forward Traversal
    public void forwardTraversal(){

        Node temp = head;

        while(temp != null){

            System.out.print(temp.data + " ");

            temp = temp.next;
        }
    }

    // Backward Traversal
    public void backwardTraversal(){

        if(head == null){
            return;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        while(temp != null){

            System.out.print(temp.data + " ");

            temp = temp.prev;
        }
    }
}
