package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 子集_78 {

	
	public static List<List<Integer>> allSort(int[] nums){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();
		//控住大小
		for (int i = 0; i <= nums.length; i++) {
			backTrackng(0,nums,list,ret,i);
		}
		
		return ret;
	}

	private static void backTrackng(int start,int[] nums, ArrayList<Integer> list, List<List<Integer>> ret,int size) {
			if(list.size() ==size) {
				ret.add(new ArrayList<Integer>(list));
				return;
			}
			for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			backTrackng(i+1,nums, list, ret,size);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String[] split = nextLine.split(" ");
		int[] nums = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			nums[i] = Integer.valueOf(split[i]);
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
