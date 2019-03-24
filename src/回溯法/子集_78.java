package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class 子集_78 {
/*
 * 
		给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
		
		说明：解集不能包含重复的子集。
		
		示例:
		
		输入: nums = [1,2,3]
		输出:
		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
		]
 */
	 public List<List<Integer>> subsets(int[] nums) {
		    
		    List<List<Integer>> ret = new ArrayList<List<Integer>>();
		     List<Integer> subsetList = new ArrayList<Integer>();
		        for(int i=0;i<=nums.length;i++){
		            
		            backtracking(0,i,nums,subsetList,ret);
		        }
		        return ret;
		    }
		    private void backtracking(int startIdx, int size, int[] nums,List<Integer> subsetList, List<List<Integer>> ret) {
		        if(subsetList.size()==size){
		            ret.add(new ArrayList<Integer>(subsetList));
		            return;
		        }
		        
		        for(int i=startIdx;i<nums.length;i++){
		            subsetList.add(nums[i]);
		             backtracking(i + 1, size, nums,subsetList,ret);
		            subsetList.remove(subsetList.size()-1);
		        }
		        
		    }
	
	
	  
}