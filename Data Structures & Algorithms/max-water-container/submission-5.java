class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0;
        int n = heights.length;
        int j = n - 1;
        
        while(i <= j) {
            int height = Math.min(heights[i], heights[j]);
            int  area = height * (j - i);
            maxArea = Math.max(area, maxArea);
            if(heights[i] <= heights[j]) {
                i++;
            } else {
               j--;
            }
        }

        return maxArea;
    }
}
