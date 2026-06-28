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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q  = new LinkedList<>();
        q.offer(root);
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            while(size-- > 0) {
                TreeNode node = q.poll();
                if(node!=null) {
                    list.add(node.val);
                    if(node.left!=null) {
                        q.offer(node.left);
                    }
                    if(node.right!=null) {
                        q.offer(node.right);
                    }
                }
                
            }
            if(list.size() > 0) {
                    levelOrder.add(list);
                }
        }

        for(List<Integer> list: levelOrder) {
            result.add(list.get(list.size() - 1));
        }
        return result;

    }
}
