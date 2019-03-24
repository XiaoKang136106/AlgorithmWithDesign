package 动态规划_斐波那列;

public class 最长公共子系列 {
	//对于两个子序列 nums1 和 nums2，找出它们最长的公共子序列。
	public static int lengthOfLCS(int[] nums1, int[] nums2) {
	    int n1 = nums1.length, n2 = nums2.length;
	    int[][] dp = new int[n1 + 1][n2 + 1];
	    for (int i = 1; i <= n1; i++) {
	        for (int j = 1; j <= n2; j++) {
	            if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
	            else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	        }
	    }
	    for (int[] is : dp) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	    /*
	     *  0 0 0 0 0 0 
			0 0 1 1 1 1 
			0 1 1 2 2 2 
			0 1 1 2 2 3 
			0 1 1 2 2 3 
			0 1 1 2 2 3 

	     */
	    return dp[n1][n2];
	}
	public static void main(String[] args) {
		lengthOfLCS(new int[] {0,1,1,1,1},new int[] {1,0,1,0,1});
		
	}
}
