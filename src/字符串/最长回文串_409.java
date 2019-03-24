package 字符串;

public class 最长回文串_409 {
/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

	在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
	
	注意:
	假设字符串的长度不会超过 1010。
	
	示例 1:
	
	输入:
	"abccccdd"
	
	输出:
	7
	
	解释:
	我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
	//思路:超过2个的话偶数有多少个就需要多少个,为奇数的话,只要它的最大偶数部分 (cnt/2)*2<3只会取2,1为0,5为4> ret未满,中间还可以放一个数
	public int longestPalindrome(String s) {
	   /* int[] cnts = new int[128]; // ascii 码总共 128 个
	    for(char c : s.toCharArray()) cnts[c]++;
	    int ret = 0;
	    for(int cnt : cnts)  ret += (cnt / 2) * 2;
	    if(ret < s.length()) ret++; // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
	    return ret;*/
		 int[] cnt = new int[128];
	        int ret =0 ;
	        for(int i=0;i<s.length();i++)  cnt[s.charAt(i)]++;
	        for(int c:cnt){
	            
	            ret += (c/2)*2;
	        }
	        if(ret<s.length()) ret++;
	        return ret;
	}
	public static void main(String[] args) {
		最长回文串_409 最长回文串_409 = new 最长回文串_409();
		int i = 最长回文串_409.longestPalindrome("dccaccd");
		System.out.println(i);
	}
}
