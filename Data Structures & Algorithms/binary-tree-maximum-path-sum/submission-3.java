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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode root) {
        if( root == null ) {
            return 0;
        }
        
        int leftGain = Math.max(0, maxPathSumHelper(root.left));
        int rightGain = Math.max(0, maxPathSumHelper(root.right));

        int currentPath = leftGain + root.val + rightGain;
        maxSum = Math.max(maxSum, currentPath);

        return root.val + Math.max(leftGain, rightGain);
        
    }
}
