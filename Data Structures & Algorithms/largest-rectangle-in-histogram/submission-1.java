class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int [] leftMost = new int[n];
        int [] rightMost = new int[n];

        for(int i = 0; i < n; i++) {
            leftMost[i] = -1;
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
                if(!stk.isEmpty()) {
                    leftMost[i] = stk.peek();
                }
                stk.push(i);
        }
        stk.clear();
        for(int i = n - 1; i >= 0; i--) {
            rightMost[i] = n;
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
                if(!stk.isEmpty()) {
                    rightMost[i] = stk.peek();
                }
                stk.push(i);
        }
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            leftMost[i] += 1;
            rightMost[i] -= 1;
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
        }
    return maxArea;

    }
}
