// Question 6: Remove Duplicates from Linked-List

// Skill Mapping: Intermediate

// Description: Consider a Linked-List with N number of repeated integers in Data-Node.

// Task - WAP in Java to remove the repeated integer numbers from Linked-List.

// Sample input: Linked-List:- 2->5->12->2->3->5->1->2->5->5

// Output:- 2->5->12->3->1


import java.util.Scanner;

class LinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the linked list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to remove duplicates from the linked list
    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            linkedList.insert(data);
        }

        System.out.println("Original Linked List:");
        linkedList.display();

        linkedList.removeDuplicates();

        System.out.println("Linked List after removing duplicates:");
        linkedList.display();
    }
}
