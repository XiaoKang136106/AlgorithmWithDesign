package 其他问题;

import java.util.Arrays;

public class 最长数对链_646 {
/**
 * 	给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。

	现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
	
	给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
	
	示例 :
	
	输入: [[1,2], [2,3], [3,4]]
	输出: 2
	解释: 最长的数对链是 [1,2] -> [3,4]
	注意：

	给出数对的个数在 [1, 1000] 范围内。
	
	对于 (a, b) 和 (c, d) ，如果 b < c，则它们可以构成一条链。
 */
	/*
	 * dp[i]储存的是从i结束的链表长度最大值。首先初始化每个dp[i]为1。然后对于每个dp[i]，找在 i 前面的索引 0~j，
	 *  如果存在可以链接在i 前面的数组，且加完后大于dp[i]之前的值，那么则在dp[j]的基础上+1.
	 */
	public int findLongestChain(int[][] pairs) {
	    if(pairs == null || pairs.length == 0) {
	        return 0;
	    }
	    Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
	    int n = pairs.length;
	    int[] dp = new int[n];
	    //填充,将dp数组都填充1
	    Arrays.fill(dp, 1);
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < i; j++) {
	            if(pairs[i][0] > pairs[j][1]){
	                dp[i] = Math.max(dp[i], dp[j] + 1);
	            }
	        }
	    }

	    int ret = 0;
	    for(int num : dp) {
	        ret = Math.max(ret, num);
	    }
	    return ret;
	}
}
