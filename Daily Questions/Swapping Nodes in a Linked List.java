//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode x = head;
        int i=0;
        while(x!=null) {
            i++;
            x = x.next;
        }
        int n = i;
        int arr[] = new int[n];

        x = head;
        i=0;
        while(x!=null) {
            arr[i] = x.val;
            i++;
            x = x.next;
        }

        int temp = arr[k-1];
        arr[k-1] = arr[n-k];
        arr[n-k] = temp;


        ListNode ans = new ListNode(0);
        ListNode finAns = ans;

        for(int j=0; j<n; j++) {
            ListNode tempor = new ListNode(arr[j]);
            ans.next = tempor;
            ans = ans.next;
        }

        return finAns.next;
    }
}

/*
Runtime
7 ms
Beats
12.17%
Memory
65.2 MB
Beats
5.11%

TC - O(n)
SC - O(n)
 */

//Optimal:

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left=head,rigth=head;
        for(int i=1;i<k;i++)
        left=left.next;
        ListNode curr = left;
        while(curr.next!=null){
            curr = curr.next;
            rigth=rigth.next;
        }
        int t = left.val;
        left.val = rigth.val;
        rigth.val =t;
        return head;
    }
}

/*
Intuition
Traverse the list twice - once to find the kth node from the beginning, and then again to find the kth node from the end. After the two nodes are identified, their values can be swapped.

Approach
First initializes two pointers left and right to point to the head of the list. It then moves the left pointer k-1 times to reach the k-th node from the beginning of the list. At this point, left points to the node that needs to be swapped.

The function then initializes a new pointer curr to point to the same node as left. It then moves curr forward until it reaches the end of the list, while also moving right pointer to point to the kth node from the end of the list. Once curr reaches the end of the list, right will point to the kth node from the end.

Finally, the swap the values of the two nodes pointed to by left and right, and returns the head of the modified list.

Complexity
Time complexity:O(n)
Space complexity:O(1)
 */