class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int currEnd, currStart, count = 0, i=1;
        if (intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, (interval1, interval2) -> 
             Integer.compare(interval1[0], interval2[0])
            );
        currEnd = intervals[0][1];

        while (i < intervals.length) {
            if (currEnd > intervals[i][0]) {
                count++;
                //Now we need to remove interval with larger end time
                //example : [2,6],[3,4] -> here we should remove 2,6 and not 3,4
                //since chances of more overlap with 2,6 than with 3,4 since 4 
                //<6 and we are sorted by start times.
                currEnd = Math.min(currEnd, intervals[i][1]);
            } else {
                currEnd = intervals[i][1];
            }
            i++;
        }
        return count;
    }
}