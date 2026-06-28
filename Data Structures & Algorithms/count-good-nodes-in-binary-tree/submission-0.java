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
        if(root == null) {
            return 0;
        }
        return postOrder(root, root.val);
    }


    private int postOrder(TreeNode root, int maxSoFar) {
        if(root == null) {
            return 0;
        }

        int answer = 0;

        
        if(root.val >= maxSoFar) {
            answer = 1;
        }

        maxSoFar = Math.max(maxSoFar, root.val);

        answer += postOrder(root.left, maxSoFar);
        answer += postOrder(root.right, maxSoFar);

        return answer;

        
    }
}
