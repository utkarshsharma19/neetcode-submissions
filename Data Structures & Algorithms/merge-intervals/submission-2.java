class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][0];
        }
        if(intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        int [] prev = intervals[0];
        List<int[]> result = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            int [] curr = intervals[i];
            int start = curr[0];
            int currIntervalEnd = curr[1];
            int end = prev[1];

            if(end >= start) {
                prev[1] = Math.max(end, currIntervalEnd);
            } else {
                result.add(prev);
                prev = curr;
            }
        }

        result.add(prev);
        return result.toArray(new int[result.size()] []);
    }

}
// sort by initial by a[0] or first element, start time whatever you think, 
// [[1,10],[2,3],[4,5]] -> Good testcase