class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int1, int2) -> {
            if (int1[0] == int2[0]) {
                return Integer.compare(int1[1], int2[1]);
            } 
            return Integer.compare(int1[0], int2[0]);
        });
        if (intervals.length < 2) {
            return true;
        }
        for (int i = 1; i< intervals.length; i++) {
            if (intervals[i-1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
        
    }
}