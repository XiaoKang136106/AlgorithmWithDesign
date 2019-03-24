package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合_17 {
/*
 * Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
	
	//KEYS表示从0开始上面的字母
	private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
	    List<String> ret = new ArrayList<>();
	    //digits为"",也可以进去方法
	    if (digits != null && digits.length() != 0) {
	    	//从digits的索引开始
	        combination("", digits, 0, ret);
	    }
	    return ret;
	}

	private void combination(String prefix, String digits, int offset, List<String> ret) {
	   //达到字母组合的长度,添加并返回
		if (offset == digits.length()) {
	        ret.add(prefix);
	        return;
	    }
	    //判断该数字的字母为哪几个
	    String letters = KEYS[digits.charAt(offset) - '0'];
	    //遍历第一个字母的长度
	    for (char c : letters.toCharArray()) {
	        combination(prefix + c, digits, offset + 1, ret);
	    }
	}
}
