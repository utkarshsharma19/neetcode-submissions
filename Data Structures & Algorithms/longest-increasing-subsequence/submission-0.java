class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {
            int idx = lowerBound(lis, num);
            if (idx < 0) idx = -(idx + 1);   // insertion point (lower_bound)
            if (idx == lis.size()) lis.add(num);
            else lis.set(idx, num);
        }
        return lis.size();
    }
    

   public int lowerBound(List<Integer> arr, int target) {
    int left = 0, right = arr.size();
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr.get(mid) < target) {
            left = mid + 1;
        } else {
            right = mid; 
        }
    }
    return left; 
}
}
