class Node {

    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class InsertBeforeValue {

    Node head;

    public void insertBeforeValue(int value, int newValue){

        if(head == null){
            return;
        }

        if(head.data == value){

            Node node = new Node(newValue);

            node.next = head;

            head = node;

            return;
        }

        Node prev = head;
        Node curr = head.next;

        while(curr != null){

            if(curr.data == value){

                Node node = new Node(newValue);

                node.next = curr;

                prev.next = node;

                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}
