package 回溯法;

public class 单词搜索_79 {
/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

	单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
	
	示例:
	
	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	
	给定 word = "ABCCED", 返回 true.
	给定 word = "SEE", 返回 true.
	给定 word = "ABCB", 返回 false.
 */
	
	/*private static int[][] shift = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static boolean[][] visited;
	private int m;
	private int n;

	public boolean exist(char[][] board, String word) {
	    if (word == null || word.length() == 0) return true;
	    if (board == null || board.length == 0 || board[0].length == 0) return false;
	    m = board.length;
	    n = board[0].length;
	    visited = new boolean[m][n];
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (dfs(board, word, 0, i, j)) return true;
	        }
	    }
	    return false;
	}

	private boolean dfs(char[][] board, String word, int start, int r, int c) {
	    //找到,返回
		if (start == word.length()) {
	        return true;
	    }
		//不满足条件,退出(当前的字母 !=所在路径的字母 || 已经被访问 )
	    if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(start) ||  visited[r][c] ) {
	        return false;
	    }
	    //设置为已经被访问
	    visited[r][c] = true;
	    for (int i = 0; i < shift.length; i++) {
	    	//进行上下左右访问
	        int nextR = r + shift[i][0];
	        int nextC = c + shift[i][1];
	        if (dfs(board, word, start + 1, nextR, nextC)) return true;
	    }
	    visited[r][c] = false; //重置,回溯
	    return false;
	}*/
	
	private int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
	private boolean[][] visited =null;
	private int m;
	private int n;
	public boolean exist(char[][] board, String word) {
		//word为0返回true
		if(word ==null || word.length() ==0) return true;
		//要查找的区域为0返回false
		if(board == null || board.length == 0 ||board[0].length ==0) return false;
		
		m = board.length; 
		n = board[0].length;
		
		visited =new boolean[m][n]; 
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//从0开始查找
				if (dfs(board, word, 0, i, j)) return true;
			}
			
		}
		return false;
	}
	private boolean dfs(char[][] board, String word, int start, int r, int c) {
		if(start == word.length()) {
			return true;
		}
		if(r<0 || r>=m || c<0 || c>=n || board[r][c] != word.charAt(start) || visited[r][c]) {
			return false;
		}
		visited[r][c] = true;
		for (int i = 0; i < direction.length; i++) {
			int nextR = r+ direction[i][0];
			int nextC = c+ direction[i][1];
			if(dfs(board, word, start+1, nextR, nextC)) return true;
		}
		visited[r][c] = false;
		
		return false;
	}
	
	public static void main(String[] args) {
		String str="";
  StringBuilder sb = new StringBuilder();

  
	}
}
