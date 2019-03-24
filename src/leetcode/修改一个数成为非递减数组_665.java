package leetcode;

import java.util.Scanner;

public class 修改一个数成为非递减数组_665 {
	
	
	
	public static boolean changOneNum(int[] nums) {
		if(nums.length<=2) return true;
		int cnt=0;
		for(int i=1;i<nums.length&&cnt<2;i++) {
			if(nums[i]<nums[i-1]) {
				
				if(i-2>0 && nums[i-2]>nums[i]) {
					nums[i]=nums[i-1];
				}else {
					nums[i-1]=nums[i];
				}
				cnt++;
			}
			
		}
		
		return cnt<=1?true:false;
	}

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		/*Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String[] split = nextLine.split(" ");
		int[] nums=new int[split.length];
		for (int i = 0; i < split.length; i++) {
			nums[i] =Integer.valueOf(split[i]);
			
		}
		boolean changOneNum = changOneNum(nums);
		System.out.println(changOneNum);*/
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] grids = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grids[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grids[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
