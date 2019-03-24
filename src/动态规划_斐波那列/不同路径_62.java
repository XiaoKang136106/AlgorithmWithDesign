package 动态规划_斐波那列;

import java.util.Arrays;

public class 不同路径_62 {
	
	
/*	采用动态规划。动态规划要求利用到上一次的结果，是一种特殊的迭代思想，动态规划的关键是要得到递推关系式。
 * 	对于本题，到达某一点的路径数等于到达它上一点的路径数与它左边的路径数之和。
 * 	也即，起点到点(i, j)的路径总数：ways[i][j] = 起点到点(i, j-1)的总数：ways[i][j-1] 
 * 										+ 起点到点(i-1, j)总数：ways[i-1][j]。
 * 于是我们就得到递推关系式：ways[i][j] = ways[i][j-1] + ways[i-1][j]
 
 * 
 * //统计从矩阵左上角到右下角的路径总数，每次只能向右和向下移动。
 * 输入: m = 3, n = 2
	输出: 3
	解释:
	从左上角开始，总共有 3 条路径可以到达右下角。
	1. 向右 -> 向右 -> 向下
	2. 向右 -> 向下 -> 向右
	3. 向下 -> 向右 -> 向右
 * 
 */
	public int uniquePaths(int m, int n) {
	  
		int[] dp = new int[n];//从0开始
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	        	//只能向右走
	        	if(i == 0) dp[j] = 1;
	           //dp[j]表示上一行方向的路径数,dp[j-1]表示的是左边的路径数
	        	else if(j != 0) dp[j] = dp[j] + dp[j - 1];
	        	 System.out.println(dp[j]);
	        }
	    }
	    return dp[n - 1];
	}
	//推荐
    public int uniquePaths2(int m, int n) {
        
        int[][] dp=new int[n][m];
      
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 ||j==0) {
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
               
            }
           
        }
         return dp[n-1][m-1];
    }
	public static void main(String[] args) {
		不同路径_62 不同路径_62 = new 不同路径_62();
		不同路径_62.uniquePaths(3, 2);
	}
}
