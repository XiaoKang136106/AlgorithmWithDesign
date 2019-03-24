package 双指针;

public class 查找区间_34 {
/*
 *  * Input: nums = [5,7,7,8,8,10], target = 8
	Output: [3,4]
	
	Input: nums = [5,7,7,8,8,10], target = 6
	Output: [-1,-1]
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
