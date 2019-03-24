package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class 组合总和_39 {
/*
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
	
	candidates 中的数字可以无限制重复被选取。
	
	说明：
	
	所有数字（包括 target）都是正整数。
	解集不能包含重复的组合。 
	示例 1:
	
	输入: candidates = [2,3,6,7], target = 7,
	所求解集为:
	[
	  [7],
	  [2,2,3]
	]
	示例 2:
	
	输入: candidates = [2,3,5], target = 8,
	所求解集为:
	[
	  [2,2,2,2],
	  [2,3,3],
	  [3,5]
	]
 * 
 * 
 */
	
/*//	 private List<List<Integer>> ret;
//
//	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
//	     ret = new ArrayList<>();
//	     doCombination(candidates, target, 0, new ArrayList<>());
//	     return ret;
//	 }
//
//	 private void doCombination(int[] candidates, int target, int start, List<Integer> list) {
//	     if (target == 0) {
//	         ret.add(new ArrayList<>(list));
//	         return;
//	     }
//	     for (int i = start; i < candidates.length; i++) {
//	         if (candidates[i] <= target) {
//	             list.add(candidates[i]);
//	             doCombination(candidates, target - candidates[i], i, list);
//	             list.remove(list.size() - 1);
//	         }
//	     }
//	 }
*/	 
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        
		 List<List<Integer>> ret = new ArrayList<List<Integer>>();
		 
		 List<Integer> list =new ArrayList<Integer>();
		 //开始回溯
		 backTracking(candidates,target,0,list,ret);
		 return ret;
	    }

		private void backTracking(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> ret) {
			
			//结束条件,tatget刚刚 = 0 ,才是想要的结果
			if(target ==0) {
				ret.add(new ArrayList<Integer>(list));
				return;
			}
			
			for (int i = start; i < candidates.length; i++) {
				//candidates[i]<=target,添加到集合中
				if(candidates[i]<=target) {
					list.add(candidates[i]);
				//递归
				backTracking(candidates, target-candidates[i],i, list, ret);
				//回退
				list.remove(list.size()-1);
				}
			}
			
		}
}
