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

//Attempt #2 - using Linked list

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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stk = new Stack<ListNode>();
        while(head!=null)
        {
            //System.out.println(head.val);
            stk.push(head);
            head = head.next;
        }
        int len = stk.size();
        ListNode tans = new ListNode(0);
        ListNode fans = tans;
        for(int i=0; i<len; i++)
        {
            tans.next = new ListNode(stk.pop().val);
            tans = tans.next;
        }
        //System.out.println(stk);
        return fans.next;
    }
}

/*
Runtime
1 ms
Beats
14.99%
Memory
41.9 MB
Beats
74.65%
 */

//Optimal Soln

class Program {
  public static LinkedList reverseLinkedList(LinkedList head) {
    // Write your code here.
    LinkedList current = head;
    LinkedList prev = null;

    while(current != null) {
      LinkedList temp = current.next;
      current.next = prev;
      prev = current;
      current = temp;
    }
    return prev;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}

