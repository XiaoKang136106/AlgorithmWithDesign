package 双指针;

public class 验证回文字符串Ⅱ_680 {
	/*

	 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

		示例 1:
		
		输入: "aba"
		输出: True
		示例 2:
		
		输入: "abca"
		输出: True
		解释: 你可以删除c字符。
		注意: 

		字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
	 */
		//思路:删除一个字符前面指针的i+1等于j 或者 后面指针 的j-1 等于 i满足一个就为回文字符
	 public boolean validPalindrome(String s) {
	        int i=0; int j = s.length()-1; //定义前后2个指针
	        //开始遍历
	        while(i<j) {
	        	if(s.charAt(i) != s.charAt(j)) {
	        		//不相等(删除前面,或者删除后面的继续进行回文判断)进行判断前面指针的i+1等于j 或者 后面指针 的j-1 等于 i满足一个就为回文字符
	        		return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
	        	}
	        	i++;
	        	j--;
	        }	
	        
	        return true;
	        
	        
	    }

	private boolean isPalindrome(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}

}
