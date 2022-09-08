//Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

//Attempt #1 - 30mins
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        if(length(head)==1)
        {
            return null;
        }
        //ListNode ans = new ListNode();
        int pos = length(head) + 1 - n;
        //System.out.println(pos);
        
        if (n == 0) {
            head = temp.next; // Change head
            return head;
        }
        
        for(int i=1; temp!=null && i<pos-1; i++)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    
    public int length(ListNode x)
    {
        int length = 0;
        while(x!=null)
        {
            length++;
            x = x.next;
        }
        return length;
    }
}

/*
190 / 208 test cases passed.
O(n) - good
 */

//Attempt #2 - Using Double pointer technique:
// Checkout: https://www.youtube.com/watch?v=XVuQxVej6y8

class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Using two pointers
        ListNode x = new ListNode(0);
        ListNode f = x;
        ListNode s = x;
        x.next = head;
        if(head.next == null)
        {
            return null;
        }
        for(int i=0; i<n; i++)
        {
            f = f.next;
        }
        while(f.next!=null)
        {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return x.next;
    }
}

/*
208 / 208 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 42.5 MB
 */
// Keypoint - Using extra space - for listnode x 