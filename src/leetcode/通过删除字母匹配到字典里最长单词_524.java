package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 通过删除字母匹配到字典里最长单词_524 {
	
	
	public static String longestNum(String str,List<String> d ) {
		
		String ret="";
		for (String s : d) {
			for (int i = 0,j=0; i < str.length()&&j<s.length(); i++) {
					
				 if(str.charAt(i) ==s.charAt(j)) j++;
				 if(j==s.length() ) {
					 if(j>ret.length() || j==ret.length() && s.compareTo(str)>0)
					 ret =s;
				 }
					
			}
		}
		
		return ret;
		
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		ArrayList<String> list = new ArrayList<String>();
			String line = sc.nextLine();
			String[] split = line.split(" ");
			for (String string : split) {
				list.add(string);
			}
		String string = longestNum(str,list);
		System.out.println(string);
		
		PriorityQueue<Object> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(string);
		priorityQueue.remove();
	}

}
