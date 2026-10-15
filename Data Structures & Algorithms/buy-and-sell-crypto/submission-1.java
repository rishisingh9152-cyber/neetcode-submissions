class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = Integer.MAX_VALUE; // Start with the highest possible integer
        int maxProfit = 0;                 // Minimum possible profit is 0
        
        for (int i = 0; i < prices.length; i++) {
            // 1. Update minPrice if we find a cheaper day to buy
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // 2. Otherwise, check if selling today gives us a new record profit
            else {
                int currentProfit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        
        return maxProfit;
    }
}