//Attempt - null
//Link: https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head, p2 = head.next, p3 = null;
        p3 = swapPairs(p2.next);
        p1.next = p3;
        p2.next = p1;
        return p2;
    }
}

/*
Runtime: 0 ms - beats 80%
Memory Usage: 39.8 MB - beats -

Time: O(n)
Space: Not constant
 */

//Iterative Approach - O(n)

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)  return head;
        ListNode curr = head.next.next;
        ListNode prev = head;
        head = head.next;                 //Swapping first two nodes outside loop to maintain head.
        head.next = prev;
        while(curr!=null && curr.next!=null){
            prev.next = curr.next;
            prev = curr;
            ListNode nxt = curr.next.next;   //Create new node nxt to keep hold of linked list.
            curr.next.next = curr;
            curr = nxt;
        }
        prev.next = curr;
        return head;
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
39.7 MB
Beats
90.26%
 */