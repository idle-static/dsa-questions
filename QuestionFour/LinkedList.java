package LinkedList;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    //Create a linked List
    public Node createLinkedList(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertInLinkedList(int nodeValue, int location){
        Node node = new Node();
        node.value = nodeValue;
        if (head == null){
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;

    }
    //Traverse a Linked List
    public void traverseLinkedList(){
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i !=size -1 ){
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    //Search for a Node
    public boolean searchNode(int nodeValue) {
        if (head != null){
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.value == nodeValue){
                    System.out.print(" Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println(" Node not found");
        return false;
    }

    //Deleting a Node from a single List
    // 0. if link doesn't exist
    // 1. if deleting at the beginning
    // 2. if deleting at the ending
    // 3. if deleting anywhere in the list

    public void deleteFromLinkedList(int location){
        // If location is invalid
        if (location < 0 || location >= size) {
            System.out.println("Invalid location, link does not exist.");
            return; // throw and out of bounds exception
        }
        // List doesn't exist
        if (head == null) {
            return;
        }
        // Deleting at beginning
        if (location == 0) {
            if (head == tail){
                tail = null;
            }
            head = head.next;

        } else {
            // Anywhere else in list
            Node tempNode = head;
            int index = 0;
            while (index < (location - 1)) {
                tempNode = tempNode.next;
                index++;
            }
            tempNode.next = tempNode.next.next;
            // If tail then adjust tail
            if (tempNode.next == null){
                tail = tempNode;
            }
        }
        size--;
    }
}

