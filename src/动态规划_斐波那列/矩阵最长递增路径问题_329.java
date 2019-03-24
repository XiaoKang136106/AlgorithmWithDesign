package 动态规划_斐波那列;

/*
	 * 题目描述：
	给定一个整数矩阵matrix，每个位置你可以向左、右、下、上移动，找到其中最长的递增路径。
	例如：
	matrix =
	[
	[9,9,4],
	[6,6,8],
	[2,1,1]
	]
	返回4
	最长路径是[1, 2, 6, 9].
	matrix = [
	[3,4,5],
	[3,2,6],
	[2,2,1]
	]
	返回4
	最长路径是[ 2, 4，5, 6]
	题目思路：
	本题可用三种方法： 暴力递归、记忆搜索、动态规划
 */
public class 矩阵最长递增路径问题_329 {
	/*
	 * 思路一： 直接暴力递归求解。
	 * 对于每一个位置上的数，其实有四种移动路线，即向上、下、左、右。移动时，只要保证向其他位置可移动（不越界，并保证下一个位置大于当前位置值）即可，
	 * 求出从当前位置出发的最长递增路径。 最终比较，求出所有位置的最长递增路径。
	 */
	public static int longest(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int max = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				max = Math.max(max, process(matrix, row, col)); // 获取总的最长递增路径
			}
		}
		return max;
	}

	private static int process(int[][] matrix, int row, int col) { // 求当前位置最长的递增路径
		int path = 1; // 原地不动的长度
		if (row > 0 && matrix[row - 1][col] > matrix[row][col]) { // 向上移动时
			path = Math.max(path, process(matrix, row - 1, col) + 1);
		}
		if (col > 0 && matrix[row][col - 1] > matrix[row][col]) { // 向左移动时
			path = Math.max(path, process(matrix, row, col - 1) + 1);
		}
		if (row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]) { // 向下移动时
			path = Math.max(path, process(matrix, row + 1, col) + 1);
		}
		if (col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]) { // 向右移动时
			path = Math.max(path, process(matrix, row, col + 1) + 1);
		}
		return path; // 返回当前位置的最长递增路径
	}

	/*
	 * 思路二： 记忆搜索方法 由于思路一的暴力递归求解过程中存在大量位置重复计算问题。
	 * 而记忆搜索是采用dp矩阵记录每一个位置是否在之前通过递归求解过。若已经求解过，只需要把上次的值直接拿过来即可。因此该思路创建的dp类似缓存栈的思想，
	 * 若该值缓存过，就不需要再计算了。
	 */
	public static int longestDP(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int max = 0;
		int dp[][] = new int[matrix.length][matrix[0].length]; // 缓存矩阵

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				max = Math.max(max, processDP(matrix, dp, row, col)); // 获取总的最长递增路径
			}
		}
		return max;
	}

	private static int processDP(int[][] matrix, int[][] dp, int row, int col) { // 求当前位置最长的递增路径
		if (dp[row][col] == 0) { // 若该值没有计算过，则计算当前最长递增路径
			dp[row][col] = 1; // 原地不动的长度
			if (row > 0 && matrix[row - 1][col] > matrix[row][col]) { // 向上移动时
				dp[row][col] = Math.max(dp[row][col], processDP(matrix, dp, row - 1, col) + 1);
			}
			if (col > 0 && matrix[row][col - 1] > matrix[row][col]) { // 向左移动时
				dp[row][col] = Math.max(dp[row][col], processDP(matrix, dp, row, col - 1) + 1);
			}
			if (row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]) { // 向下移动时
				dp[row][col] = Math.max(dp[row][col], processDP(matrix, dp, row + 1, col) + 1);
			}
			if (col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]) { // 向右移动时
				dp[row][col] = Math.max(dp[row][col], processDP(matrix, dp, row, col + 1) + 1);
			}
		}
		return dp[row][col]; // 返回当前位置的最长递增路径
	}

	/*
	 * 思路三：动态规划 采用动态规划的思想，使得时间复杂度降到o（m*n）
	 */
	public static int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int max = 0;
		int dp[][] = new int[matrix.length][matrix[0].length]; // 动归矩阵

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				// 要求当前位置的最长递增路径，需求当前位置往上下左右分别的最大递增路径。
				max = Math.max(max, maxIncrease(matrix, dp, row + 1, col, matrix[row][col]) + 1); // 下
				max = Math.max(max, maxIncrease(matrix, dp, row - 1, col, matrix[row][col]) + 1); // 上
				max = Math.max(max, maxIncrease(matrix, dp, row, col + 1, matrix[row][col]) + 1); // 右
				max = Math.max(max, maxIncrease(matrix, dp, row, col - 1, matrix[row][col]) + 1); // 左
			}
		}
		return max;
	}

	private static int maxIncrease(int[][] matrix, int[][] dp, int row, int col, int pre) { // 往当前方向走的最长递增路径
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] >= pre) {
			return 0;
		}

		if (dp[row][col] == 0) { // 当前位置没有计算过
			dp[row][col] = maxIncrease(matrix, dp, row + 1, col, matrix[row][col]) + 1;
			dp[row][col] = Math.max(dp[row][col], maxIncrease(matrix, dp, row, col + 1, matrix[row][col]) + 1);
			dp[row][col] = Math.max(dp[row][col], maxIncrease(matrix, dp, row - 1, col, matrix[row][col]) + 1);
			dp[row][col] = Math.max(dp[row][col], maxIncrease(matrix, dp, row, col - 1, matrix[row][col]) + 1);
		}
		return dp[row][col];
	}

}
