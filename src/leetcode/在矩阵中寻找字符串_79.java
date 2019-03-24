package leetcode;

public class 在矩阵中寻找字符串_79 {
	
	static int[][] d= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int m;
	static int n;
	public static boolean wordSerach(char[][] board,String world) {
		m = board.length;
		n=board[0].length;
		boolean[][] visited =new boolean[m][n];  
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(backTracking(0,i,j,visited,board,world)) {	
					return true;
				}
			}
		}
		return false;
	}
	private static boolean backTracking(int curLen,int i, int j, boolean[][] visited, char[][] board, String world) {
		if(curLen==world.length()) {
			return true;
		}
	    if (i < 0 || i>= m || j < 0 || j >= n
	            || board[i][j] != world.charAt(curLen) || visited[i][j]) {

	        return false;
	    }
	    visited[i][j]=true;
	    for(int[] r:d) {
	    	if(backTracking(curLen+1,i+r[0],j+r[1],visited,board,world)) {
	    		return true;
	    	}
	    	
	    }
	    visited[i][j] = false;
	    return false;
	}
	public static void main(String[] args) {
		
		
	}

}
