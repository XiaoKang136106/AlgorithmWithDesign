package 剑指offer;

public class _52正则表达式匹配 {

	/*
	 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
	 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
	 * 在本题中，匹配是指字符串的所有字符匹配整个模式。 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
	 */
	/*
	 * 思路：当字符串只有一个字符时，进行判断，否则就有两种递归情况，
	 * （1）当Pattern中的第二个字符不是“*”时：aaa a*a
	 * 如果字符串第一个字符和模式中的第一个字符相匹配或是点,那么字符串和模式都后移一个字符，然后匹配剩余 的；
	 * 如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
	 * （2）当Pattern中的第二个字符是“*”时：
	 * 如果字符串第一个字符跟模式第一个字符不匹配，则Pattern后移2个字符，继续匹配； a.a ab*a
	 * 如果字符串第一个 字符跟Pattern第一个字符匹配 ||   "." ，可以有3种匹配方式：.*
	 * 1 >Pattern后移2字符，相当于x*被忽略(*=0)；ab ,  .*ab 
	 * 2>字符串后移1字符，Pattern后移2字符("."代表那个字符)；
	 * 3>字符串后移1字符，Pattern不变，即继续匹配字符下一位，因为* 可以匹配多位；(用于判断下一个字符是否和上一个字符相同)
	 */
	public boolean match(char[] str, char[] pattern) {

		if (str == null || pattern == null)
			return false;
		// 若字符串的长度为1
		if (str.length == 1) {
			// a a |.
			if (pattern.length == 1) {
				if (str[0] == pattern[0] || pattern[0] == '.')
					return true;
				return false;
			}
		}
		int sindex = 0;
		int pindex = 0;
		return matchIndex(str, sindex, pattern, pindex);
	}

	public boolean matchIndex(char[] str, int sindex, char[] pattern, int pindex) {
		// str和pattern同时到达末尾，则匹配成功
		if (sindex == str.length && pindex == pattern.length)
			return true;
		// 若pattern先到尾，而str没有到达末尾，则匹配失败
		if (sindex != str.length && pindex == pattern.length)
			return false;
		// 若pattern第二个字符是*
		if (pindex + 1 < pattern.length && pattern[pindex + 1] == '*') {
			//判断前一个字符是否相等 或者  =='.'
			if (sindex != str.length && pattern[pindex] == str[sindex]
					|| sindex != str.length && pattern[pindex] == '.') {
				//三种情况1.'*'代表1,只匹配一个数字sindex+1,pindex+2,
				//		  2. '*'代表0,不匹配,pindex索引+2
				//		  3. 判断sindex后面的数字是否还可以和'*'匹配,sindex+1
				return matchIndex(str, sindex + 1, pattern, pindex + 2) || matchIndex(str, sindex, pattern, pindex + 2)
						|| matchIndex(str, sindex + 1, pattern, pindex);
			} else {
				//不匹配说明'*'代表0,不匹配数字,索引+2
				return matchIndex(str, sindex, pattern, pindex + 2);
			}
		}
		// 若pattern第二个字符不是*,相等或者为'.',继续比较下一个字符
		if (sindex != str.length && pattern[pindex] == str[sindex] || sindex != str.length && pattern[pindex] == '.')
			return matchIndex(str, sindex + 1, pattern, pindex + 1);
		return false;
	}

}
