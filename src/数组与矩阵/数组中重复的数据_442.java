package 数组与矩阵;

import java.util.ArrayList;
import java.util.List;

public class 数组中重复的数据_442 {
/**
 * 找到所有出现两次的元素。
 * 输入:
	[4,3,2,7,8,2,3,1]
	
	输出:
	[2,3]
 */
	
	/*
	 * ：重新创建一个数组(boolean[])，开始的时候赋值为-1，然后把原数组中的数放在相同的对应的位置上，
	 * 等于-1的位置就是原数组没有的数字。所用的时间复杂度是O(n),空间复杂度也是O(n)。
	 */
	
	  public List<Integer> findDuplicates(int[] nums) {
	     boolean[] ans = new boolean[nums.length+1];
	     List<Integer> ret  = new ArrayList<Integer>();
	     for(int i=0;i<nums.length;i++) {
	    	 if(ans[nums[i]] ==false)
	    		 ans[nums[i]] =true;
	    	 else
	    		 ret.add(nums[i]);
	     }
	     return ret;
	  	}
}
