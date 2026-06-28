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
    public int goodNodes(TreeNode root) {
                return goodNodesHelper(root, root.val);        
    }

    public int goodNodesHelper(TreeNode root, int maxVal) {
        if( root == null) {
            return 0;
        }

        int res = (root.val >= maxVal) ? 1 : 0;

        maxVal = Math.max(maxVal, root.val);
        res+= goodNodesHelper(root.left, maxVal);
        res+= goodNodesHelper(root.right, maxVal);
        return res;
    } 
}
