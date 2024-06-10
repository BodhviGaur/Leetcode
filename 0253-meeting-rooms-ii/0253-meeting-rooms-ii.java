class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int confRoom = 0, maxRoom = 1;
        if (intervals.length == 0) {
            return 0;
        } else if (intervals.length == 1) {
            return 1;
        }
        Arrays.sort(intervals, (int1, int2) -> {
            if (int1[0] == int2[0]) {
                return Integer.compare(int1[1], int2[1]);
            } 
            return Integer.compare(int1[0], int2[0]);
        });

        //We need to find the maximum number of overlapping meetings at any given
        // point in time and that is your ans;
        //keep 2 pointers one for startTimes and one for endTimes,
        
        int[] sortedEnds = new int[intervals.length];
        for (int i=0; i<intervals.length; i++) {
            sortedEnds[i] = intervals[i][1];
        }
        Arrays.sort(sortedEnds);

        int ptr1=0, ptr2=0;
        while (ptr1 < intervals.length && ptr2 < intervals.length) {
            if (Math.abs(intervals[ptr1][0]) < Math.abs(sortedEnds[ptr2])) {
                confRoom++;
                ptr1++;
                maxRoom = Math.max(maxRoom, confRoom);
            } else if (Math.abs(intervals[ptr1][0]) >= Math.abs(sortedEnds[ptr2])) {
                confRoom--;
                ptr2++;
            }
        }
        return maxRoom;

    }
}