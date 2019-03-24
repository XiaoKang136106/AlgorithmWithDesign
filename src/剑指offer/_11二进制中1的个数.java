package 剑指offer;

public class _11二进制中1的个数 {
	/*
	 * 二进制中1的个数 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 */
	  //思路:n-1会吧从最右边的1开始向右的数全部取相反数,在进行和n&运算,就变成0了
	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}

		return count;

	}
}
