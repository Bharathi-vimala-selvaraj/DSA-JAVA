class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IterativeSearch {

    Node head;

    public boolean search(int value) {

        Node temp = head;

        while(temp != null){

            if(temp.data == value){
                return true;
            }

            temp = temp.next;
        }

        return false;
    }
}
