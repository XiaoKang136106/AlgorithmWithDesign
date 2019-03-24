package 剑指offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class 最长连续子字符串问题_67 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String s=str.toLowerCase();
		int len=1;//连续长度
		int max=1;//最大连续长度
		int mark=0;//下标
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == s.charAt(i-1)+1) {
				len++;
				
			}else {			
				if(len>max) {
					max=len;
					len=1;
					mark=i-max;
				}
			}
		}
		//用于判断从头到尾都是连续的
		/*if(len>max) {
			max=len;
		}*/
		max=Math.max(max, len);
		StringBuilder sb = new StringBuilder();
		for(int j=mark;j<(mark+max);j++) {
			sb.append(str.charAt(j));
		}
		System.out.println(max);
	
		System.out.println(sb.toString());
		
		HashSet<Object> set = new HashSet<>();
		LinkedList<Object> linkedList = new LinkedList<>();
	}

}
