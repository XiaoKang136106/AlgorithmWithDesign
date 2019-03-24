package leetcode;

public class 在排序数组中查找元素的第一个和最后一个位置_34 {
	
	/*
	 * 输入: nums = [5,7,7,8,8,10], target = 8
	输出: [3,4]
	示例 2:
	
	输入: nums = [5,7,7,8,8,10], target = 6
	输出: [-1,-1]
	 */
	 public int[] searchRange(int[] nums, int target) {
     	int begin=-1;
		int end =-1;
		boolean flag=false;//标记
		for(int i=0;i<nums.length;i++) {
				if(nums[i]==target) {
					//没有出现过
					if(!flag) {
						begin=i;
						end=i;
						flag=true;
					}else {
						end=i;
					}
				}
		}
		return new int[] {begin,end};
 }

}
