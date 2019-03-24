package 字符串;

public class 比特位计数_338 {
	/**
	 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

		示例 1:
		
		输入: 2
		输出: [0,1,1]
		示例 2:
		
		输入: 5
		输出: [0,1,1,2,1,2]
	 * 
	 * 
	 * 
	 */
	//6(110) 可以看成是2(10)加上一个1, 5(101)
	 public int[] countBits(int num) {
	        int[] ret = new int[num + 1];
	        for(int i = 1; i <= num; i++){
	        	//i&(i-1)为是否为2的指数
	            ret[i] = ret[i&(i-1)] + 1;
	        }
	        return ret;
	    }
	 
	 
	 public static void main(String[] args) {
		 
		System.out.println(6&5);
		
	 }

}
