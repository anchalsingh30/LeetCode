package List;

import java.util.ArrayList;
import java.util.List;


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to start the result linked list
        ListNode current = dummy; // Current node to build the result linked list
        int carry = 0; // Carry value for addition

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Update the carry
            current.next = new ListNode(sum % 10); // Create a new node with the remainder as the value
            current = current.next; // Move to the next node
        }

        if (carry > 0) {
            current.next = new ListNode(carry); // If there's a remaining carry, create a new node for it
        }

        return dummy.next; // Return the result linked list starting from the next node of the dummy node
    }

    public static void main(String[] args) {
        // Example usage
        // Create the first linked list: 2 -> 4 -> 3 (representing the number 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create the second linked list: 5 -> 6 -> 4 (representing the number 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2); // Add the two numbers

        // Print the result: 7 -> 0 -> 8 (representing the number 807)
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}

