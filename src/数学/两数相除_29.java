package 数学;

public class 两数相除_29 {
	
	
	/*
	 * 思路:当被除数大于等于除数时(否则的话就为0了)，我们设置两个变量t和p，并分别初始化为除数和1(最小的情况)，
	 * 当被除数大于等于t的二倍时，将t和p同时扩大二倍(左移)，并将返回值加上p，除数减去t。
	 * 和二进制类似，例如29除以8，8扩大二倍，16小于29，再扩大二倍，超过29，于是29减去之前的16，返回值加上2。
	 * 第二次循环时因为此时的13小于8的二倍，故加上1，整个循环结束，最终结果为2+1=3，很明显符合。
	 * 此外注意判断结果正负号的正负号时亦或的作用
	 */
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){//考虑特殊情况
              return Integer.MAX_VALUE;
          }
          int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;//异或运算
          long ms = (long)dividend;
          long ns = (long)divisor;
          ms = Math.abs(ms);
          ns = Math.abs(ns);
          int num = 0;
          while(ms >= ns){
              long m = ns;
              long n = 1;
              while(ms >= (m << 1)){
                  m <<= 1;
                  n <<= 1;
              }
              num += n;
              ms -= m;
          }
          return num * sign;
      }
}
