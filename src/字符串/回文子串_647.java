package 字符串;

public class 回文子串_647 {
	/**
	 * 
		给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
		
		具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
		
		示例 1:
		
		输入: "abc"
		输出: 3
		解释: 三个回文子串: "a", "b", "c".
		示例 2:
		
		输入: "aaa"
		输出: 6
		说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
	 */
	private int cnt = 0; //全局个数
	//回文字符串有奇数个字符时，当前i位置字母作为回文字符串的中心；有偶数个字符的时候当前i和i+1位置字母作为回文字符串的中心。
	public int countSubstrings(String s) {
	    for(int i = 0; i < s.length(); i++) {
	    	//要为回文字符,i一定是中心点
	        extendSubstrings(s, i, i);    // 为奇数的情况, a a a 
	        extendSubstrings(s, i, i + 1); // 为偶数的情况  a a a a 
	    }
	    return cnt;
	}

	private void extendSubstrings(String s, int start, int end) {
	    while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
	        start--;
	        end++;
	        cnt++;
	    }
	}
}
