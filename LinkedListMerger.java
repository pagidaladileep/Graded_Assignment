// Question 5: Merge and Sort the elements in two Linked-List

// Skill Mapping: Intermediate

// Description: Consider two Linked-List with N number of integers in Data-Node respectively.

// Task 1- WAP in Java to merge both Linked-Lists.

// Task 2 - Sort the output Linked-List basis of its Data-Node in ascending order.

// Sample input: Linked-List-1:- 25->35->12->4->36->48

// Linked-List-2:- 8->32->22->45->63->49

// Output:- 4->8->12->22->25->32->35->36->45->48->49->63

import java.util.Scanner;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class LinkedListMerger {

    public static ListNode mergeSortedLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    public static ListNode insertNode(ListNode head, int value) {
        ListNode newNode = new ListNode(value);

        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        return head;
    }

    public static ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode nextToMiddle = middle.next;
        middle.next = null;

        ListNode left = sortLinkedList(head);
        ListNode right = sortLinkedList(nextToMiddle);

        return merge(left, right);
    }

    private static ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.value < right.value) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        }

        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in List1: ");
        int n1 = scanner.nextInt();
        ListNode list1 = null;
        for (int i = 0; i < n1; i++) {
            int value = scanner.nextInt();
            list1 = insertNode(list1, value);
        }

        System.out.print("Enter the number of elements in List2: ");
        int n2 = scanner.nextInt();
        ListNode list2 = null;
        for (int i = 0; i < n2; i++) {
            int value = scanner.nextInt();
            list2 = insertNode(list2, value);
        }

        scanner.close();

        ListNode mergedList = mergeSortedLists(list1, list2);
        ListNode sortedList = sortLinkedList(mergedList);

        System.out.print("Sorted Output: ");
        printLinkedList(sortedList);
    }
}
