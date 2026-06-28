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
    int index = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        return buildTreeHelper(0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTreeHelper(int l, int r, int[] preorder, int [] inorder) {
        if(l > r) {
            return null;
        }
        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int indices = map.get(rootVal);
        root.left = buildTreeHelper(l, indices -1, preorder, inorder);
        root.right = buildTreeHelper(indices + 1, r, preorder, inorder);
        return root;
    }
}


// basically the in inorder the first element of preorder is always the root. We fetch the index of the root in inorder
// everrything to the left of the index will be the left subtree and right would be right subtree 

