
//link: https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208

//Hint: Put the odd nodes in a linked list and the even nodes in another. Then link the evenList to the tail of the oddList.

//Attempt #1 - nil
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode x = head;
        ListNode odd = new ListNode(x.val);
        ListNode even = new ListNode(x.next.val);
        int len = 1;
        while (x != null) {
            // System.out.println(x.val + " "+ len);
            int val = x.val;
            if (len % 2 != 0) {
                // System.out.println(x.val + " "+ len + " "+ odd.val + " "+ even.val);
                ListNode y = new ListNode(val);
                System.out.println(y.val);
                y.next = null;
                // if(odd.next==null)
                // {
                // odd.next = y;
                // }
                while (odd.next != null) {
                    odd = odd.next;
                }
                odd.next = y;
            } else if (len % 2 == 0) {
                ListNode y = new ListNode(val);
                y.next = null;
                while (even.next != null) {
                    even = even.next;
                }
                even.next = y;
            }
            x = x.next;
            len++;
        }

        odd.next = even;
        return even;
    }
}

//Time Complexity: O(n^2) - not as required

//Attempt #2 - 1 hour
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
class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        
        ListNode even = head.next;
        ListNode odd = head;
        
        ListNode EVL = even;
        
        while(even!=null && even.next!=null)
        {
            odd.next = even.next;
            odd = odd.next;
            
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = EVL;
        return head;
    }
}

/*
70 / 70 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 45.2 MB

Time Complexity: O(n)
Space Complexity: O(1) - inplace
 */