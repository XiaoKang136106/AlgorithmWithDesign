package 斐波那契数列;

import java.util.Arrays;

public class 最长递增子序列_300 {
/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

	示例:
	
	输入: [10,9,2,5,3,7,101,18]
	输出: 4 
	解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4
	后面的数比前面的数要大,求最长的长度
 * 
 */

    //【关键】将 dp 数组定义为：以 nums[i] 结尾的最长上升子序列的长度
    // 那么题目要求的，就是这个 dp 数组中的最大者
    // 以数组  [10, 9, 2, 5, 3, 7, 101, 18] 为例：
    // dp 的值： 1  1  1  2  2  3  4    4
    // 注意实现细节。
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 状态的定义是：以 i 结尾的最长上升子序列的长度
        // 状态转移方程：之前比最后那个数字小的最长上升子序列的长度 + 1
        int[] dp = new int[len];
        Arrays.fill(dp, 1); // 如果只有 1 个元素，那么这个元素自己就构成了最长上升子序列，所以设置为 1 是合理的
        for (int i = 1; i < len; i++) { // 从第 2 个元素开始，逐个写出 dp 数组的元素的值
            int curVal = nums[i];
            for (int j = 0; j < i; j++) { // 找出比当前元素小的哪些元素的最小值
                if (curVal > nums[j]) {
                    dp[i] = Integer.max(dp[j] + 1, dp[i]);//获取dp[j]+1和dp[i]上哪个值更大
                }
            }
        }
        // 最后要全部走一遍，看最大值
        int res = dp[0];
        for (int i = 0; i < len; i++) {
            res = Integer.max(res, dp[i]);
        }
        return res;
    }
    
    public int lengthOfLIS2(int[] nums) {
    	//获取nums的长度
    	int n = nums.length;
		
    	//定义DP
    	int[] dp = new int[n];
    	//从1开始遍历
    	for (int i = 0; i < n; i++) {
			//假设dp[i]每次都为1
    		int max =1;
    		for (int j = 0; j < i; j++) {//和i前面的数值进行比较
    			//如果后面的大于前面的
    			if(nums[i]>nums[j]) max = Math.max(dp[j]+1, max);//比较dp[j]+1和max上哪个值更大
			}
    		dp[i] =max;//将max赋给dp[i];
		}
    	int ret =0;//返回值,因为n可能为0
    	//遍历dp
    	for (int i = 0; i < n; i++) {
    		//找出dp[i]上最大的值
			ret=Math.max(dp[i], ret);
		}
    	return ret;
    }
	
}
