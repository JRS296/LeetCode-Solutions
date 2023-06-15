class Solution {
     public boolean isBalanced(TreeNode root) {
         return getHeight(root) != -1;
     }

     private int getHeight(TreeNode root) {
         if (root == null) {
             return 0;
         }
         int leftHeight = getHeight(root. left);
         if (leftHeight == -1) {
             return -1;
         }
         int rightHeight = getHeight(root.right);
         if (rightHeight == -1) {
             return -1;
         }
         // The height difference between the left and right subtrees is greater than 1, and return -1 means that it is no longer a balanced tree
         if (Math. abs(leftHeight - rightHeight) > 1) {
             return -1;
         }
         return Math.max(leftHeight, rightHeight) + 1;
     }
}