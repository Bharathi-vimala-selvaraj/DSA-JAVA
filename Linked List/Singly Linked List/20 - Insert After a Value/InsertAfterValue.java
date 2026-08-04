class Node {

    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class InsertAfterValue {

    Node head;

    public void insertAfterValue(int value, int newValue){

        Node curr = head;

        while(curr != null){

            if(curr.data == value){

                Node node = new Node(newValue);

                node.next = curr.next;

                curr.next = node;

                return;
            }

            curr = curr.next;
        }
    }
}
