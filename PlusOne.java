class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i=len-1;
        if(digits[i]!=9){
            digits[i]=digits[i]+1;
        }
        else{
            while(i>=0 && digits[i]==9){
                i--;
            }
            if(i==-1){
                //case of all digits 9
                int[] newArray = new int[len+1];
                Arrays.fill(newArray, 0);
                newArray[0]=1;
                return newArray;
            }
            else{
                digits[i]=digits[i]+1;
                for(i=i+1;i<len;i++){
                    digits[i]=0;
                }
            }
        }
        return digits;
    }
}

