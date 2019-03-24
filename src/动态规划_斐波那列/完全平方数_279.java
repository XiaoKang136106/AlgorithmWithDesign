package 动态规划_斐波那列;

import java.util.ArrayList;
import java.util.List;

public class 完全平方数_279 {
	/**
	 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

	示例 1:
	
	输入: n = 12
	输出: 3 
	解释: 12 = 4 + 4 + 4.
	示例 2:
	
	输入: n = 13
	输出: 2
	解释: 13 = 4 + 9.
	 * 
	 */
	public int numSquares(int n) {
	/*    List<Integer> squares = new ArrayList<>(); // 存储小于 n 的平方数
	    int diff = 3;
	    int square=1;
		while(square <= n) {
	        squares.add(square);
	        square += diff; //1+3+5+7+.........
	        diff += 2;	
	    }
	    int[] dp = new int[n + 1];//定义一个比n大1的数组
	    //遍历
	    for(int i = 1; i <= n; i++) {
	        int max = Integer.MAX_VALUE; //最大数
	        for(int s : squares) {
	            if(s > i) break;
	            max = Math.min(max, dp[i - s] + 1);
	        }
	        dp[i] = max;
	        System.out.println(dp[i]);
	    }
	    return dp[n];*/
		//从1开始,value为nums[i]最多的个数,比如:4=1+1+1+1,最多4个
		 int[] nums = new int[n+1];
	        for(int i=1; i<=n; i++) nums[i] = i;
	        //从2开始DP
	        for(int i=2; i<=n; i++) {
	            for(int j=1; j*j<=i; j++) {
	            	//nums[i]=   i上的值和1+(i-j*j)的值 的最小值
	                nums[i] = Math.min(nums[i], nums[i-j*j]+1);
	            }
	        }
	        //最终返回nums[n]
	        return nums[n];
	    
	}
	//对于要求的当前节点而言都是从前面的节点转移过来的，只是这些转移节点并非一个，
	//而是多个，比如1*1，2*2，3*3，，，那么相应的res[i-1]、res[i-4]、res[i-9]等等都是转移点。
	//从这些候选项中找到最小的那个，然后加1即可。
	public static void main(String[] args) {
		完全平方数_279 完全平方数_279 = new 完全平方数_279();
		完全平方数_279.numSquares(13);
	}
}
