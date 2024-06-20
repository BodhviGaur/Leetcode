class Solution {
    /*
    1. We go through the entire m * n matrix once to find out rows/cols that have 
    zero in them and store it in a flag array.
    2. Then in seconds run, we will set all rows and columns to 0 where rowFlag[i]=1
    or colFlag[i]=1
    3. Issue : Space : O(Max(m,n)). To improve on and keep space O(1), 
    we will use the 0th element of matrix as flag.  
     * We will iterate from 1st index to m/n instead of 0th in order to avoid setting
     entire array to 0
    
    */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col0SetToZero = false;
        boolean row0SetToZero = false;
        boolean wasAlreadyZero = false;

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n ; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (j == 0 && i == 0) {
                        wasAlreadyZero = true;
                    }
                    if (j == 0) {
                        col0SetToZero = true;
                    }
                    if (i == 0) {
                        row0SetToZero = true;
                    }
                }
                
            }
        }

        for (int i = 1; i<m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j<n ; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j<n ; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i<m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (wasAlreadyZero == true) {
            for (int i = 1; i<m ; i++) {
                matrix[i][0] = 0;
            }
            for (int j = 1; j<n ; j++) {
                matrix[0][j] = 0;
            }
        } 
        if (col0SetToZero) {
             for (int i = 1; i<m ; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0SetToZero) {
           for (int j = 1; j<n ; j++) {
                matrix[0][j] = 0;
            }
        }


    }
}