package 贪心算法;

public class 股票的最大收益_122 {
	
	public int maxProfit(int[] prices) {
	    int profit = 0;
	    for(int i = 1; i < prices.length; i++){
	        if(prices[i] > prices[i-1]) profit += (prices[i] - prices[i-1]);
	    }
	    return profit;
	}

}
