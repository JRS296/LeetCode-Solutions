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

//New Attempt - 15mins - full cheese

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)return head;

        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(head!=null) {
            arr.add(head.val);
            head = head.next;
        }

        int arrSize = 0;
        if(arr.size()%2!=0) arrSize = arr.size()-1;
        else arrSize = arr.size();

        for(int i=0; i<arrSize; i++) {
            if(i%2==0) {
                int temp = arr.get(i);
                arr.set(i,arr.get(i+1));
                arr.set(i+1, temp);
            }
        }

        ListNode ans = new ListNode(0);
        ListNode finAns = ans;
        for(int i=0; i<arr.size(); i++) {
            ListNode x = new ListNode(arr.get(i));
            ans.next = x;
            ans = ans.next;
        }

        return finAns.next;
    }
}

/*
O(N)
O(n)
 */


//Optimal

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode d = new ListNode(0), a;
        d.next = head;
        a=d;
        while(head!=null&&head.next!=null) {
            a.next = head.next;
            head.next = head.next.next;
            a.next.next = head;
            a = a.next.next;
            head =  head.next;
        }
        return d.next;
    }
}