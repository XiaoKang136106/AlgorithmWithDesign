package leetcode;

public class 最大连通量_695 {

	
	private int[][] d= {{1,0},{0,1},{-1,0},{0,-1}};
	private int m;
	private int n;
	public int maxAreaOfIsland(int[][] grid) {
		int max=0;
		 m=grid.length;
		 n=grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j]==1) {
					max =Math.max(dfs(grid,i,j), max);
				}
			}
		}
		 return max;
	}
	private int dfs(int[][] grid, int i, int j) {
		if(i<0||j<0||i>=m||j>=n||grid[i][j]==0) return 0;
		grid[i][j]=0;
		int ret=1;
		for(int[] r: d) {
			ret += dfs(grid,i+r[0],j+r[1]);
		}
		return ret;
	}
	public static void main(String[] args) {
		
	}
}
