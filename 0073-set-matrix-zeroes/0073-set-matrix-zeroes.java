class Solution {
    /*
    1. We go through the entire m * n matrix once to find out rows/cols that have 
    zero in them and store it in a flag array.
    2. Then in seconds run, we will set all rows and columns to 0 where rowFlag[i]=1
    or colFlag[i]=1
    3. Issue : Space : O(Max(m,n)). To improve on 
    
    */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rowFlag[] = new int[m];
        int colFlag[] = new int[n];

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n ; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = 1;
                    colFlag[j] = 1;
                }
            }
        }

        for (int i = 0; i<m; i++) {
            if (rowFlag[i] == 1) {
                for (int j = 0; j<n ; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j<n ; j++) {
            if (colFlag[j] == 1) {
                for (int i = 0; i<m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}