/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, Integer> map;
    int res = 0;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if(map.containsKey(root)) {
            return map.get(root);
        }

        if(root == null) {
            return 0;
        }

         int take = root.val;
        if(root.left!=null) {
            take += dfs(root.left.left) + dfs(root.left.right);
        }

         if(root.right!=null) {
            take += dfs(root.right.left) + dfs(root.right.right);
        }

        int skip = dfs(root.left) + dfs(root.right);
        res = Math.max(skip,take);
        map.put(root, res);
        return res;
    }
}