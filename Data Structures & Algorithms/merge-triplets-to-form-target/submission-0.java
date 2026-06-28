class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int [] result = new int [triplets[0].length];
        Arrays.fill(result, -1);
        for(int i = 0 ;i < triplets.length; i++) {
            if (triplets[i][0] <= target[0] &&
                triplets[i][1] <= target[1] &&
                triplets[i][2] <= target[2]) {
    
    for (int j = 0; j < 3; j++) {
        result[j] = Math.max(result[j], triplets[i][j]);
    }
}
        }
        int count =0;
        for(int i = 0; i < target.length;i++) {
            if(result[i] == target[i]) {
                count++;
            }
        }

        if(count == target.length) {
            return true;
        }

        return false;
    }
}
