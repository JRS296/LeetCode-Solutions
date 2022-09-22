//Attempy #1 - 30 mins
//Link: https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}

/*
66 / 66 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 49.9 MB
 */

//Keypoint: create dummy node before head, so that even first element can be checked

//Recursion Solution:
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // Once removeElements call is done, right side of the list is solved.
        ListNode rightSideHead = removeElements(head.next, val);
        if (head.val == val) {
            return rightSideHead;
        }
        head.next = rightSideHead;
        return head;
    }
}

//Explanation Image: https://leetcode.com/problems/odd-even-linked-list/Figures/328_Odd_Even.svg