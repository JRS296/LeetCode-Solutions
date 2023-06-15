//Attempt #1 - 35mins
//Link: https://leetcode.com/problems/symmetric-tree/description/

class Solution { // Recursively
    public boolean isSymmetric(TreeNode rt) {
        boolean ans = false;
        // Idea - Level Order Traversal to make sure values are same on both sides
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> op = new LinkedList<List<Integer>>();

        if (rt == null)
            return true;
        TreeNode root = rt;
        queue.offer(root);
        int levelNum = 0;
        while (!queue.isEmpty()) {
            levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
                // Same as queue.remove() - poll() will not return error if q is empty.
            }
            op.add(subList);
        }
        System.out.println(op);

        return false;
    }
}

/*
 * Imporper Solution to the problem
 */

// Optimal Solution - (Recusion)
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetricHelp(root.left, root.right);
        }

        private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
            if (left == null || right == null)
                return left == right;
            if (left.val != right.val)
                return false;
            return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
        }
    }
/*
 * 198 / 198 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 40.8 MB
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

// Optimal Solution - Iterative
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            Queue<TreeNode> q = new LinkedList();

            q.add(root.left);
            q.add(root.right);
            while (!q.isEmpty()) {
                TreeNode left = q.poll();
                TreeNode right = q.poll();
                if (left == null && right == null)
                    continue;
                if (left == null || right == null || left.val != right.val)
                    return false;
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }
            return true;
        }
    }

/*
 * 198 / 198 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms
 * Memory Usage: 42.8 MB
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */