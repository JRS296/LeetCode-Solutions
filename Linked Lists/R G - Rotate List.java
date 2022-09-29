//Attempt #1 - 20mins + break + 40 mins (of decoding)
//Link: https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/

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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ListNode hf1 = new ListNode();
        ListNode hf2 = new ListNode();

        int len = 0;
        ListNode x = head;
        while (x != null) {
            len++;
            x = x.next;
        }
        // System.out.println(x.val);
        x = head;
        int i = 1;
        while (x != null) {
            if (i > len - k) {
                System.out.println(i + " " + x.val);
                hf2.next = x;
                hf2 = hf2.next;
            } else if (i <= len - k) {
                System.out.println(i + " " + x.val + "*");
                ans.next = x;
                ans = ans.next;
            }
            i++;
            x = x.next;
        }
        // for(int i=1; i<=len; i++)
        // {
        // if(i>len-k-1)
        // {
        // //System.out.println(i + " " + x.val);
        // ans.next = new ListNode(x.val);
        // //x = x.next;
        // ans = ans.next;
        // }
        // System.out.println(x.val);
        // x = x.next;
        // }
        // x = head;
        // for(int i=1; i<=len-k; i++)
        // {
        // //System.out.println(i + " " + x.val);
        // hf2 = new ListNode(x.val);
        // hf2 = hf2.next;
        // x = x.next;
        // }

        return hf2;
    }
}

/*
 * Couldn't compile on time
 * Understand how to Build Linked List under given scenario.
 */

// Attempt #2 - 20 mins
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
class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ListNode hf1 = new ListNode(0);
        ListNode hf2 = new ListNode(0);

        int len = 0;
        ListNode x = head;
        ListNode y = hf1;
        while (x != null) {
            len++;
            x = x.next;
        }
        // System.out.println(x.val);
        x = head;
        int i = 1;
        while (x != null) {
            if (i == len - k + 1) {
                hf2 = x;
            } else if (i <= len - k) {
                // System.out.println(i + " " + x.val + "*");
                hf1.next = new ListNode(x.val);
                hf1 = hf1.next;
            }
            i++;
            x = x.next;
        }
        // hf2.next = hf1;
        ans = hf2;
        while (hf2.next != null) {
            hf2 = hf2.next;
        }
        hf2.next = y.next;

        return ans;
    }
}

/*
 * 141 / 231 test cases passed.
 */

// Attempt 3 - 15mins
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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ListNode hf1 = new ListNode(0);
        ListNode hf2 = new ListNode(0);

        int len = 0;
        ListNode x = head;
        ListNode y = hf1;
        while (x != null) {
            len++;
            x = x.next;
        }
        if (head == null || head.next == null || k == 0 || k % len == 0)
            return head;
        if (k >= len) {
            k = k % len;
        }
        x = head;
        int i = 1;
        while (x != null) {
            if (i == len - k + 1) {
                hf2 = x;
            } else if (i <= len - k) {
                // System.out.println(i + " " + x.val + "*");
                hf1.next = new ListNode(x.val);
                hf1 = hf1.next;
            }
            i++;
            x = x.next;
        }
        // hf2.next = hf1;
        ans = hf2;
        while (hf2.next != null) {
            hf2 = hf2.next;
        }
        hf2.next = y.next;

        return ans;
    }

}

    /*
     * 231 / 231 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 42.5 MB
     * 
     * Time Complexity: O(n) (beats 84%)
     * Space Complexity: O(1) (beats 81%)
     * 
     * Good solution, got confused with implementation, understand clearly where
     * each pointer goes during iterations.
     * Also take care to check boundary conditions.
     */

    // Other Solutions (simple)
public ListNode rotateRight(ListNode head, int k) {
    ListNode dummy = head;
    //for empty or list with 1 node return them as such         
    if(head == null || head.next == null)
        return head;
    //length starts from 1 to include last element
    int n = 1;
    //goes until last element
    while(dummy.next!=null){
        dummy = dummy.next;
        n++;
    }
    //Set the last node to head to form circular linked list
    dummy.next = head;
    dummy = head;
    // Rotating n*a times would just give the same linked list so remove them
    k = k%n;
    //  Since we rotate right we have to find the (n-k)th element which is the head      
    for(int i = 0;i<n-k-1;i++){
        dummy = dummy.next;
    }
    //Break the cycle by keeping head as (n-k) and setting (n-k-1)th element as tail
    head = dummy.next;
    dummy.next = null;
    return head;
}
/*
Not as good as mine, but still solid
 */