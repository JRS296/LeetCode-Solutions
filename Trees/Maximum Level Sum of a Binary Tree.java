//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int maxSum = root.val;
        int ans = 1;
        int level = 1;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int levelSum = 0;
            for(int i = 0;i<levelSize;i++){
                TreeNode removed = queue.remove();
                levelSum+=removed.val;
                if(removed.left!=null)queue.add(removed.left);
                if(removed.right!=null) queue.add(removed.right);
            }
            if(levelSum>maxSum){
                maxSum = levelSum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}

/*
Runtime
14 ms
Beats
15.28%
Memory
46.5 MB
Beats
16.74%
 */