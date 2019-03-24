package 动态规划_斐波那列;

public class 最小路径和_64 {
/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

	说明：每次只能向下或者向右移动一步。
	
	示例:
	
	输入:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	输出: 7
	解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 */
	
	 public int minPathSum2(int[][] grid) {
	        int a=grid.length;
	        int b=grid[0].length;
	        int [][]dp=new int[a][b];
	        for(int i=0;i<a;i++){
	            for(int j=0;j<b;j++){
	                if(i==0&&j==0){
	                    dp[i][j]=grid[i][j];
	                }else if(i==0){
	                    dp[i][j]=grid[i][j]+dp[i][j-1];
	                }else if(j==0){
	                    dp[i][j]=grid[i][j]+dp[i-1][j];
	                }else{
	                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
	                }
	            }
	        }
	        return dp[a-1][b-1];
	    }
	 public int minPathSum(int[][] grid) {
		 if(grid.length == 0 || grid[0].length == 0) return 0;
		    int m = grid.length, n = grid[0].length;
		    int[] dp = new int[n];//
		    for(int i = 0; i < m; i++) {
		        for(int j = 0; j < n; j++) {
		        	//只有一列
		            if(j == 0) dp[0] = dp[0] + grid[i][0];
		            //只有一行
		            else if(i == 0) dp[j] = dp[j - 1] + grid[0][j];
		            else dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
		        }
		    }
		    return dp[n - 1];   
	    }

	 

}
