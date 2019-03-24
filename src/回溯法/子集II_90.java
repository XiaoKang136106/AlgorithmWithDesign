package 回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II_90 {
/*
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

	说明：解集不能包含重复的子集。
	
	示例:
	
	输入: [1,2,2]
	输出:
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 * 
 * 
 * 
 */
	
		public List<List<Integer>> ret;
		public List<Integer> list;
		public boolean[] visited; 
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		ret = new ArrayList<List<Integer>>();
		list= new ArrayList<Integer>();
		visited = new boolean[nums.length];
		//排序
		Arrays.sort(nums);
		//i为size
		for (int i = 0; i <= nums.length; i++) {
			//开始回溯
			backTracking(0,i,nums);
		}
		return ret;
	    }
	private void backTracking(int startIdx, int size, int[] nums) {

		//结束条件
		if(list.size()==size) {
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = startIdx; i < nums.length; i++) {
			//遍历查找
			//判断是否重复,当前的nums等于前一个nums,并且前一个nums没有被访问
			if(i !=0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
			
			//往集合添加数据
			list.add(nums[i]);
			//标记
			visited[i]=true;
			//递归
			backTracking(i+1, size, nums);
			//回退一步,并清除标记
			list.remove(list.size()-1);
			visited[i]=false;
		}
		
		
	}


}
