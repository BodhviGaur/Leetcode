class Solution {
    /**
    1. we go right, down, left, up until all elements are done
    2. Everytime we traverse a row/col, we decrement that from the num of row/cols
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, left = 0, right = n - 1, down = m - 1;
        while (ans.size() < m*n) {
            for (int j = left; j<= right; j++) {
                ans.add(matrix[up][j]);
            }
            for (int i = up + 1; i<= down; i++) {
                ans.add(matrix[i][right]);
            }
            if (up != down) {
                for (int j = right-1; j>= left; j--) {
                    ans.add(matrix[down][j]);
                }
            }
            if (left != right) {
                for (int i = down-1; i> up; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return ans;
    }
}