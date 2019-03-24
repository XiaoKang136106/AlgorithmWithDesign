package 数学;

import java.util.Arrays;

public class 三个数的最大乘积_628 {
/**
 * 
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

	示例 1:
	
	输入: [1,2,3]
	输出: 6
	示例 2:
	
	输入: [1,2,3,4]
	输出: 24
 * 数组中所有的元素范围是[-1000, 1000]。
 */
	//思路:先排序,需要考虑负数的情况,如果负数的绝对值为最大时,只需要前2个数*最后一个数 和 最后面的3个数进行比较(负负得正)
    public int maximumProduct(int[] nums) {
        int a=0;
        int b=0;
        Arrays.sort(nums);
        a=(nums[0]*nums[1]*nums[nums.length-1]); //这里考虑的是负数的情况
        b=(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);//都为负数或者都为正数的话,最后3个一定为最大值
        return a>b?a:b;
    }
}
