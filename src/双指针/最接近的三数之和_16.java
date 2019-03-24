package 双指针;

import java.util.Arrays;

public class 最接近的三数之和_16 {
	
	/*
	 * 
			 * 已完成
		执行用时: 1 ms
		输入
		[-1,2,1,-4]
		1
		输出
		2
		差别
		预期结果
		2
	 */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetNum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;int r=nums.length-1;
            while(l<r){
                 int threeSum=nums[i]+nums[l]+nums[r];
            if(Math.abs(threeSum-target)<Math.abs(closetNum-target)){
                closetNum=threeSum;
            }
            if(threeSum>target){
                r--;
            }else if(threeSum<target){
                l++;
            }else{
                return target;
            }
                
                
            }
  
        }
        return closetNum;
    }
}
