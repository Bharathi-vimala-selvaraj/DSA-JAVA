class Node {

    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class DeleteByPosition {

    Node head;

    public void deleteByPosition(int position){

        if(head == null){
            return;
        }

        if(position == 1){

            head = head.next;

            return;
        }

        Node prev = head;
        Node curr = head.next;

        int index = 2;

        while(curr != null){

            if(index == position){

                prev.next = curr.next;

                return;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }
    }
}
