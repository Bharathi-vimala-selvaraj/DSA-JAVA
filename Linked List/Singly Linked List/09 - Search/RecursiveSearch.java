class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RecursiveSearch {

    public boolean search(Node head, int value){

        // Base Case
        if(head == null){
            return false;
        }

        // Value Found
        if(head.data == value){
            return true;
        }

        // Search Remaining List
        return search(head.next, value);
    }
}
