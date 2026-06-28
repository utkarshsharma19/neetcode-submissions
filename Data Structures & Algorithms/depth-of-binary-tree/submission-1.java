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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return maxDepth(root, 0);
    }
    private int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth; // When we hit a null node, return the current depth
        }

        // Recursively calculate the depth for both left and right subtrees
        int leftDepth = maxDepth(root.left, depth + 1);  // Increment depth for the left child
        int rightDepth = maxDepth(root.right, depth + 1); // Increment depth for the right child
        
        // Return the maximum of both subtrees' depths
        return Math.max(leftDepth, rightDepth);
    }

 
}
