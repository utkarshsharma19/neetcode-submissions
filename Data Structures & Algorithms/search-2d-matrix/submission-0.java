class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        while(top<=bottom) {
            int row = top + (bottom - top)/2;
            if(target > matrix[row][cols - 1]) {
                top = row + 1;
            }
             else if(target < matrix[row][0]) {
                bottom = row - 1;
             } else {
                break;
             }
        }

        if(top > bottom) {
            return false;
        }

        int row = top + (bottom - top)/2;

        int left = 0;
        int right = cols - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(target > matrix[row][mid]) {
                left = mid + 1;
            }
            else if(target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
