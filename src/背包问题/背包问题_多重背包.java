package 背包问题;

public class 背包问题_多重背包 {
/**
	完全背包问题是指每种物品都有无限
 * */
	
	 public static int manyPack(int V,int N,int[] weight,int[] value,int[] num){
	        //初始化动态规划数组
	        int[][] dp = new int[N+1][V+1];
	        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
	        for(int i=1;i<N+1;i++){
	            for(int j=1;j<V+1;j++){
	                //如果第i件物品的重量大于背包容量j,则不装入背包
	                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
	                if(weight[i-1] > j)
	                    dp[i][j] = dp[i-1][j];
	                else{
	                    //考虑物品的件数限制,取最小值
	                    int maxV = Math.min(num[i-1],j/weight[i-1]);
	                    
	                    for(int k=0;k<=maxV;k++){
	                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
	                    }
	                }
	            }
	        }
	        return dp[N][V];
	 }
}
	
