package 二进制;

public class 最大单词长度乘积_318 {
/**
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母
 * 。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。

	示例 1:
	
	输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
	输出: 16 
	解释: 这两个单词为 "abcw", "xtfn"。
	示例 2:
	
	输入: ["a","ab","abc","d","cd","bcd","abcd"]
	输出: 4 
	解释: 这两个单词为 "ab", "cd"。
	示例 3:
	
	输入: ["a","aa","aaa","aaaa"]
	输出: 0 
	解释: 不存在这样的两个单词。
 */
	//思路:	26位的字符使用一个int就可以保存了,a=1 b表示10,c表示100....同理,abc=111,并且还可以去重,不用管顺序
	//
	
	public int maxProduct(String[] words) {
	    int n = words.length;//获取有多少个单词
	    if (n == 0) return 0;
	    
	    int[] val = new int[n];
	    //遍历每个单词
	    for (int i = 0; i < n; i++) {
	    	//遍历每个单词的字符
	        for (char c : words[i].toCharArray()) {
	        	/*
	        	 * 先是a ==> 1,然后拿a的编码去位或b(10),再去位或c(100),其实就是一个加法：
	        	 * a +b + c ==> 111，但是又不是简单的加法，因为这个只记录出现的字符一次。如果是aaa,就不能写成a+a+a = 2 ==> 10，表示的就是b了。
	        	 * 这也是为什么这里一定用的是位或运算的原因。
	        	 * z=各种相加字母相加
	        	 */
	            val[i] |= 1 << (c - 'a');
	        }
	    }
	    int ret = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = i + 1; j < n; j++) {
	        	//不相同,才求最大乘积.
	            if ((val[i] & val[j]) == 0) {
	                ret = Math.max(ret, words[i].length() * words[j].length());
	            }
	        }
	    }
	    return ret;
	}	
}
