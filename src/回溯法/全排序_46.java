
package 回溯法;
import java.util.ArrayList;
import java.util.List;

public class 全排序_46 {
/*
 * [1,2,3] have the following permutations:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
 */

	/*public List<List<Integer>> permute(int[] nums) {
			
		   List<List<Integer>> ret = new ArrayList<>();
		    List<Integer> permuteList = new ArrayList<>();
		    boolean[] visited = new boolean[nums.length];
		    backtracking(permuteList, visited, nums, ret);
		    return ret;
		}

		private void backtracking(List<Integer> permuteList, boolean[] visited, int[] nums, List<List<Integer>> ret){

			
			//终止条件
			if(permuteList.size() == nums.length){
		        ret.add(new ArrayList(permuteList));
		        return;
		    }
			//遍历
		    for(int i = 0; i < visited.length; i++){
		    	//true,跳出循环
		    	if(visited[i]) continue;
		        visited[i] = true;
		        permuteList.add(nums[i]);
		        backtracking(permuteList, visited, nums, ret);
		        permuteList.remove(permuteList.size() - 1);//从后面开始移除元素
		        visited[i] = false;//重置标志位
		    }
		}*/
	public List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> permuteList= new ArrayList<Integer>();
		
		boolean[] visited = new boolean[nums.length];
		backtracking(permuteList,visited,nums,ret);
		return ret;
	}
	
	private void backtracking(List<Integer> permuteList, boolean[] visited, int[] nums, List<List<Integer>> ret){
		//终止条件
		if(permuteList.size() == nums.length) {
			ret.add(new ArrayList(permuteList));
			return;
			}
		for (int i = 0; i < nums.length; i++) {
			if(visited[i]) continue;
			permuteList.add(nums[i]);
			visited[i] = true;
			backtracking(permuteList, visited, nums, ret);
			permuteList.remove(permuteList.size()-1);
			visited[i]=false;
		}
	}
}
