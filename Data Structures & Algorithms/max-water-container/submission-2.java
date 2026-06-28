class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length  - 1;
        int area = 0;
        int maxArea = Integer.MIN_VALUE;
        while(i < j) {
            int width = j - i;
            int height = Math.min(heights[i],heights[j]);

            area = width * height;

            maxArea = Math.max(maxArea, area);
            if(heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
