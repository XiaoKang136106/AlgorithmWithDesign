package 剑指offer;

public class _07斐波那契数列 {
	/*
	 * 斐波那契数列
	 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
		n<=39
	 */
	//思路:斐波那契数列 1,1,2,3,5,8....,定义二个起始值,第0项为0,第1项为1,..从2开始遍历
    public int Fibonacci(int n) {
    	//
        int result = 0;
         int preOne= 0;
         int preTwo=1;
        if(n ==0) {
            return preOne;
        }
        if(n == 1) {
            return preTwo;
        }
        for(int i=2;i<=n;i++) {
            result = preOne +preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
          
     }

}
