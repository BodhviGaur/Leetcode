class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        int n = heights.length;
        for (int i = 1; i <= volume; i++) {
            int curr = k;
            int dropPos = k;
            boolean posChanged = false;
            int[] directions = new int[]{-1,1}; // note : move left first then right, 
            //same solution would fail in 13 use cases if directions = new int[]{1,-1}
            // because it moves right first then left
            for (int dir : directions) { // -1 means left, +1 means right
                while ((curr + dir >= 0) && (curr + dir < n) && (heights[curr + dir] <= heights[curr])) {
                    if (heights[curr + dir] < heights[curr]) {
                        dropPos = curr + dir;
                    }
                    curr = curr + dir;
                }
                if (dropPos != k) {
                    heights[dropPos]++;
                    posChanged = true;
                    break;
                }
            }

            if (!posChanged) {
                heights[dropPos]++;
            }
           
        }
        return heights;
    }
}