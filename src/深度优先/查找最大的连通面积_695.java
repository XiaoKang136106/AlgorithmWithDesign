package 深度优先;

public class 查找最大的连通面积_695 {
/**
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
	[0,0,0,0,0,0,0,1,1,1,0,0,0],
	[0,1,1,0,1,0,0,0,0,0,0,0,0],
	[0,1,0,0,1,1,0,0,1,0,1,0,0],
	[0,1,0,0,1,1,0,0,1,1,1,0,0],
	[0,0,0,0,0,0,0,0,0,0,1,0,0],
	[0,0,0,0,0,0,0,1,1,1,0,0,0],
	[0,0,0,0,0,0,0,1,1,0,0,0,0]]
	
	你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
		给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
		你可以假设二维矩阵的四个边缘都被水包围着。

		找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
		
		示例 1:
		
		[[0,0,1,0,0,0,0,1,0,0,0,0,0],
		 [0,0,0,0,0,0,0,1,1,1,0,0,0],
		 [0,1,1,0,1,0,0,0,0,0,0,0,0],
		 [0,1,0,0,1,1,0,0,1,0,1,0,0],
		 [0,1,0,0,1,1,0,0,1,1,1,0,0],
		 [0,0,0,0,0,0,0,0,0,0,1,0,0],
		 [0,0,0,0,0,0,0,1,1,1,0,0,0],
		 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
		对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
		
		示例 2:
		
		[[0,0,0,0,0,0,0,0]]
		对于上面这个给定的矩阵, 返回 0。
		
		注意: 给定的矩阵grid 的长度和宽度都不超过 50。
	
 */
	
/*	public int maxAreaOfIsland(int[][] grid) {
		//m= row n = column
	    int m = grid.length, n = grid[0].length;
	    int max = 0;//定义一个Max
	    for(int i = 0; i < m; i++){
	        for(int j = 0; j < n; j++){
	        	//开始寻找
	            if(grid[i][j] == 1) max = Math.max(max, dfs(grid, i, j));
	        }
	    }
	    return max;
	}

	private int dfs(int[][] grid, int i, int j){
	    int m = grid.length, n = grid[0].length;
	    if(i < 0 || i >= m || j < 0 || j >= n) return 0;
	    if(grid[i][j] == 0) return 0;
	    grid[i][j] = 0;//设置为已经走过了
	    return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
	}*/

	public int maxAreaOfIsland(int[][] grid) {
		int row =grid.length; int column =grid[0].length;
		int max =0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(grid[i][j] ==1)   max =Math.max(max, dfs(grid,i,j));
			}
			
		}
		return max;
	}

		private int dfs(int[][] grid, int i, int j) {
			int m = grid.length, n = grid[0].length; //重新获取row 和column
			if(i < 0 || i >= m || j < 0 || j >= n) return 0;//条件判断
			if(grid[i][j] ==0) return 0;
			grid[i][j] = 0;//设置为已经走过了
			return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
}
		private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		public static void main(String[] args) {
			  for (int[] d : direction) {
				 for (int i : d) {
					System.out.print(i+" ");
				}
				 System.out.println();
			    }
		}
}
