package 数学;

public class _3的幂_326 {
	
	/**
	 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
		3*3*3
		示例 1:
		
		输入: 27
		输出: true
		示例 2:
		
		输入: 0
		输出: false
		示例 3:
		
		输入: 9
		输出: true
		示例 4:
		
		输入: 45
		输出: false
	 */
	public boolean isPowerOfThree(int n) {
		int num =n;
		
		while(num>0 && num%3==0) {
			num=num/3;
		}
		
		return num==1;
	}

}
