package 贪心算法;
/*
	 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
	
	你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
	
	字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
	
	示例 1:
	s = "abc", t = "ahbgdc"
	
	返回 true.
	
	示例 2:
	s = "axc", t = "ahbgdc"
	
	返回 false.
 */

public class 判断子序列_392 {
	//遍历s,利用indexOf()函数判断自己的字符是否在t存在,如果不存在会返回-1;
	public boolean isSubsequence(String s, String t) {
//indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，
//如果此字符串中没有这样的字符，则返回 -1。
		//pos的目标主要是为了防止每次从0开始向后查找,提高性能
	    for (int i = 0, pos = 0; i < s.length(); i++, pos++) {
	        pos = t.indexOf(s.charAt(i), pos);
	        if(pos == -1) return false;
	    }	
	    return true;
	}

}
