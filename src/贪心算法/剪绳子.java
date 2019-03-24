package 贪心算法;
/*
 * 通过局部最优解来得到全局最优解
 * 1.将优化问题转换成这样一个问题，即先做出选择，再解决剩下的一个子问题。

　　2.证明原问题总是有一个最优解是贪心选择的得到的，从而说明贪心选择的安全。

　　3.说明在做出贪心选择后，剩下的子问题具有这样一个性质。即如果将子问题的最优解和我们所做的贪心选择联合起来，可以得到一个更加负责的动态规划解。
 */
public class 剪绳子 {

	/*
	 * 　　给你一个长度为n的绳子，请把绳子剪成m段（m，n都是整数，且都大于1）
	 * 	每段绳子的长度即为K[0],K[1],K[2]...K[m]。请问K[0]*k[1]..*k[m]可能的最大乘积是多少？
	 */
	/*
	 * 思路:如果我们按照如下的策略剪绳子,则得到的各段绳子的长度的乘积将最大;
	 * 当n>=5,我们尽可能地剪长度为3的绳子;当剩下的绳子长度为4时,把绳子剪为长度为2的绳子.
	 */

	public static int greedy_cut_rope_1(int n) {
		//n<2,无法进剪绳子
		if(n<2) {		
		  return 0;
		}
		
		if(n ==2) {
			return 1; //1*1
		}
		if(n == 3) {
			return 2; //1*2r
		}
		  //尽可能多地去减长度为3的绳子段
		int timesOf3 = n/3; //16 5
		//如果最后剩余的绳子的长度为4则吧绳子剪为长度为2
		if((n-timesOf3*3) == 1) {
			timesOf3-- ;
		}
		//如果剩余的长度为2等于1
		int timesOf2 = (n-timesOf3*3)/2;
		return (int)(Math.pow(3, timesOf3)*Math.pow(2, timesOf2));
	}
	
	//递归法
	public static int greedy_cut_rope(int n) {
		
		   	if(n==2)
		        return 2;
		    if(n==3)
		        return 3;
		    if(n<2)
		        return 0;
		    //int timesOf3 = n/3;
		    if(n==4)
		        return 4;
		    return 3*greedy_cut_rope(n-3);
	}
	public static void main(String[] args) {
		
		System.out.println(greedy_cut_rope_1(1));
		System.out.println(greedy_cut_rope(1));
	
		
		
	}
}
