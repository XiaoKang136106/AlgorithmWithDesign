package 数组与矩阵;

public class 有序矩阵中第K小的元素_378 {
/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
	请注意，它是排序后的第k小元素，而不是第k个元素。
 * matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
	],
	k = 8,
	返回 13。
 */
	
	/*
	 * 思路:
		1.首先设置mid的初值为矩阵matrix，最后一个数和第一个数的平均值。 
		2.统计矩阵中每一行小于mid值的个数之和。若该值小于8，记录当前mid，L = mid + 1，并更新mid；若该值大于8，R = mid - 1。 
		3.重复上述搜索，直至L和R不满足L <= R,此时的mid值即为所求。*/
	
	public int kthSmallest(int[][] matrix, int k) {
		// m = row   n =column 
	    int m = matrix.length, n = matrix[0].length;
	    // lo  min  hi max mid = 第一个数 和 平均值 相加
	    int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
	    //循环
	    while(lo <= hi) {
	        //二分
	    	int mid = lo + (hi - lo) / 2;
	        //查找次数
	    	int cnt = 0;
	        //遍历
	    	for(int i = 0; i < m; i++) {
	    		//j<n 并且 当前值 小于等于 mid 
	            for(int j = 0; j < n && matrix[i][j] <= mid; j++) {
	                cnt++;//查找++
	            }
	        }
	    	
	        if(cnt < k) lo = mid + 1;
	        else hi = mid - 1;
	    }
	    return lo;   
    }
}
