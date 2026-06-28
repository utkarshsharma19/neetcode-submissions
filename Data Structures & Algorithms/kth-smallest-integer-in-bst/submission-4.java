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
    int count = 0;
    int ans = 0;
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        System.out.println(list);
        return ans;
    }

    private void kthSmallestHelper(TreeNode root, int k) {
        //inorder
        if(root == null) {
            return;
        }
        kthSmallestHelper(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        kthSmallestHelper(root.right, k);
    }
}
