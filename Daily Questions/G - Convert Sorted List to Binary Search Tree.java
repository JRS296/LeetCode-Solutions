//Attempt #1 - 
//Link: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            ListNode ptr = head;
            int end = 0;
            while(ptr!=null)
            {
                end++;
                ptr = ptr.next;
            }
            int arr[] = new int[end];
            end = 0;
            ptr = head;
            while(ptr!=null)
            {
                arr[end++]= (ptr.val);
                ptr = ptr.next;
            }

            //System.out.println(Arrays.toString(arr));
            return sortedArrayToBST(arr, 0, arr.length-1);
        }

        public TreeNode sortedArrayToBST(int arr[], int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(arr[mid]);
    
            /* Recursively construct the left subtree and make it
            left child of root */
            node.left = sortedArrayToBST(arr, start, mid - 1);
    
            /* Recursively construct the right subtree and make it
            right child of root */
            node.right = sortedArrayToBST(arr, mid + 1, end);
            
            return node;
        }
    }

//Idea: BST is self balancing, balanced state needs to be checked at each iteration

/*
TC - O(logn)
SC - O(n)
 */

/*
Runtime
0 ms
Beats
100%
Memory
44 MB
Beats
46.65%
 */