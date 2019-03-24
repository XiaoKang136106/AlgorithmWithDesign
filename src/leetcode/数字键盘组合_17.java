package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 数字键盘组合_17 {
	
	
	private final static String[] KEYS= {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public static List<String> numComination(String s){
		List<String> ret = new ArrayList<String>();
		if(s.length()==0 ||s=="") return ret;
		
		backTracking(new StringBuilder(),s,ret);
		
		return ret;
	}

	private static void backTracking(StringBuilder sb, String s, List<String> ret) {
		if(sb.length()==s.length()) {
			ret.add(sb.toString());
			return;
		}
		String str = KEYS[s.charAt(sb.length())-'0'];//2 =>a,b,c
		for (char c : str.toCharArray()) {
			sb.append(c);
			backTracking(sb,s,ret);
			sb.deleteCharAt(sb.length()-1);
		}
		
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		List<String> numComination = numComination(string);
		for (String string2 : numComination) {
			System.out.println(string2);
		}
	}

}
