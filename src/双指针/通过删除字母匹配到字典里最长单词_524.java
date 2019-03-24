package 双指针;

import java.util.List;

public class 通过删除字母匹配到字典里最长单词_524 {
	
	/*
	 * 
	 * 
	 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
	 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

		示例 1:
		
		输入:
		s = "abpcplea", d = ["ale","apple","monkey","plea"]
		
		输出: 
		"apple"
		示例 2:
		
		输入:
		s = "abpcplea", d = ["a","b","c"]
		
		输出: 
		"a"
	 */
	//思路:可以删除 s 中的一些字符，使得它成为字符串列表 d 中的一个字符串。要求在 d 中找到满足条件的最长字符串
	
	
		public String findLongestWord2(String s, List<String> d) {
	        String ret ="";
	        
	        for (String str : d) {
	        	
	        	for(int i=0,j=0;i<s.length() && j<str.length();i++) {
	        		
	        		if(s.charAt(i) == str.charAt(j)) j++;
	        		//如果j已经到了str的最后一个位置了,说明包含在s中
	        		if(j == str.length()) {
	        			
	        			//判断是否需要赋值给ret
	        			//小于直接取赋值,相等,则使用string.compareTo进行比较(返回长度最长且字典顺序最小的字符串)
	        			if(ret.length()<str.length() || (ret.length() == str.length() && ret.compareTo(str)>0)) {
	        				
	        				ret = str;
	        			}
	        		}
	        		
        	}
        	
		}
        return ret;
		
		
		
		
}
	
}
