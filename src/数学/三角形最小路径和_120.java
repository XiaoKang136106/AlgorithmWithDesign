package 数学;

import java.util.List;

public class 三角形最小路径和_120 {
	
	//思路:自底向上
	 public int minimumTotal(List<List<Integer>> triangle) {
		 if(triangle==null && triangle.size()==0) {
			 return 0;
		 }
		 int size = triangle.size();
		 int[][] dp = new int[size][size];
		 //初始化最后一行
	        for(int i=0;i<size;i++) {
	        	dp[size-1][i]=triangle.get(size-1).get(i);
	        }
	        //开始往上遍历
	        for (int i = size-2; i >= 0; i--) {
	        	
	        	for (int j = 0; j <=i; j++) {
	        		dp[i][j]=Math.min(dp[i+1][j], dp[i+1][j+1])+triangle.get(i).get(j);
				}
			}
		 return dp[0][0];
	}

}
