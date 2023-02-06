//Attempt #1 - 10mins
//Link: https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233

class Solution {
    public TreeNode searchBST(TreeNode root, int val) { 
        if(root == null || root.val==val)
            return root;
        else if(root.val>val) //BST principle
        {
            return searchBST(root.left, val);
        }
        else
            return searchBST(root.right, val);

    }
}

/*
36 / 36 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 42.9 MB
 */