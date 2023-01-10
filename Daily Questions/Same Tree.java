//Attempt #1 - 10mimns
//Link: https://leetcode.com/problems/same-tree/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String list1 = serialize(p);
        String list2 = serialize(q);
        //System.out.println(list1 + " " + list2);
        return (list1.equals(list2));
    }

    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }
}

/*
Top 7%

 */

//Optimal Solution 

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
     
     // If both p and q are null, then they are the same tree
     if (p == null && q == null) return true;
     
     // If only one of p and q is null, then they are not the same tree
     if (p == null || q == null) return false;
     
     // If the values of p and q are different, then they are not the same tree
     if (p.val != q.val) return false;
     
     // Recursively check the left and right subtrees of p and q
     // If both the left and right subtrees are the same, then p and q are the same tree
     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
   }
 }

/*
Runtime
0 ms
Beats
100%
Memory
39.7 MB
Beats
87.65%
 */