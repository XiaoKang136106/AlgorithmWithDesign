package 背包问题;

import java.util.List;

public class 字符串按单词列表分割_139 {
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
