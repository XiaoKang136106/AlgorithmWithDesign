package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 前K个高频元素_347 {
	
	public static List<Integer> topK(int[] nums,int k) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		List<Integer>[] list = new ArrayList[nums.length + 1];
		for (int key : map.keySet()) {
			int count = map.get(key);
			if(list[count] ==null) {
				list[count]=new ArrayList<>();
			}
			list[count].add(key);
		}
		List<Integer> ret = new ArrayList<Integer>();
		for(int i=nums.length + 1;i>=0 && ret.size()<k;i++) {
			if(list[i]!=null) {
				ret.addAll(list[i]);
			}
		}
		return ret;
	}

}
