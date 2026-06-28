class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }

        if (low != null && root.val <= low) {
            return false;
        }

        if (high != null && root.val >= high) {
            return false;
        }

        return dfs(root.left, low, root.val) &&
               dfs(root.right, root.val, high);
    }
}