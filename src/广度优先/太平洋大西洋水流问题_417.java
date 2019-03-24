package 广度优先;

import java.util.ArrayList;
import java.util.List;

public class 太平洋大西洋水流问题_417 {
/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，
 * 	而“大西洋”处于大陆的右边界和下边界。

	规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
	
	请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
	
	 
	
	提示：
	
	输出坐标的顺序不重要
	m 和 n 都小于150
	
	给定下面的 5x5 矩阵:

	    太平洋 ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * 大西洋

返回:
比如:[0,4] 上得5表示可以走5步到太平洋或者大西洋

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */
		int[][] direction= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //表示右,左,下,上
		int m,n;
		int[][] matrix;
		
	public List<int[]> pacificAtlantic(int[][] matrix) {
		
			List<int[]> ret = new ArrayList<int[]>();
			  
			if(matrix ==null ||matrix.length==0) return ret;
	      
			this.m = matrix.length; //row
			this.n = matrix[0].length; //column
			this.matrix= matrix;	//将原位置的所有值赋给matrix
	        boolean[][] canReachP = new boolean[m][n]; //可以到太平洋?
	        boolean[][] canReachA = new boolean[m][n];//可以到大西洋?
			//使用BFS遍历row
			for (int i = 0; i < m; i++) {
				//每一行的0
				dfs(i,0,canReachP);
				//每一行的n-1
				dfs(i,n-1,canReachA);
			}
			//使用bfs遍历column
			for (int i = 0; i < n; i++) {
				dfs(0,i,canReachP);
				dfs(m-1,i,canReachA);
			}
			//遍历二维数组
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(canReachP[i][j] && canReachA[i][j]) {
						ret.add(new int[] {i,j});
					}
				}
			}
			
			return ret;
	    }
		private void dfs(int r, int c, boolean[][] canReach) {
			//true return;
			if(canReach[r][c]) return;
			//假设为true
			
			canReach[r][c] = true;
			
			//进行bfs搜索
			for (int i = 0; i < direction.length; i++) {
				//获取接下来到值,只能进行左右或者向下移动
				int nextR = direction[i][0] + r; //左右为row
				int nextC = direction[i][1] + c;//向下为column
				//进行判断,满足条件退出当前循环
				if(nextR <0 || nextR>= m || nextC<0 || nextC >=n ||matrix[r][c]>matrix[nextR][nextC])
					continue;
				//进行进行搜索
				dfs(nextR, nextC, canReach);
		}
		}
}
