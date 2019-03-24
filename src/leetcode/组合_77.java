package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 组合_77 {

	
	
	public static List<List<Integer>> allSort(int k,int n){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();
		
		backTrackng(1,k,n,list,ret);
		return ret;
	}

	//k=4,n=2
	private static void backTrackng(int start,int k, int n, ArrayList<Integer> list, List<List<Integer>> ret) {
		if(list.size()==n) {
			ret.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i <= k; i++) {
			list.add(i);
			backTrackng(i+1,k,n, list, ret);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		List<List<Integer>> allSort = allSort(k,n);
		for (List<Integer> list : allSort) {
			for (Integer i : list) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
}
