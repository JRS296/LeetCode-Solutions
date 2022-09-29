//Attempt #1 - 20mins + break +
//Link: https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/

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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ListNode hf1 = new ListNode();
        ListNode hf2 = new ListNode();
        
        int len = 0;
        ListNode x = head;
        while(x!=null)
        {
            len++;
            x = x.next;
        }
        //System.out.println(x.val);
        x = head;
        int i = 1;
        while(x!=null)
        {
            if(i>len-k)
            {
                System.out.println(i + " " + x.val);
                hf2.next = x;
                hf2 = hf2.next;
            }
            else if(i<=len-k)
            {
                System.out.println(i + " " + x.val + "*");
                ans.next = x;
                ans = ans.next;
            }
            i++;
            x = x.next;
        }
        // for(int i=1; i<=len; i++)
        // {
        //     if(i>len-k-1)
        //     {
        //         //System.out.println(i + " " + x.val);
        //         ans.next = new ListNode(x.val);
        //         //x = x.next;
        //         ans = ans.next;
        //     }
        //     System.out.println(x.val);
        //     x = x.next;
        // }
        // x = head;
        // for(int i=1; i<=len-k; i++)
        // {
        //     //System.out.println(i + " " + x.val);
        //     hf2 = new ListNode(x.val);
        //     hf2 = hf2.next;
        //     x = x.next;
        // }
        
        
        
        return hf2;
    }
}

/*
Couldn't compile on time
Understand how to Build Linked List under given scenario.
 */