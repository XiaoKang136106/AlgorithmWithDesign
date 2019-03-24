package 双指针;

public class 平方数之和_633 {
	/*
	 * 633
	 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。

		示例1:
		
		输入: 5
		输出: True
		解释: 1 * 1 + 2 * 2 = 5
		 
		
		示例2:
		
		输入: 3
		输出: False
	 * 
	 */
	
	   public boolean judgeSquareSum(int c) {
	        int left =0; int right = (int) Math.sqrt(c);
	        
	        while(left <= right) {
	        	
	        	int powSum = left * left + right * right;
	        	if(powSum == c) {
	        		return true;
	        	}else if(powSum > c) {
	        		right --;
	        	}else {
	        		left++;
	        	}
	        
	        }
	        
	        return false;
	    }

}
