class Node {

    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicates {

    Node head;

    public void removeDuplicates(){

        if(head == null || head.next == null){
            return;
        }

        Node curr = head;

        while(curr.next != null){

            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
    }
}
