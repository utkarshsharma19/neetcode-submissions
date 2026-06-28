
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        HashMap<TreeNode, Integer> depthMap = new HashMap<>();
        int[] maxDiameter = new int[1]; // array used to hold max across recursive calls
        
        dfs(root, depthMap, maxDiameter);
        return maxDiameter[0];
    }

    private int dfs(TreeNode node, HashMap<TreeNode, Integer> depthMap, int[] maxDiameter) {
        if (node == null) return 0;

        int leftDepth = dfs(node.left, depthMap, maxDiameter);
        int rightDepth = dfs(node.right, depthMap, maxDiameter);

        // Store current node's depth
        int currentDepth = Math.max(leftDepth, rightDepth) + 1;
        depthMap.put(node, currentDepth);

        // Update the diameter
        maxDiameter[0] = Math.max(maxDiameter[0], leftDepth + rightDepth);

        return currentDepth;
    }
}
