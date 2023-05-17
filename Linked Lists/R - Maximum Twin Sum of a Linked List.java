//Attempt #1 - Cheese
//Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

class Solution {
    public int pairSum(ListNode head) {
        ListNode x = head;
        int n = 0;
        while(x!=null) {
            n++; x = x.next;
        }

        int arr[] = new int[n];
        x = head;

        int i=0;
        while(x!=null) {
            arr[i++] = x.val;
            x = x.next;
        }

        //System.out.println(Arrays.toString(arr));

        int low = 0;
        int high = n-1;
        int sum = 0;

        while(low<high) {
            sum = Math.max(sum, arr[high--]+arr[low++]);
        }

        return sum;
    }
}

/*
Runtime
5 ms
Beats
89.63%
Memory
67.7 MB
Beats
5.30%
 */

//Optimal

class Solution {
    public int pairSum(ListNode head) {
        ListNode nodeSlow = head, nodeFast = head;
        int res=0;

        //Getting the middle node
        while (nodeFast.next.next!=null){
            nodeFast = nodeFast.next.next;
            nodeSlow = nodeSlow.next;
        }
        nodeSlow.next = reverseList(nodeSlow.next);
        nodeFast = head;
        while(nodeSlow.next!=null){
            res = Math.max(nodeFast.val+nodeSlow.next.val,res);
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next;
        }
        return res;
    }

    //Reversing the Linked List
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev; 

            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}

/*
Traverse through the whole list to get the middle node.
Reversing the second half of the linked list.
([1,2,3,4,5,6] => [1,2,3,6,5,4])
Traversing the linked just like 2 pointer approach and calculating the sum.
{i=0,j=mid
Max(LL[i]+LL[j],LL[i+1]+LL[j+1].....LL[j-1]+LL[n]);
*/

/*
Runtime
5 ms
Beats
89.63%
Memory
61.8 MB
Beats
72.11%
 */