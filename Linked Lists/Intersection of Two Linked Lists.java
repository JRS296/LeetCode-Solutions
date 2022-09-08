//Link: https://leetcode.com/problems/intersection-of-two-linked-lists/

//Attempt #1 - 15mins 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = (p1 == null) ? headA : p1.next;
            p2 = (p2 == null) ? headB : p2.next;
        }
        return p1;
    }
}

// Two possible approaches
/*
 * 1) Using two pointers, that keep cycling back to start until they match
 * 2) Finding length, and then calculating accordingly
 */

/*
 * 39 / 39 test cases passed.
 * Status: Accepted
 * Runtime: 338 ms
 * Memory Usage: 56.1 MB
 * 
 * Bad runtime - cyclic attempts - not optimal
 */

// Alternate Solution
class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}

/*
 * 39 / 39 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms - much better
 * Memory Usage: 55.2 MB
 */