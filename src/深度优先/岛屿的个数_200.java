package 深度优先;

public class 岛屿的个数_200 {
/**
 * 
		给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
		并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
		
		示例 1:
		
		输入:
		11110
		11010
		11000
		00000
		
		输出: 1(所有的1都连在一起所有为1)
		示例 2:
		
		输入:
		11000	11
		11000	11  
		00100		1	
		00011		   11	
		
		输出: 3
 */
	
	private int m, n;
	//private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private int[][] direction= {{-1,0},{0,-1},{1,0},{0,1}};
	public int numIslands(char[][] grid) {
	    if (grid == null || grid.length == 0) return 0;
	    m = grid.length;
	    n = grid[0].length;
	    int ret = 0;
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (grid[i][j] == '1') {
	                dfs(grid, i, j);
	                ret++;
	            }
	        }
	    }
	    return ret;
	}

	private void dfs(char[][] grid, int i, int j) {
	    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
	    grid[i][j] = '0';
	    //深度优先
	    dfs(grid,i+1,j);
	    dfs(grid,i-1,j);
	    dfs(grid,i,j+1);
	    dfs(grid,i,j-1);
	    for(int[] d: direction) {
	    	dfs(grid, i+d[0], j+d[1]);
	    }
	    /*
	     * 俩者相同表示上下左右
	     *   for (int k = 0; k < direction.length; k++) {
        	dfs(grid, i + direction[k][0], j + direction[k][1]);
    }
	     */
	}
}
