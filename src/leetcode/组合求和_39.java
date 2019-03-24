package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 组合求和_39 {

	
	
	public static List<List<Integer>> allSort(int[] candidates, int target){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();
		
		backTrackng(0,candidates,target,list,ret);
		return ret;
	}

	//k=4,n=2
	private static void backTrackng(int start,int[] candidates, int target, ArrayList<Integer> list, List<List<Integer>> ret) {
		if(target==0) {
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if(candidates[i]<=target) {
				list.add(candidates[i]);
				backTrackng(i,candidates,target-candidates[i], list, ret);
				list.remove(list.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		int nextInt = sc.nextInt();
		String[] split = nextLine.split(" ");
		int[] nums = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			nums[i] = Integer.valueOf(split[i]);
		}
		List<List<Integer>> allSort = allSort(nums,nextInt);
		for (List<Integer> list : allSort) {
			for (Integer i : list) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
}
