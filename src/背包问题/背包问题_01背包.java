package 背包问题;

public class 背包问题_01背包 {
/**
 * 0-1背包问题
 * 0-1背包问题是指每一种物品都只有一件，可以选择放或者不放。现在假设有n件物品，背包承重为m。

	对于这种问题，我们可以采用一个二维数组去解决：f[i][j]，其中i代表加入背包的是前i件物品，j表示背包的承重，
	f[i][j]表示当前状态下能放进背包里面的物品的最大总价值。那么，f[n][m]就是我们的最终结果了。
	
	采用动态规划，必须要知道初始状态和状态转移方程。初始状态很容易就能知道，那么状态转移方程如何求呢？对于一件物品，我们有放进或者不放进背包两种选择：
	
	  （1）假如我们放进背包，f[i][j] = f[i - 1][j - weight[i]] + value[i]，这里的f[i - 1][j - weight[i]] + value[i]应该这么理解：在没放这件物品之前的状态值加上要放进去这件物品的价值。而对于f[i - 1][j - weight[i]]这部分，i - 1很容易理解，关键是 j - weight[i]这里，我们要明白：要把这件物品放进背包，就得在背包里面预留这一部分空间。
	
	  （2）假如我们不放进背包，f[i][j] = f[i - 1][j]，这个很容易理解。
	
	    因此，我们的状态转移方程就是：f[i][j] = max(f[i][j] = f[i - 1][j] , f[i - 1][j - weight[i]] + value[i])  
	
	    当然，还有一种特殊的情况，就是背包放不下当前这一件物品，这种情况下f[i][j] = f[i - 1][j]。
 */
	
	//N为容量,W为重量,weights[]重量数组values[]价值数组一一对应
	public int knapsack(int W, int N, int[] weights, int[] values) {
	    //创建一个二维数组,N为前N件物品,W为前N件的重量,dp[N][M]为最大总价值
			int[][] dp=new int[N+1][W+1];
			for(int i=1;i<=N;i++) {
				int w=weights[i-1];//重量
				int v =values[i-1]; //价值
				for (int j = 1; j <=W; j++) {
					//背包剩余的重量大于当前物品的重量
					if(j>=w) {
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w]+v);
					}else {
						dp[i][j]=dp[i-1][j];
					}
				}
			}
	
			
			return dp[N][W];
	}
	/*
	 * 有一个容量为 N 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 w 和价值 v。

定义一个二维数组 dp 存储最大价值，其中 dp[i][j] 表示前 i 件物品体积不超过 j 的情况下能达到的最大价值。设第 i 件物品体积为 w，价值为 v，根据第 i 件物品是否添加到背包中，可以分两种情况讨论：

第 i 件物品没添加到背包，总体积不超过 j 的前 i 件物品的最大价值就是总体积不超过 j 的前 i-1 件物品的最大价值，dp[i][j] = dp[i-1][j]。
第 i 件物品添加到背包中，dp[i][j] = dp[i-1][j-w] + v。
第 i 件物品可添加也可以不添加，取决于哪种情况下最大价值更大。因此，0-1 背包的状态转移方程为：


	 */
	public int knapsack2(int W, int N, int[] weights, int[] values) {
		
	    int[][] dp = new int[N + 1][W + 1];
	    //从第一件开始
	    for (int i = 1; i <= N; i++) {
	        int w = weights[i - 1], v = values[i - 1];
	        for (int j = 1; j <= W; j++) {
	            if (j >= w) {
	                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
	            } else {
	                dp[i][j] = dp[i - 1][j];
	            }
	        }
	    }
	    return dp[N][W];
	}
}
