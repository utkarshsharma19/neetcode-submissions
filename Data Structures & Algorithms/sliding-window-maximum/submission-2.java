class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        int [] output = new int[n - k + 1];
        while(right < n) {
            while(!q.isEmpty() && nums[q.getLast()] < nums[right]) {
                q.removeLast();
            }
            if( !q.isEmpty() && left > q.getFirst()) {
                q.removeFirst();
            }
            q.addLast(right);
            if (right - left + 1 == k) {
                output[left] = nums[q.getFirst()];
                left++;
            }
            right++;
        }
        return output;
    }
}
