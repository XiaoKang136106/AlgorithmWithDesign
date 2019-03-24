package leetcode;

public class 数组中等差递增子区间的个数_413 {
	
	public static int count(int[] nums) {
		int m = nums.length;
		if(m<2) return 0;
		int[] dp = new int[m];
		
		for (int i = 2; i < m; i++) {
			if(nums[i]-nums[i-1] ==nums[i-1]-nums[i-2]) {
				dp[i]= dp[i-1]+1;
			}
		}
		int cnt=0;
		for (int i : dp) {
			cnt += i;
		}
		return cnt;
	}

}
