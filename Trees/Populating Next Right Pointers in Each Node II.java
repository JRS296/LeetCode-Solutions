//Attempt #1 - 10mins
//Link: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/1016/

class Solution {
    public Node connect(Node root) {
        List<List<Node>> ans = levelOrder(root);
        //System.out.println(ans);
        for(List<Node> x:ans)
        {
            for(int i=0; i<x.size(); i++)
            {
                if(i==x.size()-1)
                {
                    x.get(i).next = null;
                }
                else
                {
                    x.get(i).next = x.get(i+1);
                }
            }
        }
        return root;
    }
    
    public List<List<Node>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Node>> op = new LinkedList<List<Node>>();

        if (root == null)
            return op;

        queue.offer(root); // queue.add(root) - offer returns false if unsuccessful
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Node> subList = new LinkedList<Node>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll());
                // Same as queue.remove() - poll() will not return error if q is empty.
            }
            op.add(subList);
        }
        return op;
    }
}

/*

55 / 55 test cases passed.
Status: Accepted
Runtime: 6 ms - beats 8%
Memory Usage: 41.9 MB - beats 79%
 */

