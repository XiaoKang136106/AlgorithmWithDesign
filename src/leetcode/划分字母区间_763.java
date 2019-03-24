package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 划分字母区间_763 {
	
	public static List<Integer> partitionLables(String s){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int[] lastIds = new int[26];
		for (int i = 0; i < s.length(); i++) {
			lastIds[s.charAt(i)-'a']=i;
		}
		int startId =0;
		while(startId<s.length()) {
			int endId=startId;
			for(int i=startId;i<=endId;i++) {
				int lastId=lastIds[s.charAt(i)-'a'];
				if(lastId==i)continue;
				if(lastId>endId) {
					endId=lastId;
				}
			}
			ret.add(endId-startId+1);
			startId=endId+1;
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		List<Integer> list = partitionLables(nextLine);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
