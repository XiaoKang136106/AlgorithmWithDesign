package 数组区间;

public class 搜索旋转排序数组_81 {
/*
 * 示例 1:

	输入: nums = [2,5,6,0,0,1,2], target = 0
	输出: true
	示例 2:
	
	输入: nums = [2,5,6,0,0,1,2], target = 3
	输出: false
 */
	   public boolean search(int[] nums, int target) {
	        if(nums.length==0||nums==null){
	            return false;
	        }
	        int l=0;
	        int r=nums.length-1;
	        while(l<=r){
	            int mid=(l+r)>>1;
	            if(nums[mid] ==target) return true;
	            if(nums[mid]>nums[l]){
	               if(target>=nums[l]&&target<nums[mid]){
	                   r=mid-1;
	               } else{
	                   l=mid+1;
	               }
	            }else if(nums[mid]<nums[l]){
	                if(target<=nums[r]&&target>nums[mid]){
	                     l=mid+1;
	                   
	                } else{
	                  r=mid-1;
	               }
	            }else{
	                //防止未出现的情况
	                l++;
	            }    
	        }
	        return false;
	    }
}
