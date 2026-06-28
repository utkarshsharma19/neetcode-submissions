class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int i = 0;
        int j = heights.length - 1;
        int maxArea = 0;
        while(i < j) {
            int height = Math.min(heights[i], heights[j]);
            int width = j - i;
            int area = height * width;
            maxArea = Math.max(area, maxArea);

            if(heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
