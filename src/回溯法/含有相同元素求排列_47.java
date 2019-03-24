package 回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;

public class 含有相同元素求排列_47 {
/*
 * [1,1,2] have the following unique permutations:
	[[1,1,2], [1,2,1], [2,1,1]]
 * 题目描述：数组元素可能含有相同的元素，进行排列时就有可能出现重复的排列，要求重复的排列只返回一个。
 * 
 * 在实现上，和 Permutations 不同的是要先排序，然后在添加一个元素时，
 * 判断这个元素是否等于前一个元素，如果等于，并且前一个元素还未访问，那么就跳过这个元素。
 */
	/*public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
	    List<Integer> permuteList = new ArrayList<>();
	    Arrays.sort(nums);//先排序
	    boolean[] visited = new boolean[nums.length];
	    backtracking(permuteList, visited, nums, ret);
	    return ret;
	}

private void backtracking(List<Integer> permuteList, boolean[] visited, int[] nums, List<List<Integer>> ret) {
    if (permuteList.size() == nums.length) {
        ret.add(new ArrayList(permuteList));
        return;
    }

    for (int i = 0; i < visited.length; i++) {
        //进行判断,i不等于0 并且 i的值等于i-1的值 并且 i-1为false,前一个相同的字母没有被访问,就跳过.
    	if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
        if (visited[i]) continue;
        visited[i] = true;
        permuteList.add(nums[i]);
        backtracking(permuteList, visited, nums, ret);
        permuteList.remove(permuteList.size() - 1);
        visited[i] = false;
    	}
	}*/
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> permuteList = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		backtracking(permuteList,visited,nums,ret);
		return ret;
	}
	private void backtracking(List<Integer> permuteList, boolean[] visited, int[] nums, List<List<Integer>> ret) {
			
			if(permuteList.size() == nums.length) {
				
				ret.add(new ArrayList<Integer>(permuteList));
				return;
			}
			
			for (int i = 0; i < nums.length; i++) {
				//前一个没有被访问
				if(i !=0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
				if(visited[i]) continue;
					permuteList.add(nums[i]);
					visited[i]=true;
					backtracking(permuteList, visited, nums, ret);
					permuteList.remove(permuteList.size()-1);
					visited[i]=false;
			}
			
	}
}
