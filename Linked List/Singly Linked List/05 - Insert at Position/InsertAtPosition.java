public void insertAtPosition(int position, int data) {

    Node newNode = new Node(data);

    // Invalid Position
    if (position < 1) {
        return;
    }

    // Insert at Beginning
    if (position == 1) {
        newNode.next = head;
        head = newNode;
        return;
    }

    Node temp = head;

    // Move to (position - 1)th node
    for (int i = 1; i < position - 1 && temp != null; i++) {
        temp = temp.next;
    }

    // Position Out of Bounds
    if (temp == null) {
        return;
    }

    newNode.next = temp.next;
    temp.next = newNode;
}
