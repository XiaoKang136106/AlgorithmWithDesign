package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 全排序_46 {

	
	public static List<List<Integer>> allSort(int[] nums){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		backTrackng(nums,list,ret,visited);
		return ret;
	}

	private static void backTrackng(int[] nums, ArrayList<Integer> list, List<List<Integer>> ret, boolean[] visited) {
		if(list.size()==nums.length) {
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(i!=0 && nums[i-1] ==nums[i] && !visited[i-1]) {
				continue;
			}
			if(visited[i]) {
				continue;
			}
			
			list.add(nums[i]);
			visited[i]=true;
			backTrackng(nums, list, ret,visited);
			list.remove(list.size()-1);
			visited[i]=false;
		}
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String[] split = nextLine.split(" ");
		int[] nums = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			nums[i]=Integer.valueOf(split[i]);
		}
		List<List<Integer>> allSort = allSort(nums);
		for (List<Integer> list : allSort) {
			for (Integer i : list) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}

}
