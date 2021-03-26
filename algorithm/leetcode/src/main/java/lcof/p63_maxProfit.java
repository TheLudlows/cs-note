package lcof;

public class p63_maxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max_profit = 0;

        for (int p : prices) {
            min = Math.min(min,p);
            max_profit = Math.max(p-min,max_profit);
        }
        return max_profit;
    }
}
