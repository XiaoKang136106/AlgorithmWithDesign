package 剑指offer;

public class _43左旋转字符串 {

	//例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
		//思路:拼接或反转三次字符串
		//利用来sb拼接,先判断n>size,所以需要将n取模进行处理
	   public String LeftRotateString(String str,int n) {
	        if(str.isEmpty())
	        	return "";
	        if(n<0)
	        	return "";
	        int size =str.length();
	        n = n% size;
	        String str1 = str.substring(0, n);
	        String str2 = str.substring(n, size);
	        StringBuilder sb = new StringBuilder();
	        sb.append(str2).append(str1);
	        return sb.toString();
	   }
}
