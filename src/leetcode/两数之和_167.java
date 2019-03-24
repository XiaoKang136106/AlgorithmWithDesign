package leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class 两数之和_167 {
	
	
	public static int[] twoSum(int[] numbers,int target) {
		   int i = 0, j = numbers.length - 1;
		    while (i < j) {
		        int sum = numbers[i] + numbers[j];
		        if (sum == target) {
		            return new int[]{i + 1, j + 1};
		        } else if (sum < target) {
		            i++;
		        } else {
		            j--;
		        }
		    }
		    return null;
		
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int nextInt = sc.nextInt();
		String[] split = line.split(" ");
		int[] arr =new int[split.length];
			for(int i=0;i<split.length;i++) {
				arr[i]=Integer.parseInt(split[i]);
			}
			
			int[] twoSum = twoSum(arr,nextInt);
			for (int i : twoSum) {
				System.out.print(i+" ");
			}
	}

}
