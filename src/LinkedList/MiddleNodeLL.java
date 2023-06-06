package LinkedList;

import java.util.LinkedList;
import java.util.Objects;

public class MiddleNodeLL {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
      /*
      //One way of Solution
      public ListNode middleNode(ListNode head) {
          int length = lengthOfList(head);
          ListNode current = head;
          for(int i = 0; i < length/2; i++) {
              current = current.next;
          }
          return current;

      }
      // for length of the LL
      public int lengthOfList(ListNode head) {
          int length = 0;
          ListNode current = head;
          while(current != null) {
              current = current.next;
              length++;
          }
          return length;
      }
      //TC O(n)
      //SC O(n)
     */

        // Using two pointers in LL
        public ListNode middleNode(ListNode head) {
            if (Objects.isNull(head) || head.val == 0)
                return new ListNode(0);

            if (head.next != null && head.next.next == null)
                return head.next;

            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

  }
    public static void main(String[] args) {

    }
}

//TC O(n) : no. of nodes in LL
// SC O(1), space used by slow and fast