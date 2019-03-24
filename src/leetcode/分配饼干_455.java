package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 分配饼干_455 {
	
	public static int fanout(int[] nums1,int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int count=0;
		int i=0;
		int j=0;
		while(i<nums1.length&&j<nums2.length) {
			if(nums1[i]<=nums1[j] ) {
				i++;
			}
				j++;
		}
		return i;
	}
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sNum = sc.nextLine();
		String bgNum = sc.nextLine();
		String[] split = sNum.split(" ");
		String[] split2 = bgNum.split(" ");
		int[] nums1 = new int[split.length];
		int[] nums2 = new int[split2.length];
		for (int i = 0; i < split.length; i++) {
			nums1[i]=Integer.valueOf(split[i]);
		}
		for (int i = 0; i < split2.length; i++) {
			nums2[i]=Integer.valueOf(split2[i]);
		}
		int fanout = fanout(nums1, nums2);
		System.out.println(fanout);
		
	}

}
