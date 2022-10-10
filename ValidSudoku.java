class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!set.add("row"+i+"has:"+String.valueOf(board[i][j]))||!set.add("column"+j+"has:"+String.valueOf(board[i][j]))||!set.add("box"+i/3+"-"+j/3+"has:"+String.valueOf(board[i][j])))
                    {
                        System.out.println("returning False");
                        return false;
                    }
                 }  
            }
        }
        return true;
    }
}