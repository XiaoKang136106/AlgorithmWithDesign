package 斐波那契数列;

public class 打家劫舍_198 {
/**
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

	给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
	
	示例 1:
	
	输入: [1,2,3,1]
	输出: 4
	解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
	     偷窃到的最高金额 = 1 + 3 = 4 。
	示例 2:
	
	输入: [2,7,9,3,1]
	输出: 12
	解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
	     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 
 * 
 */
	//思路:定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
	//由于不能抢劫邻近住户，因此如果抢劫了第 i 个住户那么只能抢劫 i - 2 和 i - 3 的住户

	public int rob(int[] nums) {
		int n=nums.length;
		if(n==0)  return 0;
		if(n==1) return nums[0];
		if(n==2) return Math.max(nums[0], nums[1]);
		 int[] dp = new int[n];
		    dp[0] = nums[0];
		    dp[1] = nums[1];
		    //不能偷nums[1]
		    dp[2] = nums[0] + nums[2];
		for (int i = 3; i < n; i++) {
			//不能偷dp[i-1]所以需要比较dp[i-2]和dp[i-3]的值
			dp[i]= Math.max(dp[i-2], dp[i-3])+nums[i];
		
		}
		return Math.max(dp[n-1], dp[n-2]);
	}
	public int rob2(int[] nums) {
		int n=nums.length;
		if(n==0)  return 0;
		if(n==1) return nums[0];
		if(n==2) return Math.max(nums[0], nums[1]);
		    int pre1 = nums[0];
		    int pre2 = nums[1];
		    int pre3 = nums[0] + nums[2];
		for (int i = 3; i < n; i++) {
			int cur =  Math.max(pre1, pre2)+nums[i];
			pre1=pre2;
			pre2=pre3;
			pre3 = cur;
		}
		return Math.max(pre3, pre2);
	}
}
