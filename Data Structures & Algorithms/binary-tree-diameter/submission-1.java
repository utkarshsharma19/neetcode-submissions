class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        dfs(root, maxDiameter);
        return maxDiameter[0];
    }

    private int dfs(TreeNode node, int[] maxDiameter) {
        if (node == null) return 0;

        int leftDepth = dfs(node.left, maxDiameter);
        int rightDepth = dfs(node.right, maxDiameter);

        maxDiameter[0] = Math.max(maxDiameter[0], leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}