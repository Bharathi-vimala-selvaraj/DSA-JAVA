class Node {

    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class DeleteAfterValue {

    Node head;

    public void deleteAfterValue(int value){

        if(head == null){
            return;
        }

        Node curr = head;

        while(curr != null){

            if(curr.data == value){

                if(curr.next == null){
                    return;
                }

                curr.next = curr.next.next;

                return;
            }

            curr = curr.next;
        }
    }
}
