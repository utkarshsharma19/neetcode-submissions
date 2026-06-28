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
     private HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build the hashmap to store value -> index for inorder
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        // Start the recursion with the full range of preorder and inorder
        return inorderConversion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode inorderConversion(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;  // Base case: empty subtree
        }

        // The first element in preorder is the root
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Find the root index in the inorder array
        int rootIndex = map.get(rootValue);

        // The size of the left subtree is the distance between the root index and the start of the inorder segment
        int leftSubTreeSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = inorderConversion(preorder, preStart + 1, preStart + leftSubTreeSize, inorder, inStart, rootIndex - 1);
        root.right = inorderConversion(preorder, preStart + leftSubTreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
