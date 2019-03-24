package 数组区间;

public class 数组区间和_303 {
/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

示例：

给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */
	
	int[] nums;

    public 数组区间和_303(int[] nums) {
    	//从1开始,nums[i]等于前n项之和
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
    	//等于0就是等于nums[j] -> sumRange(0, 2) == nums[2]   非0    nums[j] 前3项和 - 前1项和 nums[i - 1] ->sumRange(2,3)  
        return i == 0 ? nums[j] : nums[j] - nums[i - 1];
    }
}
