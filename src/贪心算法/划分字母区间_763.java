package 贪心算法;

import java.util.ArrayList;
import java.util.List;

public class 划分字母区间_763 {
	/*
	 * 763
	 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
		
		示例 1:
		
		输入: S = "ababcbaca defegde hijhklij"
		输出: [9,7,8]
		解释:
		划分结果为 "ababcbaca", "defegde", "hijhklij"。
		每个字母最多出现在一个片段中。
		像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
		注意:
		
		S的长度在[1, 500]之间。
		S只包含小写字母'a'到'z'。
	 */
	
	public List<Integer> partitionLabels(String S) {
		  List<Integer> ret = new ArrayList<>();
		    int[] lastIdxs = new int[26]; //定义一个26个字母的数组
		    for(int i = 0; i < S.length(); i++) lastIdxs[S.charAt(i) - 'a'] = i; //数组里面的值表示该字母最后出现的索引
		    int startIdx = 0;
		    while(startIdx < S.length()) {
		    	//假设起始的索引为结束的索引
		        int endIdx = startIdx;
		        //划分结果为 "ababcbaca", "defegde", "hijhklij"
		        for(int i = startIdx; i < S.length() && i <= endIdx; i++) {
		        	//该字母最后面的一个索引
		        	int lastIdx = lastIdxs[S.charAt(i) - 'a'];
		            //找到只出现一次的字母,退出当前循环继续找
		        	if(lastIdx == i) continue;
		        	//最后的索引大于结束索引,需要贪心
		            if(lastIdx > endIdx) endIdx = lastIdx;
		        }
		        ret.add(endIdx - startIdx + 1);
		        startIdx = endIdx + 1; //开始下一轮遍历
		    }
		    return ret;
    }
	
	
	public List<Integer> partitionLabels2(String S) {
	
		List<Integer> ret = new ArrayList<Integer>();
		//定义一个26个字母的数组
		int[] lastIdxs = new int[26];
		for (int i = 0; i < S.length(); i++) {
			lastIdxs[S.charAt(i)-'a'] =i; //最终所有的不重复的字母与都在lastIdxs中 
		}
		int startIdx=0;
		while(startIdx < S.length()) {
			int endIdx= startIdx;
			for(int i = startIdx; i < S.length() && i <= endIdx; i++) {
	        	//最后面的一个索引
	        	int lastIdx = lastIdxs[S.charAt(i) - 'a']; //顺序
	            
	        	if(lastIdx == i) continue;
	        	//
	            if(lastIdx > endIdx) endIdx = lastIdx; //把顺序赋给结束的位置
	        }
	        ret.add(endIdx - startIdx + 1);
	        startIdx = endIdx + 1; //开始下一轮遍历
		}
		return ret;
	}
}
