//Attempt #1 - 17 mins
//Link: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/

class Solution {
    // Idea -> Use paths idea to get sum for each path, store in ArrayList, then
    // search
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        ArrayList<Integer> ans = binaryTreePaths(root);
        if(ans.contains(targetSum))
        {
            return true;
        }
        
        return false;
    }

    public ArrayList<Integer> binaryTreePaths(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        if (root != null)
            searchBT(root, 0, answer);
        return answer;
    }

    private void searchBT(TreeNode root, int pathSum, List<Integer> answer) {
        if (root.left == null && root.right == null)
            answer.add(pathSum + root.val);
        if (root.left != null)
            searchBT(root.left, pathSum + root.val, answer);
        if (root.right != null)
            searchBT(root.right, pathSum + root.val, answer);
    }
}

/*
117 / 117 test cases passed.
Status: Accepted
Runtime: 1 ms - 76%
Memory Usage: 44.2 MB - 8%

Time Complexity: O(n)
Space Complexity: O(n)
 */