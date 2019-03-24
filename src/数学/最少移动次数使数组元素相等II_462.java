package 数学;

import java.util.Arrays;

public class 最少移动次数使数组元素相等II_462 {
/**
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，
 * 其中每次移动可将选定的一个元素加1或减1。
 *  您可以假设数组的长度最多为10000。
	例如:
	输入:
	[1,2,3]
	输出:
	2
	说明：
	只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）： 
	[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
	/**
	 * 设 m 为中位数。a 和 b 是 m 两边的两个元素，且 b > a。
	 * 要使 a 和 b 相等，它们总共移动的次数为 b - a，这个值等于 (b - m) + (m - a)，
	 * 也就是把这两个数移动到中位数的移动次数。
	   设数组长度为 N，则可以找到 N/2 对 a 和 b 的组合，使它们都移动到 m 的位置。
	 */
	public int minMoves2(int[] nums) {
	    Arrays.sort(nums);
	    int ret = 0;
	    int l = 0, h = nums.length - 1;
	    while(l <= h) {
	        ret += nums[h] - nums[l];
	        l++;
	        h--;
	    }
	    return ret;
	}

}
