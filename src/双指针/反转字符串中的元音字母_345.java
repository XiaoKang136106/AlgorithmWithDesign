package 双指针;

import java.util.Arrays;
import java.util.HashSet;

public class 反转字符串中的元音字母_345 {
	/*
	 * 345
	 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

		示例 1:
		
		输入: "hello"
		输出: "holle"
		示例 2:
		
		输入: "leetcode"
		输出: "leotcede"
		说明:
		元音字母不包含字母"y"。

	 * 大小写 的 a e i o u(A E I O U) 都是元音字母,为元音字母的话前后2个元音字母就进行交换
	 */
	private HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

	public String reverseVowels(String s) {
	    if(s.length() == 0) return s;
	    int i = 0, j = s.length() - 1; //定义前后指针
	    char[] result = new char[s.length()];//定义字符数组
	    while(i <= j){
	        char ci = s.charAt(i);
	        char cj = s.charAt(j);
	        //前指针的数不为元音字符
	        if(!vowels.contains(ci)){
	            result[i] = ci;//赋值
	            i++;
	        } else if(!vowels.contains(cj)){
	            result[j] = cj;//赋值
	            j--;
	        } else{
	        	//前后指针位置上都为元音字符,进行交换字符
	            result[i] = cj;
	            result[j] = ci;
	            i++;
	            j--;
	        }
	    }
	    return new String(result);
	}
	
	//方法二-----------------------------------------
    public String reverseVowels2(String s) {
        if(s == "" || s==null)
            return s;
        int i = 0,j = s.length() - 1;
        char[] str = s.toCharArray();
        while(i < j){
            while(i < j && !judgeVowel(str[i]))
                i++;
            while(i < j && !judgeVowel(str[j]))
                j--;
            if(i < j){
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }
        }
        return new String(str);
    }
    public boolean judgeVowel(char c){
        return c == 'a' | c == 'e' | c == 'i' | c == 'o' | c == 'u' |
               c == 'A' | c == 'E' | c == 'I' | c == 'O' | c == 'U';
    }
	

}
