/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int [] start = new int [intervals.size()];
        int [] end = new int [intervals.size()];

        for(int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int result = 0;
        int Daycount = 0;
        int j = 0;
        int k = 0;

        while(j < intervals.size()) {
            if(start[j] < end[k]) {
                j++;
                Daycount++;
            } else {
                k++;
                Daycount--;
            }

            result = Math.max(result, Daycount);
        }

        return result;

    }
}
