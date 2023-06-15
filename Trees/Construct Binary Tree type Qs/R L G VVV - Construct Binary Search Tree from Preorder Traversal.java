//Attempt #1 - null
//Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
     return helper(preorder, 0, preorder.length - 1);   
    }
    //https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/solutions/589059/java-easiest-solution-with-clear-explanation-of-logic/
    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) return null;
        
        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for(i=start;i<=end;i++) {
        if(preorder[i] > node.val)
            break;
        }
        
        node.left = helper(preorder, start+1, i-1);
        node.right = helper(preorder, i, end);
        return node;
    } 
}

/*
Runtime
0 ms
Beats
100%
Memory
40.6 MB
Beats
50.19%
 */