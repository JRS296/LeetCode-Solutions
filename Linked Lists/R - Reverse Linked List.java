//Attempt #1 - Link: https://leetcode.com/submissions/detail/799034113/?from=explore&item_id=1205
//YT Link - https://www.youtube.com/watch?v=NhapasNIKuQ

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
public class Solution {
    public ListNode reverseList(ListNode head) {
    	if(head == null) return head;
    	
    	ListNode next = head.next;
    	head.next = null;
        
    	while(next != null){
        	ListNode temp = next.next;
        	next.next = head;
        	head = next;
        	next = temp;
        }
    	return head;
    }
}
/*
28 / 28 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 42.8 MB
 */


// public ListNode reverseList(ListNode head) {
// /* recursive solution */
// return reverseListInt(head, null);
// }

// private ListNode reverseListInt(ListNode head, ListNode newHead) {
// if (head == null)
// return newHead;
// ListNode next = head.next;
// head.next = newHead;
// return reverseListInt(next, head);
// }