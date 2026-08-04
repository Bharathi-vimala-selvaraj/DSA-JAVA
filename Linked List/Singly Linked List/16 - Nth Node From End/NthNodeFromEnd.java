class Node {

    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class NthNodeFromEnd {

    Node head;

    public Node findNthFromEnd(int n){

        Node fast = head;
        Node slow = head;


        for(int i=0; i<n; i++){

            if(fast == null){
                return null;
            }

            fast = fast.next;
        }


        while(fast != null){

            slow = slow.next;
            fast = fast.next;
        }


        return slow;
    }
}
