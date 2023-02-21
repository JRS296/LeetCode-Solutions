//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
class Solution { //Use BFS, reverse list at every even pos
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList();
        if(root==null){
            return ans;
        }
        Queue <TreeNode> q = new LinkedList();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList();
            int c = q.size();
            for(int i=0;i<c;i++){
                TreeNode cur = q.poll();
                l.add(cur.val);
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            if(level%2==0){
                List<Integer> ll = new ArrayList();
                for(int i =l.size()-1;i>=0;i--){
                    ll.add(l.get(i));
                }
                ans.add(ll);
            }else{
                ans.add(l);
            }
            level++;
        }
        return ans;
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
41.3 MB
Beats
20%
 */