package 字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串_3 {
	/*
	 * 题目描述
	输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
	例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
	
	动态规划，用f(i)表示以i个字符结尾不包含重复子字符串的最长长度，从左向右扫描

1、若第i个字符在之前没出现过，则 f(i) = f(i-1) + 1;

2、若第i个字符在之前出现过，

计算第i个字符距离上次出现之间的距离为d

(a)若d <= f(i-1)，则说明第i个字符上次出现在f(i-1)对应的不重复字符串之内，那么这时候更新 f(i) = d

(b)若d > f(i-1)，则无影响,f(i) = f(i-1) + 1

例如arabcacfr

f(0) =1,  a

f(1) = 2,  ar

f(2)  = 2,  ra，因为d=2，f(1)=2，所以上一个a在f(1)之中

f(3) = 3,  rab

f(4) = 4,  rabc

f(5) = 3,  bca，因为d=3，f(1)=4，所以上一个a一定在f(4)中

f(6) = 2,  ac

f(7) = 3,  acf

f(8) = 4,  acfr，因为d=7,f(7)=3,因此上一个r不在f(7)中，f(8) = f(7) + 1
	 */
	
	public int longestSubStringWithoutDuplication(String str) {
	    int curLen = 0;		//临时的不重复的当前长度
	    int maxLen = 0;  //最大长度
	    int[] preIndexs = new int[26];//用于保存当前字母最近出现的位置
	    Arrays.fill(preIndexs, -1);
	    for (int curI = 0; curI < str.length(); curI++) {
	        int c = str.charAt(curI) - 'a';//获取当前字母所表示的索引
	        int preI = preIndexs[c];//获取当前字母最近出现的索引
	        //不没出现过或者d>f(i-1)
	        if (preI == -1 || curI - preI > curLen) {
	            curLen++;
	        } else {
	        	//若d <= f(i-1)，则说明第i个字符上次出现在f(i-1)对应的不重复字符串之内，那么这时候更新 f(i) = d
	            maxLen = Math.max(maxLen, curLen);
	            curLen = curI - preI;//curLen=d;
	        }
	        preIndexs[c] = curI;
	    }
	    maxLen = Math.max(maxLen, curLen);
	    return maxLen;
	}

	public int longestSubStringWithoutDuplication2(String str) {
		
		int curLen =0;
		int maxLen=0;
		int[] preIndex = new int[26];
		Arrays.fill(preIndex, -1);
		for(int i=0;i<str.length();i++) {
			int c = str.charAt(i)-'a';
			int preI = preIndex[c];//获取当前字母最近出现的索引
			if(preIndex[c]==-1 || (i-preI)>curLen) {
				curLen++;
			}else {
				maxLen=Math.max(maxLen, curLen);
				curLen = i - preI;
			}
			  preIndex[c] = i;
		}
	    maxLen = Math.max(maxLen, curLen);
		return maxLen;
	}
	
	public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	    	//arabcacfr
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	        	//是否包含a
	            if (map.containsKey(s.charAt(j))) {
	            	//
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }
	
	     
	}
}
