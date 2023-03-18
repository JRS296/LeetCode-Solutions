//Attempt #1 - 25mins
//Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

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
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        List<Integer> arr = new ArrayList<Integer>();
        helper(root, arr, 0);
        //System.out.println(ans);
        return ans;
    }

    public void helper(TreeNode root, List<Integer> arr, int total) {
        if (root == null)
            return;
        arr.add(root.val);
        if (root.left == null && root.right == null) {
            int x = 0;
            for(int i=0; i<arr.size(); i++)
            {
                x+=(arr.get(i)*Math.pow(10,arr.size()-i-1));
            }
            ans+=x;
            //System.out.println(ans);
            return;
        }
        helper(root.left, new ArrayList<Integer>(arr), total);
        helper(root.right, new ArrayList<Integer>(arr), total);
    }
}

/*
Runtime
1 ms
Beats
32.22%
Memory
40.6 MB
Beats
34.91%

TC - O(V+E)
SC - O(n)
 */

//Nother Soln
    class Solution {
        int sum=0;
        public int sumNumbers(TreeNode root) {
            helper(root,"");
            return sum;
        }
        public void helper(TreeNode root,String str){
            if(root==null){
                return;
            }
            str+=root.val;
            if(root.left==null && root.right==null){
                sum+=Integer.parseInt(str);
                return;
            }
            helper(root.left,str);
            helper(root.right,str);
        }
    }

