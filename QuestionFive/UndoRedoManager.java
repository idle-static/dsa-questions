package LinkedList;

import java.util.Scanner;

/**
 * Implememt an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowoing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager {
    private static class Node {
        private String state;
        private Node prev;
        private Node next;

        private Node(String state) {
            this.state = state;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head, currentState;

    public UndoRedoManager() {
        head = null;
        currentState = null;
    }

    //Undo operation
    public void undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("No state to undo");
        } else {
            currentState = currentState.prev;
            System.out.println("Undone, current state is now: " + currentState.state);
        }
    }

    //Redo operation
    public void redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("No state to redo");
        } else {
            currentState = currentState.next;
            System.out.println("Redone, current state is now: " + currentState.state);
        }
    }

    //perform an operation
    public void addState(String newState) {
        Node newNode = new Node(newState);

        //Set the links for the new Node
        if (head == null) {
            head = newNode;
            currentState = newNode;
        } else {
            //Update the next link for the current state
            currentState.next = null;
            newNode.prev = currentState;
            currentState.next = newNode;

            //Update the current to the new state
            currentState = newNode;
        }
    }

    public void showCurrentState() {
        if (currentState == null) {
            System.out.println("No states available");
        } else {
            System.out.println("Current state: " + currentState.state);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here's an example of undo / redo functionality.");

        UndoRedoManager app = new UndoRedoManager();

        app.addState("State 1");
        app.addState("State 2");
        app.addState("State 3");
        app.addState("State 4");
        app.addState("State 5");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Show Current State");
            System.out.println("2. Add New State");
            System.out.println("3. Redo");
            System.out.println("4. Undo");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            if (option == 1) {
                app.showCurrentState();
            } else if (option == 2) {
                System.out.print("Enter the new state: ");
                String newState = scanner.next();
                app.addState(newState);
            } else if (option == 3) {
                app.redo();
            } else if (option == 4) {
                app.undo();
            } else if (option == 5) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }
        scanner.close();
    }
}