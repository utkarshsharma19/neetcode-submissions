
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        Stack<Integer> stk = new Stack<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stk.isEmpty() && height[i] > height[stk.peek()]) {
                int mid = stk.pop();

                if (stk.isEmpty()) {
                    break;
                }

                int left = stk.peek();
                int right = i;

                int h = Math.min(height[left], height[right]) - height[mid];
                int w = right - left - 1;

                res += h * w;
            }

            stk.push(i);
        }

        return res;
    }
}