package 回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 组合总和II_40 {
/*
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	
	candidates 中的每个数字在每个组合中只能使用一次。
	
	说明：
	
	所有数字（包括目标数）都是正整数。
	解集不能包含重复的组合。 
	示例 1:
	
	输入: candidates = [10,1,2,7,6,1,5], target = 8,
	所求解集为:
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]
	示例 2:
	
	输入: candidates = [2,5,2,1,2], target = 5,
	所求解集为:
	[
	  [1,2,2],
	  [5]
	]
 */
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        
	   List<List<Integer>> ret = new ArrayList<List<Integer>>();
	   List<Integer> list =new ArrayList<Integer>();
	   Arrays.sort(candidates);//进行排序
	   boolean[] visited = new boolean[candidates.length];
	   //开始回溯
	   backTracking(candidates,0,target,list,visited,ret);
	   return ret;
	}

	private void backTracking(int[] candidates, int start, int target, List<Integer> list, boolean[] visited,List<List<Integer>> ret) {
		
		//终止条件
		if(target ==0) {
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			//判断是否使用了2次
			if(i !=0 && candidates[i] == candidates[i-1] && !visited[i-1]) continue;
			if(candidates[i]<=target) {
				//标记
				visited[i]=true;
				//添加
				list.add(candidates[i]);
				//递归
				backTracking(candidates, i+1, target-candidates[i], list, visited, ret);
				//取消标记
				visited[i]=false;
				//回溯一步
				list.remove(list.size()-1);
				
			}
		}
	}
}
