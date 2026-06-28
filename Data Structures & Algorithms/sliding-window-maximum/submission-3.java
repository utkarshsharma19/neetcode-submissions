class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int [] output = new int[n - k + 1];
        int left = 0;
        int right = 0;
        for(int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[right]) {
                dq.removeLast();
            }
            if(!dq.isEmpty() && left > dq.getFirst()) {
                dq.removeFirst();
            }
            dq.addLast(i);
            if(right - left +  1 == k) {
                output[left] = nums[dq.getFirst()];
                left++;
            }
            right++;
        }
        return output;
    }
}
