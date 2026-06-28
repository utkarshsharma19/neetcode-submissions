class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        
      
        if (dfs(root, subRoot)) {
            return true;
        }
        
       
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;  
        }
        if (root == null || subRoot == null) {
            return false;  
        }
        
     
        return (root.val == subRoot.val) && dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }
}
