//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/880725421/

class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> nm=new ArrayList<List<Integer>>();
        if(root==null)
            return nm;
        Queue<Node> kk=new LinkedList<>();
        kk.offer(root);
        while(!kk.isEmpty())
        {
            int p=kk.size();
            ArrayList<Integer> k=new ArrayList<>();
            for(int i=0;i<p;i++)
            {
                k.add(kk.peek().val);
                for(Node f:kk.peek().children)
                {
                    kk.offer(f);
                }
                kk.poll();
            }
            nm.add(new ArrayList<>(k));
        }
        return nm;
    }
    }

/*
Runtime
3 ms
Beats
62.6%
Memory
43.1 MB
Beats
88.34%
 */