class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SumOfNodes {

    Node head;

    public int sumOfNodes() {

        int sum = 0;

        Node temp = head;

        while (temp != null) {

            sum += temp.data;

            temp = temp.next;
        }

        return sum;
    }
}
