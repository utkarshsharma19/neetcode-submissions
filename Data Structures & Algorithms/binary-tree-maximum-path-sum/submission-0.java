class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(dfs(root.left), 0);
        int rightGain = Math.max(dfs(root.right), 0);

        int currentPath = root.val + leftGain + rightGain;
        max = Math.max(max, currentPath);
//pattern is that if the child needs to be computed first then use postorder
        return root.val + Math.max(leftGain, rightGain);
    }
}