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
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    public int kthSmallest(TreeNode root, int k) {
        preorder(root);
        for(int i = 0; i < k - 1; i++) {
            heap.poll();
        }

        return heap.poll();
        
    }

    private void preorder(TreeNode root) {
        if(root == null) {
            return;
        }

        heap.add(root.val);
        preorder(root.left);
        preorder(root.right);
        

    }
}
