package leetcode;

import java.util.Arrays;

public class 最小完全平方数_279 {
	
	public static int minNum(int n) {
		int[] dp = new int[n+1];
		for (int i = 0; i <= n; i++) {
			 dp[i]=i;
		}
		for(int i=2;i<=n;i++) {
			
			for(int j=1;j*j<=i;j++) {
				dp[i]=Math.min(dp[i], dp[i-j*j]+1);
			}
			
		}
		return dp[n];
	}

}
