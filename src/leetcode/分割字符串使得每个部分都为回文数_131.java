package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 分割字符串使得每个部分都为回文数_131 {
	
	public static List<List<String>> partition(String s) {
	    List<List<String>> partitions = new ArrayList<>();
	    List<String> tempPartition = new ArrayList<>();
	    doPartition(s, partitions, tempPartition);
	    return partitions;
	}

	private static void doPartition(String s, List<List<String>> partitions, List<String> tempPartition) {
	    if (s.length()==0) {
	        partitions.add(new ArrayList<>(tempPartition));
	        return;
	    }
	    for (int i = 0; i < s.length(); i++) {
	        if (isPalindrome(s, 0, i)) {
	            tempPartition.add(s.substring(0, i + 1));
	            doPartition(s.substring(i + 1), partitions, tempPartition);
	            tempPartition.remove(tempPartition.size() - 1);
	        }
	    }
	}

	private static boolean isPalindrome(String s, int begin, int end) {
	    while (begin < end) {
	        if (s.charAt(begin++) != s.charAt(end--)) {
	            return false;
	        }
	    }
	    return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		List<List<String>> partition = partition(nextLine);
		for (List<String> list : partition) {
			for (String s : list) {
				System.out.print(s+",");
			}
			System.out.println();
		}
	}

}
