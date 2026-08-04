class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteByValue {

    Node head;

    public void deleteByValue(int value) {

        // Empty List
        if(head == null){
            return;
        }

        // Delete Head
        if(head.data == value){
            head = head.next;
            return;
        }

        Node temp = head;

        while(temp.next != null){

            if(temp.next.data == value){

                temp.next = temp.next.next;
                return;
            }

            temp = temp.next;
        }
    }
}
