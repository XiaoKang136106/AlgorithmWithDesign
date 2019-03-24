package 剑指offer;

import java.util.LinkedHashMap;

public class _34第一个只出现一次的字符 {
	
		/*
		 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
		 * 如果没有则返回 -1（需要区分大小写）.
		 */
		//思路：利用LinkedHashMap保存字符和出现次数
	   public int FirstNotRepeatingChar(String str) {
		   
		   if (str == null || str.length() == 0)
			   return -1;
			   char[] c = str.toCharArray();//将字母转换后对应的数字
			   LinkedHashMap<Character,Integer> hash=new LinkedHashMap<Character,Integer>();
			   for(char item : c) {
			   if(hash.containsKey(item))
				   //将该数字作为key,vale为出现的次数存入
			   hash.put(item, hash.get(item)+1);
			   else
			   hash.put(item, 1);
			   } 
			   for(int i = 0;i < str.length(); i++){
				   //第一次,直接返回
			   if (hash.get(c[i]) == 1) {
			   return i;
			   }
			   }
			   return -1;
	    }

}
