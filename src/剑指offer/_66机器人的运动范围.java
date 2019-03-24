package 剑指offer;

import java.util.Arrays;
import java.util.List;

public class _66机器人的运动范围 {

	/*
	 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
	 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
	 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
	 * 
	 */
	// 思路：利用递归实现，每次只能走上下左右四个点，进行判断点的位置是否越界，点数之和是否大于K，是否已经走过了
	/*
	 *
	 * 
	 * 3:回溯法 核心思路： 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索， 返回1 + 4 个方向的探索值之和。
	 * 				2.探索时，判断当前节点是否可达的标准为： 1）当前节点在矩阵内； 2）当前节点未被访问过； 3）当前节点满足limit限制。
	 */
/*	public int movingCount(int threshold, int rows, int cols) {

		int flag[][] = new int[rows][cols]; // 记录是否已经走过
		return helper(0, 0, rows, cols, flag, threshold);
	}

	private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
			return 0;
		flag[i][j] = 1;
		return helper(i - 1, j, rows, cols, flag, threshold) + helper(i + 1, j, rows, cols, flag, threshold)
				+ helper(i, j - 1, rows, cols, flag, threshold) + helper(i, j + 1, rows, cols, flag, threshold) + 1;
	}

	//计算行坐标数位之和
	private int numSum(int i) {
		
		int sum = 0;
		while (i > 0) {
			sum += i % 10;
			i = i / 10;
		}
		return sum;
	}*/
	
	  public int movingCount(int threshold, int rows, int cols){
	     //定义标志位,为1表示已经走过了
		  int[][] flag =new int[rows][cols];
		  
		  //使用回溯法
		  return helper(0,0,rows,cols,threshold,flag);
		  
	    }
	  //起始行索引,起始列索引,行号,列号,坐标和列坐标的数位之和
	private int helper(int i, int j, int rows, int cols, int threshold,int[][] flag) {
		//判断结束条件
		if(i<0 || j<0 || i>=rows ||j>= cols || numSum(i)+numSum(j)>threshold || flag[i][j] ==1)
		return 0;
		//标志位改为1
		flag[i][j] =1;
		//这里没有算上0,0
		return helper(i-1, j, rows, cols, threshold,flag) + helper(i+1, j, rows, cols, threshold,flag)+
				helper(i, j-1, rows, cols, threshold,flag) + helper(i, j+1, rows, cols, threshold,flag) +1;
	}
	
	private int numSum(int i) {
		int sum =0;
		while(i>0) {
			sum += i%10;
			i=i/10;
		}
		
		return sum;
	}
	public static void main(String[] args) {
	      Integer[] ints = {1,2,3,4,5};
	        List list = Arrays.asList(ints);
	        System.out.println("list'size：" + list.size());
	        System.out.println("list.get(0) 的类型:" + list.get(0).getClass());
	        System.out.println("list.get(0) == ints[0]：" + list.get(0).equals(ints[0]));
	}

}
