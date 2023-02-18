//Attempt #1 - 30mins
//Link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

class Solution { //Need to use Inorder Traversal
    TreeNode previous = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(previous!=null){
            min = Math.min(min, root.val-previous.val);
        }
        previous = root;
        inOrder(root.right);
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
39.9 MB
Beats
69.99%
 */