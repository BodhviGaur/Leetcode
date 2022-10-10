class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min=0;
        int max=0;
        int i=0;
        while(i<prices.length-1){
            min=i;
            while(i<prices.length-1 && prices[i]>prices[i+1]){
                //while price keeps going down, keep moving ahead to find min
                i++;
                min=i;
            }
            while(i<prices.length-1 && prices[i]<=prices[i+1]){
                //when price of next is greater than prev value, 
                //keep moving ahead till value is growing
                i++;
                max=i;
            }
            if(max>min){
                maxProfit= maxProfit + prices[max] - prices[min];
                i++;
            }
        }
        return maxProfit;
        
    }
}