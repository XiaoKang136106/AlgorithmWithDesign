package 动态规划_斐波那列;

import java.util.ArrayList;

public class 不同路径2_63 {
/**
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
 */
	
	   public int uniquePathsWithObstacles(int[][] arr) {
	        int m = arr.length,n = arr[0].length;
	        int[][] dp = new int[m][n];
	        //遇到第一条为1,后面的路都走不通了,都为0
	        for(int i=0;i<m&&arr[i][0]!=1;i++) dp[i][0] = 1;
	        for(int i=0;i<n&&arr[0][i]!=1;i++) dp[0][i] = 1;
	        for(int i=1;i<m;i++){
	            for(int j=1;j<n;j++){
	            	//遇到障碍为0
	                dp[i][j] = arr[i][j]!=1?dp[i-1][j]+dp[i][j-1]:0;
	            }
	        }
	        return dp[m-1][n-1];
	    }
}
