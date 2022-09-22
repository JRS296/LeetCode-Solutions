//Attempt #1 - 40 mins
//Link: https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null? l2:l1; //for case where one of two linked lists are null
        return dummy.next;
    }
}

/*

208 / 208 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 42.8 MB

Time Complexity: O(m+n)
Space Complexity: O(1)

Pretty Good, remember the need for dummy variable
 */