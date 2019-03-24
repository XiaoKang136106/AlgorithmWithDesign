package 字符串;

public class 同构字符串_205 {
/**
 * 
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，
但字符可以映射自己本身。
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.
 */
	//思路:定义2个数组都为256,索引为该单词的字母,value为出现的次数,将其中的一个单词遍历,根据value来判断,是否相同,相同则当前索引+1(保证唯一性),不相同返回false
	public boolean isIsomorphic(String s, String t) {
		//定义2个占一个字节的数组
	    int[] m1 = new int[256];
	    int[] m2 = new int[256];
	    for(int i = 0; i < s.length(); i++){
	        if(m1[s.charAt(i)] != m2[t.charAt(i)]) {
	            return false;
	        }
	        //只有在相同的位置,并且出现的次数一样才可以
	        m1[s.charAt(i)] = i + 1;
	        m2[t.charAt(i)] = i + 1;
	    }
	    return true;
	}
}
