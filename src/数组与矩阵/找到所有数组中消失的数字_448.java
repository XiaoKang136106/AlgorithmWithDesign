package 数组与矩阵;

import java.util.ArrayList;
import java.util.List;

public class 找到所有数组中消失的数字_448 {
/**
 * 输入:
	[4,3,2,7,8,2,3,1]
	
	输出:
	[5,6]
 */
/**
 * 第一种解法：重新创建一个数组(boolean[])，开始的时候赋值为-1，然后把原数组中的数放在相同的对应的位置上，等于-1的位置就是原数组没有的数字。所用的时间复杂度是O(n),空间复杂度也是O(n)。
 */
	 public List<Integer> findDisappearedNumbers(int[] nums) {
	      boolean[] ret = new boolean[nums.length+1];//标记作用,从1开始,记录的是nums[i]是否被访问了,默认为false
	      List<Integer> list =new ArrayList<Integer>();
	      for(int i=0;i<nums.length;i++) {
	    	  
	    	  if(ret[nums[i]] ==false)
	    		  ret[nums[i]] =true;
	      }
	      
	      for(int i=1;i<nums.length+1;i++) {
	    	  if(ret[i] ==false) {
	    		  list.add(i);
	    	  }
	    	  
	      }
	      return list;
	    }
}
