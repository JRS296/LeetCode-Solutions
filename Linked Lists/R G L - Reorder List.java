//Attempt #1 - 40mins
//Link: https://leetcode.com/problems/reorder-list/description/

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution { //O(n) O(1)
    public void reorderList(ListNode head) {
        // if head will be null or head.next will be null simply return ;
        if(head==null || head.next==null)return ;

  //finding middle element
        ListNode slow = head;
        ListNode fast= head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       
// reversing the second half of the list
       ListNode newNode = reverseList(slow.next);
      // breaking the list from the middle
        slow.next=null;
   //merging both list
       //first half list pointer
       ListNode curr = head;
       //second half list pointer
       ListNode dummy = newNode;
       while(head!=null && dummy!=null){
             //pointer to store next element of curr(1st half list)
           ListNode temp = curr.next;
           //link element of 1st half to that of second half
           curr.next=dummy;
           //pointer to store next element of dummy(2nd half list)
           ListNode temp2=dummy.next;
           //link the rest of the first half list
           dummy.next=temp;
           //increment curr and dummy pointer to do the same thing again and again util we reach end of the any one list or both list
           curr=temp;
           dummy=temp2;
       }

    }

   // method to reverse the linkedList
    public ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
         
        return prev;
    }
}

/*
Runtime
1 ms
Beats
100%
Memory
46.5 MB
Beats
14.3%

TC - O(n)
SC - O(1)
 */