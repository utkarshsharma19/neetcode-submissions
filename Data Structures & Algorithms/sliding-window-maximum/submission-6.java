class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int n = nums.length;
        int [] output = new int [n - k + 1];

        int right = 0;
        int left = 0;
        for(int i = 0; i < n; i++) {
            while(!dq.isEmpty()  && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            if(!dq.isEmpty() && i - k >= dq.getFirst()) {
                dq.removeFirst();
            }
            dq.add(i);
            if(i - left + 1 == k) {
                output[left] = nums[dq.getFirst()];
                left++;
            }
        }
        return output;
    }
}
