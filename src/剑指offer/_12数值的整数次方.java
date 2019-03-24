package 剑指offer;

public class _12数值的整数次方 {
	/*
	 * 数值的整数次方
	 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
	 */
	/*
	 * 思路:需要考虑2种情况,exponent为正数,exponent为负数,
                            负数的时候3.3^-3 等于(1/3)^3.3
	 */
	   public double Power(double base, int exponent) {
			if(base == 0.0) {
				return 0.0;
			}
			if(exponent ==0) {
				return 1.0;
			}
			double sum =1.0;
			if(exponent>0) {
				for(int i=1;i<=exponent;i++) {
					sum = sum*base;
				}
				
			}else {
				for(int i=1;i<=-exponent;i++) {
					sum = sum*(1/base);
				}
			}
			
			return sum;
	  }

}
