/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

class Solution {
    public boolean hasCycle(ListNode head) { //Class listnode as an object, with variable head
      ListNode slow = head, fast = head; //Make two pointers slow and fast, both equal to initial head.

      while (fast != null && fast.next != null) {
        slow = slow.next; //Increment by 1 
        fast = fast.next.next; //Incremenent by 2 - will initially catch up to slow pointer if cyclic

        if (slow == fast) 
            return true;
      }

      return false;
    }
}
/*
21 / 21 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 45.9 MB
Time Complexity: O(n)
 */