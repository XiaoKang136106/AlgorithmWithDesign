package 动态规划_斐波那列;

public class 最长连续公共子序列问题_718 {

	/*
	 * 两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

	示例 1:
	
	输入:
	A: [1,2,3,2,1]
	B: [3,2,1,4,7]
	输出: 3
	解释: 
	长度最长的公共子数组是 [3, 2, 1]。
	 */
	  public int findLength(int[] nums1, int[] nums2) {
	        
	        int n1 = nums1.length, n2 = nums2.length;
	    int[][] dp = new int[n1 + 1][n2 + 1];
	    int res=0;
	    for (int i = 1; i <= n1; i++) {
	        for (int j = 1; j <= n2; j++) {
	            dp[i][j]=nums1[i - 1] == nums2[j - 1]?dp[i - 1][j - 1] + 1:0;
	            res=Math.max(res,dp[i][j]);
	        }
	    }
	    	return res;
	    }
}
