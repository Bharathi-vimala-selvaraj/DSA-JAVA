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

    public void insertAtPosition(int position, int data){

        Node node = new Node(data);

        if(position <= 0){
            return;
        }

        if(position == 1){

            if(head != null){
                head.prev = node;
                node.next = head;
            }

            head = node;
            return;
        }

        Node temp = head;
        int count = 1;

        while(temp != null && count < position - 1){
            temp = temp.next;
            count++;
        }

        if(temp == null){
            return;
        }

        node.next = temp.next;
        node.prev = temp;

        if(temp.next != null){
            temp.next.prev = node;
        }

        temp.next = node;
    }
}
