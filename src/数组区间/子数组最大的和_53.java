package 数组区间;

public class 子数组最大的和_53 {
/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

	示例:
	
	输入: [-2,1,-3,4,-1,2,1,-5,4],
	输出: 6
	解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 */
	//令 sum[i] 为以 num[i] 为结尾的子数组最大的和，可以由 sum[i-1] 得到 sum[i] 的值，
	//如果 sum[i-1] 小于 0，那么以 num[i] 为结尾的子数组不能包含前面的内容，因为加上前面的部分，那么和一定会比 num[i] 还小。
	public int maxSubArray(int[] nums) {
		
	    int n = nums.length;
	    int[] sum = new int[n];
	    sum[0] = nums[0];
	    int max = sum[0];//假设第一个数为最大值
	    for(int i = 1; i < n; i++){
	        sum[i] = (sum[i-1] > 0 ? sum[i-1] : 0) + nums[i];
	        max = Math.max(max, sum[i]);
	    }
	    return max;
	}
	
	//空间复杂度可以优化成 O(1) 空间复杂度

	public int maxSubArray2(int[] nums) {
	    int max = nums[0];
	    int oldsum = nums[0];
	    for (int i = 1; i < nums.length; i++) {
	        oldsum = (oldsum > 0 ? oldsum: 0) + nums[i];
	        max = Math.max(max, oldsum);
	    }
	    return max;
	}
}
