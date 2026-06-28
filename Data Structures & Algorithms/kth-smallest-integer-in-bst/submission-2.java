
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        dfs(root, maxHeap, k);
        return maxHeap.peek();
    }

    private void dfs(TreeNode root, PriorityQueue<Integer> maxHeap, int k) {
        if (root == null) {
            return;
        }

        maxHeap.offer(root.val);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }

        dfs(root.left, maxHeap, k);
        dfs(root.right, maxHeap, k);
    }
}