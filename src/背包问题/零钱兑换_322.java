package 背包问题;

import java.util.Arrays;

/*
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
 * 
 */
public class 零钱兑换_322 {
	
	
	  public int coinChange(int[] coins, int amount) {
	        int[] dp = new int[amount+1];
	        //填充一个不存在的数
	      Arrays.fill(dp, amount + 1); //标记
	        dp[0]=0;
	        //1,2,3,4,5.....11进行dp
	        for(int i=1;i<=amount;i++){
	           for (int j = 0; j < coins.length; j++) {
	            if (coins[j] <= i) {
	                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
	            }
	        }
	        }
	        return dp[amount]>amount?-1:dp[amount];
	    }

}
