//Attempt #1 - 1hr 15mins
//Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Use BFS to traverse Tree at each level
        List<List<Integer>> ans = new ArrayList<>();
        compute(ans, root, 0);
        // System.out.println(ans);
        StringBuilder finAns = new StringBuilder("[");
        for (int i = 0; i < ans.size() - 1; i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                int x = 0;
                try {
                    x = ans.get(i).get(j);
                } catch (NullPointerException e) {
                    finAns.append("null,");
                    continue;
                }
                finAns.append(Integer.toString(x) + ",");
            }
        }
        finAns.deleteCharAt(finAns.length() - 1);
        finAns.append("]");
        return finAns.toString();
    }

    public void compute(List<List<Integer>> ans, TreeNode curr, int level) {
        if (ans.size() == level)
            ans.add(new ArrayList<Integer>());

        if (curr == null) {
            ans.get(level).add(null);
            return;
        }
        ans.get(level).add(curr.val);
        compute(ans, curr.left, level + 1);
        compute(ans, curr.right, level + 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len = data.length();
        System.out.println(data);
        String data2 = data.substring(1, data.length() - 1);
        String[] arrOfStr = data2.split(",", 0);
        TreeNode root = new TreeNode(Integer.parseInt(arrOfStr[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        for (int i = 1; i < arrOfStr.length; i++) {
            TreeNode parent = q.poll();
            if (!arrOfStr[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(arrOfStr[i]));
                parent.left = left;
                q.add(left);
            }
            if (!arrOfStr[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(arrOfStr[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
        // Queue<TreeNode> qans = new LinkedList<TreeNode>();
        // for (String a : arrOfStr)
        // {
        // try
        // {
        // int temp = Integer.valueOf(a);
        // }
        // catch(Exception e)
        // {
        // qans.offer(null);
        // continue;
        // }
        // int temp = Integer.valueOf(a);
        // System.out.println(temp);
        // TreeNode temp2 = new TreeNode(temp);
        // }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

/*
 * Test Cases Passed, 1/51 Cases Passed.
 */

// Optimal Solution - Same Idea, just better execution
public class Codec {
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

    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

/*
Runtime: 60 ms, faster than 27.93% of Java online submissions for Serialize and Deserialize Binary Tree.
Memory Usage: 53.7 MB, less than 41.58% of Java online submissions for Serialize and Deserialize Binary Tree.
 */