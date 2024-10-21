package LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.createLinkedList(1);

        linkedList.insertInLinkedList(3, 1);
        linkedList.insertInLinkedList(5, 2);
        linkedList.insertInLinkedList(7, 3);
        linkedList.insertInLinkedList(9, 4);
        linkedList.insertInLinkedList(11, 5);
        linkedList.insertInLinkedList(13, 6);

        linkedList.traverseLinkedList();

        linkedList.deleteFromLinkedList(-1); // Out of bounds, won't delete
        linkedList.traverseLinkedList();

        linkedList.deleteFromLinkedList(0); // Deletes the head
        linkedList.traverseLinkedList();

        linkedList.deleteFromLinkedList(5); // Deletes the tail
        linkedList.traverseLinkedList();

        linkedList.deleteFromLinkedList(1); // Deletes the third node!
        linkedList.traverseLinkedList();

    }
}
