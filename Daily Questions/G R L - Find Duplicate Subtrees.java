//Attempt #1 - 28mins
//Link: https://leetcode.com/problems/find-duplicate-subtrees/description/

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        preOrder(root, new HashMap<>(), res);
        return res;
    }

    public String preOrder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";  
        String serial = cur.val + ",";
        serial += preOrder(cur.left, map, res) + ",";
        serial += preOrder(cur.right, map, res);
        //System.out.println(serial);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) res.add(cur);
        return serial;
    }
    //https://leetcode.com/problems/find-duplicate-subtrees/solutions/3238264/java-easy-hashmap-with-explanation/
}

/*
Runtime
21 ms
Beats
49.71%
Memory
50.2 MB
Beats
45.9%
 */