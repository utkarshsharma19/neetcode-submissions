class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] car = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }
        Arrays.sort(car, (a,b) -> a[0] - b[0]);
        Stack<Double> stk = new Stack<>();
        for(int i = car.length - 1; i >= 0; i--) {
            double time = (double) (target - car[i][0])/car[i][1];

            if(stk.isEmpty() || time > stk.peek()) {
                stk.push(time);
            }
        }

        return stk.size();
    }
}
