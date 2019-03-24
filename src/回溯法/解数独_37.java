package 回溯法;

public class 解数独_37 {
/**
 * 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

	数字 1-9 在每一行只能出现一次。
	数字 1-9 在每一列只能出现一次。
	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
	空白格用 '.' 表示。
 * 
 * 
 * 对每一个还没填充的格子，尝试1~9这9个数字，如果是合法的，则继续填充下一个格子，否则回溯。 
判断合法：只需要判断对应行、对应列、对应3*3，有没有矛盾。

设未被填充的格子个数为n，那么时间复杂度大约为O(9n+1)=O(9n)O(9n+1)=O(9n)

 https://blog.csdn.net/wmdshhz0404/article/details/53558414(推荐使用这种解法)
 */
	
	
	
	//不会跳过
	private boolean[][] rowsUsed = new boolean[9][10];
	private boolean[][] colsUsed = new boolean[9][10];
	private boolean[][] cubesUsed = new boolean[9][10];
	private char[][] board;

	public void solveSudoku(char[][] board) {
	    this.board = board;
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            if (board[i][j] == '.') continue;
	            //获取上面的值
	            int num = board[i][j] - '0';
	            rowsUsed[i][num] = true;
	            colsUsed[j][num] = true;
	            cubesUsed[cubeNum(i, j)][num] = true;
	        }
	    }
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            backtracking(i, j);
	        }
	    }
	}

	private boolean backtracking(int row, int col) {
	    while (row < 9 && board[row][col] != '.') {
	        row = col == 8 ? row + 1 : row;
	        col = col == 8 ? 0 : col + 1;
	    }
	    if (row == 9) {
	        return true;
	    }
	    for (int num = 1; num <= 9; num++) {
	        if (rowsUsed[row][num] || colsUsed[col][num] || cubesUsed[cubeNum(row, col)][num]) continue;
	        rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = true;
	        board[row][col] = (char) (num + '0');
	        if (backtracking(row, col)) return true;
	        board[row][col] = '.';
	        rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = false;
	    }
	    return false;
	}

	private int cubeNum(int i, int j) {
	    int r = i / 3;
	    int c = j / 3;
	    return r * 3 + c;
	}
	
	
}
