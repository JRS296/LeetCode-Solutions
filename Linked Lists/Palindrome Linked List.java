//Link: https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209

//Attempt #1 - 30mins
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
    public boolean isPalindrome(ListNode head) {
        int len = 0; int vals = 0;
        
        ListNode x = head;
        ListNode y = new ListNode();
        while(x!=null)
        {
            if (x.next == null)
            {
                y = x;
            }
            x = x.next;
            
            len++;
        }
        vals = len/2;
        System.out.println(vals);
        ListNode x = head;
        
        for(int i=0; i<vals)
        
        
        return true;
    }
}

/*
Does not Work in place, need to copy Linked List to another DS to backtrack end pointer
 */

//Attempt #2
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
    public boolean isPalindrome(ListNode head) {
        int len = 0; int vals = 0;
        ListNode x = head;
        ArrayList<Integer> arr = new ArrayList();
        while(x!=null)
        {
            arr.add(x.val);
            x = x.next;
            len++;
        }
        vals = len/2;
        //System.out.println(arr);
        
        int i = 0;
        int j = len-1;
        while(i<j)
        {
            if(arr.get(i)!=arr.get(j))
            {
                return false;
            }
            
            i++;
            j--;
        }
        return true;
    }
}
/*
88 / 88 test cases passed.
Status: Accepted
Runtime: 32 ms (beats 15%)
Memory Usage: 112.3 MB (poor)

Time Complexity: O(n)
Space Complexity: O(n) - not in place, but it works
 */

 //Attempt #3 - Less than 2 mins
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
    public boolean isPalindrome(ListNode head) {
        int len = 0; int vals = 0;
        ListNode x = head;
        while(x!=null)
        {
            x = x.next;
            len++;
        }
        ArrayList<Integer> arr = new ArrayList(len);
        while(head!=null)
        {
            arr.add(head.val);
            head = head.next;
        }
        vals = len/2;
        //System.out.println(arr);
        
        int i = 0;
        int j = len-1;
        while(i<j)
        {
            if(arr.get(i)!=arr.get(j))
            {
                return false;
            }
            
            i++;
            j--;
        }
        return true;
    }
}
/*
88 / 88 test cases passed.
Status: Accepted
Runtime: 7 ms (beats 67%)
Memory Usage: 63.5 MB (much better)

Much Faster because of the initial len addition to ArrayList
 */