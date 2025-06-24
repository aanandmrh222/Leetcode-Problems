class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i : prices) {
            buyPrice = Math.min(i, buyPrice);
            maxProfit = Math.max(maxProfit, i-buyPrice);
        }

        return maxProfit;
    }
}