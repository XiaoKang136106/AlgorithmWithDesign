package 字符串;

public class 有效的字母异位词_242 {
/**
 * 两个字符串包含的字符是否完全相同
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
	
	示例 1:
	
	输入: s = "anagram", t = "nagaram"
	输出: true
	示例 2:
	
	输入: s = "rat", t = "car"
	输出: false
	你可以假设字符串只包含小写字母。
 */
	public boolean isAnagram(String s, String t) {
		//定义一个26个字母的数组
	    int[] cnts = new int[26];
	    //遍历s,获取上面字母的索引,根据字母的位置进行++
	    for(int i  = 0; i < s.length(); i++) cnts[s.charAt(i) - 'a'] ++;
	    //遍历t,获取上面字母的索引,根据字母的位置进行--
	    for(int i  = 0; i < t.length(); i++) cnts[t.charAt(i) - 'a'] --;
	    for(int i  = 0; i < 26; i++) if(cnts[i] != 0) return false;
	    return true;
	}
}
