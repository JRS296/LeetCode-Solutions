//Attempt #1 - null
//Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    //Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/1588974/java-recursive-most-intutive-intution-explanation-using-image/
    public TreeNode build(int[] inorder, int inS, int inE, int[] postorder, int posS, int posE){
        if(inS>inE || posS>posE) return  null;
        
        TreeNode root = new TreeNode(postorder[posE]);
        
        int rootI=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                rootI = i;
                break;
            }
        }
        
        root.left = build(inorder,inS,rootI-1,postorder,posS,posS+rootI-inS-1);
        root.right = build(inorder,rootI+1,inE,postorder,posS+rootI-inS,posE-1);
        
        return root;
    }
}

/*
Runtime
4 ms
Beats
41.43%
Memory
42.1 MB
Beats
62.25%
 */