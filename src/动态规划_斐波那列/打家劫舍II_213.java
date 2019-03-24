package 动态规划_斐波那列;

public class 打家劫舍II_213 {
/*
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	
	给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
	
	示例 1:
	
	输入: [2,3,2]
	输出: 3
	解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
	示例 2:
	
	输入: [1,2,3,1]
	输出: 4
	解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
	     偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 */
	
	//思路:考虑2种情况 1.偷(0,n-2) 2.偷(1,n-1)
//f(x) = max{f(x - 2) + v(x), f(x - 3) + v(x - 1), ... , f(0) + v(2), 0 + v(1), 0 + v(0)}。
	
	public static  int rob(int[] nums) {
	    if (nums == null || nums.length == 0) {
	        return 0;
	    }
	    int n = nums.length;
	    if (n == 1) {
	        return nums[0];
	    }
	    return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
	}

	private   static int rob(int[] nums, int first, int last) {
	   int pre2 = 0, pre1 = 0;
	    for (int i = first; i <= last; i++) {
	        int cur = Math.max(pre1, pre2 + nums[i]);
	        pre2 = pre1;
	        pre1 = cur;
	    }
	    return pre1;
	}
	
	
	/*public int rob(int[] nums) {
		int n = nums.length;
		if(n == 0) {
			return 0;
		}
        if(n == 1) {
			return nums[0]; 
		}
		//sum[i]：考虑偷取[0, i]范围内的房子
		//1.先考虑偷取[0, n - 2]的房子
		int[] sum = new int[n - 1];
		sum[0] = nums[0];//第一家必偷
		//取索引为1的值
		for (int i = 1; i < n - 1; i++) {
			sum[i] = 0;
			//从0开始
			for (int j = 0; j <= i; j++) {
				if(j >= 2) {
					sum[i] = Math.max(sum[i], sum[j - 2] + nums[j]);
				}else {
					sum[i] = Math.max(sum[i], nums[j]);
				}
			}
		}
		int result1 = sum[n - 2];
		//2.再考虑偷取[1, n - 1]的房子
		int[] sum2 = new int[n];
		sum2[1] = nums[1];
		for (int i = 2; i < n; i++) {
			sum2[i] = 0;
			//从1开始
			for (int j = 1; j <= i; j++) {
				if(j >= 3) {
					sum2[i] = Math.max(sum2[i], sum2[j - 2] + nums[j]);
				}else {
					sum2[i] = Math.max(sum2[i], nums[j]);
				}
			}
		}
		int result2 = sum2[n - 1];
		return Math.max(result1, result2);
	}
	
	
	public int rob2(int[] nums) {
		int n = nums.length;
		if(n == 0) {
			return 0;
		}
        if(n == 1) {
			return nums[0]; 
		}
		//sum[i]：考虑偷取[0, i]范围内的房子
		//1.先考虑偷取[0, n - 2]的房子
		int[] sum = new int[n - 1];
		sum[0] = nums[0];
		for (int i = 1; i < n - 1; i++) {
			sum[i] = 0; //令sum[1]=0
			for (int j = 0; j <= i; j++) {
				if(j >= 2) {
					sum[i] = Math.max(sum[i], sum[j - 2] + nums[j]);
				}else {
					sum[i] = Math.max(sum[i], nums[j]);
				}
			}
		}
		int result1 = sum[n - 2];
		//2.再考虑偷取[1, n - 1]的房子
		int[] sum2 = new int[n];
		sum2[1] = nums[1];
		for (int i = 2; i < n; i++) {
			sum2[i] = 0;
			for (int j = 1; j <= i; j++) {
				if(j >= 3) {
					sum2[i] = Math.max(sum2[i], sum2[j - 2] + nums[j]);
				}else {
					sum2[i] = Math.max(sum2[i], nums[j]);
				}
			}
		}
		int result2 = sum2[n - 1];
		return Math.max(result1, result2);
	}*/
	public static void main(String[] args) {
		int rob = rob(new int[] {2,3,2});
		System.out.println(rob);
	}
}
