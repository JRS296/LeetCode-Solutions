//Attempt #1 - 20mins
//Link: https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode a = ans;
        String num1 = "", num2 = "";
        
        while(l1!=null)
        {
            num1+=String.valueOf(l1.val);  
            l1 = l1.next;
        }
        
        while(l2!=null)
        {
            num2+=String.valueOf(l2.val);  
            l2 = l2.next;
        }
        
        int len1 = num1.length(); int len2 = num2.length();
        String n1 = ""; String n2 = "";
        for(int i=len1-1; i>-1; i--)
        {
            n1+=num1.charAt(i);
        }
        
        for(int i=len2-1; i>-1; i--)
        {
            n2+=num2.charAt(i);
        }
        
        int x = Integer.parseInt(n1) + Integer.parseInt(n2);
        //System.out.println(x);
        int l = String.valueOf(x).length();
        for(int i=0; i<l; i++)
        {
            int n = x%10;
            ans.next = new ListNode(n);
            //System.out.println(ans.next.val);
            ans = ans.next;
            x/=10;
        }
        
        return a.next;
    }
}

/*
32 / 1568 test cases passed
 */