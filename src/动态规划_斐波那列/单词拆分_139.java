package 动态规划_斐波那列;

import java.util.List;

public class 单词拆分_139 {
/*
 * 
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */
	//【笔记】动态规划。dp[i]表示字符串s的前i个字符能否拆分成wordDict。
	public boolean wordBreak(String s, List<String> wordDict) {
        
		int len = s.length();
		//len+1
		//dp[i]表示前i个字符能不能被dict完美划分
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		for (int i = 1; i <= len; i++)
			for (int j = 0; j < i; j++) {
				// 注意substring是前闭后开
				String tmp = s.substring(j, i);
				//能否组合出f[i]表示的子串，k表示组合中前半段的
				if (dp[j] && wordDict.contains(tmp)) {
					dp[i] = true;
					break;
				}
			}
	        return dp[len];
	    }
}
