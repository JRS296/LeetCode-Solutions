//Attempt #1 - 35mins
//Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution { //35 mins
    List<Integer> ans = new ArrayList<Integer>();
    ArrayList<TreeNode> graph[] = new ArrayList[500]; 
    HashSet<Integer> visited = new HashSet<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        makeGraph(root, null);
        visited.clear();
        findDist(target, k);
        return ans;
    }

    public void findDist(TreeNode tar, int k) {
        if (tar==null) return;

        if(k==0) {
            ans.add(tar.val);
            return;
        }
        visited.add(tar.val);
        for(TreeNode x : graph[tar.val]) {
            //System.out.println(x.val);
            if(visited.contains(x.val)) continue;
            findDist(x, k-1);
        }
        return;
    }

    public void makeGraph(TreeNode child, TreeNode parent) {
        if(child == null) return;

        if(visited.add(child.val)){
            graph[child.val] = new ArrayList<TreeNode>();
        }

        if(parent != null) {
            graph[parent.val].add(child);
            graph[child.val].add(parent);
        }

        makeGraph(child.right, child);
        makeGraph(child.left, child);
    }
}

/*
Runtime
12 ms
Beats
74.67%
Memory
42.1 MB
Beats
47.20%

TC - O(V+E)
SC - O(N)
 */