//Attempt #1 - 40mins
//Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Get paths to both nodes
        //Get LCA based on paths
        List<String> ans = binaryTreePaths(root,p,q);
        //System.out.println(ans);
        String x1[] = ans.get(0).split("->");
        String x2[] = ans.get(1).split("->");
        TreeNode s; 
        int x = 0;
        for(int i=0; i<x1.length && i<x2.length; i++)
        {
            //System.out.println(x1[i]+" "+x2[i]);
           
            if(Integer.valueOf(x1[i])==Integer.valueOf(x2[i]))
            {
                x = Integer.valueOf(x1[i]);
                //System.out.println(x);
            }
 
        }
        return new TreeNode(x);
    }

    public List<String> binaryTreePaths(TreeNode root, TreeNode p, TreeNode q) {
        List<String> answer = new ArrayList<String>();
        if (root != null)
        {
            searchBT(root, "", answer, p);
            searchBT(root, "", answer, q);
        }   
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer, TreeNode toFind) {
        if (root == toFind)
            answer.add(path + root.val);
        if (root.left != null)
            searchBT(root.left, path + root.val + "->", answer, toFind);
        if (root.right != null)
            searchBT(root.right, path + root.val + "->", answer, toFind);
    }
}

/*
26/30 cases
 */

//Soln - 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
      if (root == null || root == n1 || root == n2) {
        return root;
      }
  
      TreeNode leftans = lowestCommonAncestor(root.left, n1, n2);
      TreeNode rightans = lowestCommonAncestor(root.right, n1, n2);
  
      if (leftans != null && rightans != null) {
        return root;
      } else if (leftans != null) {
        return leftans;
      } else {
        return rightans;
      }
    }
  }

/*
Runtime
6 ms
Beats
38.4%
Memory
43.5 MB
Beats
56.44%
 */