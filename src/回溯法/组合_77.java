package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class 组合_77 {
	/**
	 * If n = 4 and k = 2, a solution is:
		[
		  [2,4],
		  [3,4],
		  [2,3],
		  [1,2],
		  [1,3],
		  [1,4],
		]
	 */
	//给定两个整数 n 和 k，返回 1 … n 中所有可能的 k 个数的组合。
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret  = new ArrayList<List<Integer>>();
		
		List<Integer> combineList = new ArrayList<Integer>(); 
		//从1开始
		backtracking(1,n,k,combineList,ret);
		
		return ret;
	}
	//n=4,k=2
	private void backtracking(int start ,int n, int k, List<Integer> combineList, List<List<Integer>> ret){
		//添加条件
		if(combineList.size()==k){
	            ret.add(new ArrayList<>(combineList));
	        }else{
	            for(int i=start;i<=n;i++){
	            	combineList.add(i);
	                backtracking(i+1,n,k,combineList,ret);
	                combineList.remove(combineList.size()-1);
	            }
	        }
	}
	
	
}
