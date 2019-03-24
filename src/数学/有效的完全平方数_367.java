package 数学;

import java.util.Scanner;

public class 有效的完全平方数_367 {
	/**
	 * 
		给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
		
		说明：不要使用任何内置的库函数，如  sqrt。
		
		示例 1：
		
		输入：16
		输出：True
		示例 2：
		
		输入：14
		输出：False
	 */
	//平方序列：1,4,9,16,.. 间隔：3,5,7,...
	public boolean isPerfectSquare(int num) {
		Scanner sc = new Scanner(System.in);

		int subNum = 1;
	    //4-1-3
		//16-1-3-5-7
		while (num > 0) {
	    
			num -= subNum;
	        
			subNum += 2;
	    }
		
	    return num == 0;
	}

}
