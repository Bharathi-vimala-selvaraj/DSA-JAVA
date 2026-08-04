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

    // Iterative Search
    public boolean searchIterative(int value){

        Node temp = head;

        while(temp != null){

            if(temp.data == value){
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // Recursive Search
    public boolean searchRecursive(Node head, int value){

        if(head == null){
            return false;
        }

        if(head.data == value){
            return true;
        }

        return searchRecursive(head.next, value);
    }
}
