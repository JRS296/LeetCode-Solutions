//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/merge-k-sorted-lists/description/

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
        public ListNode mergeKLists(ListNode[] lists) {
            //if(lists.length == null ) return null;
            if(lists.length == 0) return null;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int i=0; i<lists.length; i++)
            {
                ListNode x = lists[i];
                while(x!=null)
                {
                    arr.add(x.val);
                    x = x.next;
                }
            }
            Collections.sort(arr);
            System.out.println(arr);
            ListNode ans = new ListNode(0);
            ListNode x = ans;
            for(int i=0; i<arr.size(); i++)
            {
                ans.next = new ListNode(arr.get(i));
                ans = ans.next;
            }
            return x.next;
        }
    }

/*
Runtime
13 ms
Beats
19.32%
Memory
43.8 MB
Beats
92.68%

TC - O(n^2)
SP - O(n)
 */

//Optimal Solution - Divide & Conquer

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return divideAndConquer(lists, 0, lists.length - 1);
        }
        public ListNode divideAndConquer(ListNode[] lists,int low,int high){
            if(low>high)
                return null;
            if(low==high)
                return lists[low];
            int mid=low+(high-low)/2;
            ListNode left=divideAndConquer(lists,low,mid);
            ListNode right=divideAndConquer(lists,mid+1,high);
            return merge(left,right);
        }
        public ListNode merge(ListNode n1, ListNode n2) {
            ListNode dummy = new ListNode(-1);
            ListNode prev = dummy;
            while (n1!=null && n2!=null){
                if (n1.val<n2.val) {
                    prev.next = n1;
                    n1 = n1.next;
                }
                else{
                    prev.next = n2;
                    n2 = n2.next;
                }
                prev = prev.next;
            }
            if(n1!=null)
                prev.next=n1;
            if(n2!=null)
                prev.next=n2;
            return dummy.next;
        }
    }

// https://leetcode.com/problems/merge-k-sorted-lists/solutions/3288787/java-easy-divide-and-conquer-similar-to-merge-sort/

/*
Runtime
1 ms
Beats
100%
Memory
44.4 MB
Beats
46.8%

Time Complexity: O(Nlog(k))
Space Complexity: O(log(k)) as we use recursion (depth of the recursion tree)
 */