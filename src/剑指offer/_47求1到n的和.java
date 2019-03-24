package 剑指offer;

public class _47求1到n的和 {
	/*
	 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
	 */
		//利用递归思想,利用Booelan短路运算符
	  public int Sum_Solution(int n) {
		  
		  int sum =n;
		  //终止条件n>0
		  Boolean result = (n>0) && ((sum += Sum_Solution(n-1))>0);
		  return sum;
	   }
}
