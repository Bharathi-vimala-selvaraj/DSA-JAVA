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

    public void deleteByValue(int value){

        if(head == null){
            return;
        }

        if(head.data == value){

            if(head.next == null){
                head = null;
            }
            else{
                head = head.next;
                head.prev = null;
            }

            return;
        }

        Node curr = head.next;

        while(curr != null){

            if(curr.data == value){

                if(curr.next == null){

                    curr.prev.next = null;
                }
                else{

                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }

                curr.prev = null;
                curr.next = null;

                return;
            }

            curr = curr.next;
        }
    }
}
