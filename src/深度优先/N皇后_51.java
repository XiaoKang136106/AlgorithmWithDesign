package 深度优先;

import java.util.ArrayList;
import java.util.List;

public class N皇后_51 {
	/**
	 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

	八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：
	在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。 
	高斯认为有76种方案。1854年在柏林的象棋杂志上不同的作者发表了40种不同的解，
	后来有人用图论的方法解出92种结果。计算机发明后，有多种计算机语言可以解决此问题
		
		上图为 8 皇后问题的一种解法。
		
		给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
		
		每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
		
		示例:
		
		输入: 4
		输出: [
		 [".Q..",  // 解法 1
		  "...Q",
		  "Q...",
		  "..Q."],
		
		 ["..Q.",  // 解法 2
		  "Q...",
		  "...Q",
		  ".Q.."]
		]
		解释: 4 皇后问题存在两个不同的解法。
	 */
	 /*public List<List<String>> solveNQueens(int n) {
	        List<List<String>> res = new ArrayList<List<String>>();
	        int[] queenList = new int[n]; //第i个位置存放的数表示row行时，Q的列,表示i行是否为Q
	        placeQueen(queenList, 0, n, res);//在第0行放Q
	        return res;
	    }
	    private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
	        //如果已经填满，就生成结果
	        if (row == n) {
	            ArrayList<String> list = new ArrayList<String>();
	            for (int i = 0; i < n; i++) {
	                String str = "";
	                for (int col = 0; col < n; col++){
	                    if(queenList[i] == col) {
	                        str += "Q";
	                    } else {
	                        str += ".";
	                    }
	                }
	                list.add(str);
	            }
	            res.add(list);
	        }
	        for (int col = 0; col < n; col++) {//循环每一列
	            if (isValid(queenList, row, col)) { //如果在该列放入Q不冲突的话
	                queenList[row] = col;//放皇后
	                placeQueen(queenList, row + 1, n, res); //进行进行下一行校验
	            }
	        }
	    }
	    
	    private boolean isValid(int[] queenList, int row, int col) {
	        for (int i = 0; i < row; i++) {
	            int pos = queenList[i];
	            if (pos == col) { //和新加入的Q处于同一列
	                return false;
	            }
	            if (pos + row - i == col) { //在新加入的Q的右对角线上
	                return false;
	            }
	            if (pos - row + i == col) { //在新加入的Q的左对角线上
	                return false;
	            }
	        }
	        return true;
	    }
*/
	
	public List<List<String>> solveNQueens(int n) {
		//创建一个res
		List<List<String>> res = new ArrayList<List<String>>();
		//定义一个QueenList,索引为row ,值为列 ,也就是Q的位置
		int[] queenList = new int[n];
		//进行找皇后
		placeQueen(queenList,0,n,res); //从0行开始放皇后,n表示n行 * n列
		return res;
	}

	private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
		//如果到达最后一行,将结果输出
		if(row == n) {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				String str = "";
				for (int col = 0; col < n; col++) {
					//判断是否为皇后,索引为行,value为列
					if(queenList[i] ==col ) {
						str +="Q";
					}else {
						str+=".";
					}
					
				}
				//一行的数据
				list.add(str);
			}
			res.add(list);
		}
		//开始定义不同的方法,遍历col
		for (int col = 0; col < n; col++) {
			//进行校验该位置是否可以放皇后
			if(isValid(queenList,row,col)) {
				//将皇后放在当前位置
				queenList[row] =col;
				//递归去下一行找满足的条件
				placeQueen(queenList, row+1, n, res);
			}
		}
		
	}

	private boolean isValid(int[] queenList, int row, int col) {
		//遍历row,col固定,看看下面是否可以放皇后
		for (int i = 0; i < row; i++) {
			//获取皇后的位置
			int pos = queenList[i];
			if(pos == col) return false; //同一行
			
			if(pos+row - i == col) return false; //右对角线
		
			if(pos-row+i == col) return false; //左对角线 
		}
		
		return true;
	}
}
