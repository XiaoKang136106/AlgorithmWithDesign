package 数组与矩阵;

public class 搜索二维矩阵_II_240 {
/*
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

	每行的元素从左到右升序排列。
	每列的元素从上到下升序排列。
 * [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
	给定 target = 5，返回 true。
	
	给定 target = 20，返回 false。
 */
	//思路:从右上角开始(行上最大,列上最小), 比较target 和 matrix[i][j]的值. 如果小于target(该行最大的数都小于target), 则该行不可能有此数,  所以i++;
	//如果大于target(该行右边的数大于target), 则该列不可能有此数, 所以j--(向左搜索). 遇到边界则表明该矩阵不含target.
	 public boolean searchMatrix(int[][] matrix, int target) {
	   //row为0 column 为0
	  if(matrix.length==0 || matrix[0].length ==0) 
		return false;
	  //从右上角开始
	  int i = 0;
	  int j = matrix[0].length-1;
	  //遍历,条件为不到达边界
	  while(i<=matrix.length-1 && j>=0) {
		 //获取当前位置的值
		  int x = matrix[i][j];
		  if(x==target) 
			  return true;
		  if(x < target) 
			  i++;
		  if(x > target) 
			  j--;
	  }
	  
		  
		  return false;
	 }
}
