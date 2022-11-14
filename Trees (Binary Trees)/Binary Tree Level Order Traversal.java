//Attempt #1 - null
//Link: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931

//General Approach to Level Order Traversal: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/discuss/114449/A-general-approach-to-level-order-traversal-questions-in-Java

//Using preorder
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        compute(ans,root,0);
        return ans;
    }
    
    public void compute(List<List<Integer>> ans,TreeNode curr,int level)
    {
        if(curr==null) return;
        
        if(ans.size()==level) 
            ans.add(new ArrayList<Integer>());
        
        ans.get(level).add(curr.val);
        compute(ans,curr.left,level+1);
        compute(ans,curr.right,level+1);
    }
}

/*
34 / 34 test cases passed.
Status: Accepted
Runtime: 1 ms - beats 93%
Memory Usage: 43.6 MB - beats 50%

Time Complexity: O(n)
Space Complexity: O(n)
 */

//Using BFS + Queue
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}

/*
34 / 34 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 42.4 MB

Time Complexity: O(n)
Space Complexity: O(n)
 */