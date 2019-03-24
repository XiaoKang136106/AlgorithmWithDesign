package 剑指offer;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 	例如，如果输入如下4 X 4矩阵：   1  2  3  4
 * 						  	5  6  7  8
 *  						9  10 11 12 
 *  					    13 14 15 16 
 * 	则依次打印出数字			 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 * 		x x x x 			
 * 		x x x x				
 * 		x x x x				
 * 		x x x x
  */
public class _19顺时针打印矩阵 {
	
	public static  ArrayList<Integer> printMatrix(int[][] matrix) {
	    ArrayList<Integer> ret = new ArrayList<>();
	    int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
	    while (r1 <= r2 && c1 <= c2) {
	        for (int i = c1; i <= c2; i++)
	            ret.add(matrix[r1][i]);
	        for (int i = r1 + 1; i <= r2; i++)
	            ret.add(matrix[i][c2]);
	        if (r1 != r2)
	            for (int i = c2 - 1; i >= c1; i--)
	                ret.add(matrix[r2][i]);
	        if (c1 != c2)
	            for (int i = r2 - 1; i > r1; i--)
	                ret.add(matrix[i][c1]);
	        r1++; r2--; c1++; c2--;
	    }
	    return ret;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] nums =new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				nums[i][j]=sc.nextInt();
			}
		}
		ArrayList<Integer> printMatrix = printMatrix(nums);
		for (Integer integer : printMatrix) {
			System.out.print(integer+"->");
		}
	}

	//终止行号大于起始行号，终止列号大于起始列号
/*		1.选坐标为(0,0),(1,1)...的点记为(start,start)为开始坐标,下一圈开始坐标为(start+1,start+1)
		* 2.判断是否进入下一圈(即是否打印完成)的条件是row>start*2 && column>start*2
		* 3.打印一圈的左上角坐标为(start,start)，右下角的坐标为(column-start-1,row-start-1)
		* 4.根据一圈左上角和右下角坐标判断“从左到右”，“从上到下”，“从右到左”，“从下到上”哪些用打印，哪些不用*/
	/*public ArrayList<Integer> printMatrix(int[][] matrix) {

		ArrayList<Integer> list = new ArrayList<>();
		if (matrix == null)
			return list;
		int start = 0;
		//循环条件,每次打印一圈,缩短一半
		while (matrix[0].length > start * 2 && matrix.length > start * 2) {
			
			printOneCircle(matrix, start, list);
			start++;
		}
		return list;
	}

	private void printOneCircle(int[][] matrix,int start,ArrayList<Integer> list) {
		int endX = matrix[0].length - 1 - start; // 列,该行结束的索引值
		int endY = matrix.length - 1 - start; // 行,该列结束索引值
		// 从左往右
		for (int i = start; i <= endX; i++)
		list.add(matrix[start][i]);
		// 从上往下(起始的索引要小于列结束的索引)
		if (start < endY) {
		for (int i = start + 1; i <= endY; i++)
		list.add(matrix[i][endX]);
		} 
		// 从右往左（判断是否会重复打印）起始的索引要小于行结束的索引和列结束的索引
		if (start < endX && start < endY) {
		for (int i = endX - 1; i >= start; i--)
		list.add(matrix[endY][i]);
		} 
		// 从下往上（判断是否会重复打印） 起始的索引要小于行结束的索引和列结束的索引-1(因为第一个被打印出来了)
		if (start < endX && start < endY - 1) {
		for (int i = endY - 1; i >= start + 1; i--)
		list.add(matrix[i][start]);
			     }
	}*/
	
	
	

}
