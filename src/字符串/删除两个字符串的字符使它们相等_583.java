package 字符串;

public class 删除两个字符串的字符使它们相等_583 {
/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。

	示例 1:
	
	输入: "sea", "eat"
	输出: 2
	解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
	说明:
	
	给定单词的长度不超过500。
	给定单词中的字符只含有小写字母。
	 * 
 * 
 */
	
	/*
	 * 而最大公共子序列，可以通过动态规划来求。首先，设word1中各个字符为s1,s2,……,sm，word2中各个字符为为t1,t2,……tn。而最大公共子序列为z1,z2……zk。

		若sm=tn，明显则有zk=sm=tn，所以s1,s2,……,sm-1与t1,t2,……tn的最大公共子序列就为z1,z2……zk-1。
		
		若sm≠tn，如果zk=sm，则z1,z2……zk是s1,s2,……,sm与t1,t2,……tn-1的最大公共子序列；
		同理若zk=tn，则z1,z2……zk是s1,s2,……,sm-1与t1,t2,……tn的最大公共子序列。
		根据以上的规律，可以得出如下结论：
		
		设dp[i][j]等于word1前i位与word2前j位的最大公共子序列长度。
		
		当i=0或j=0，dp[i][j]=0；
		
		当i>0且j>0，若word1[i]=word2[j],dp[i][j]= dp[i-1][j-1]+1;
		
		当i>0且j>0，若word1[i]≠word2[j]，dp[i][j]=max（dp[i][j-1]，dp[i-1][j]）
		
		根据以上便可得出最大公共子序列的长度，然后得出题目最终结果
	 */
	public int minDistance(String word1, String word2) {
	    int m = word1.length(), n = word2.length();
	    //dp的值表示匹配到的长度,dp[0][2]表示word1的0索引开始和word2的2索引开始匹配到相同的最大公共子序列
	    //字符串长度为3可能有0,1,2,3种情况
	    int[][] dp = new int[m + 1][n + 1];
	    /*
	     * x x x x
	     * x x x x
	     * x x x x
	     * x x x x
	     */
	    for (int i = 1; i <= m; i++) {
	        for (int j = 1; j <= n; j++) {
//	            dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1
//	                    : Math.max(dp[i][j - 1], dp[i - 1][j]);
	            if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
	                   dp[i][j]=dp[i-1][j-1]+1;
	               }else{
	                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
	               }
	            System.out.print(dp[i][j]);
	            System.out.println("......"+i+"....."+j);
	        }
	    }
	    return m + n - 2 * dp[m][n];
	}
	
	public static void main(String[] args) {
		
		删除两个字符串的字符使它们相等_583 a = new 删除两个字符串的字符使它们相等_583();
		a .minDistance("sea", "eat");
	}
}
