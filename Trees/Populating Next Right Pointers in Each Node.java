//Attempt #1 - 10 mins
//Link: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

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

59 / 59 test cases passed.
Status: Accepted
Runtime: 21 ms
Memory Usage: 42.8 MB
 */

//Optimal Soln - 
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node rightNode = null;
            for(int i = q.size(); i > 0; i--) {
                Node cur = q.poll();
                cur.next = rightNode;
                rightNode = cur;
                if(cur.right != null) {
                    q.offer(cur.right);
                    q.offer(cur.left);
                }
            }
        }
        return root;        
    }
}

/*

59 / 59 test cases passed.
Status: Accepted
Runtime: 2 ms - top 59%
Memory Usage: 42.2 MB - top 88%
 */