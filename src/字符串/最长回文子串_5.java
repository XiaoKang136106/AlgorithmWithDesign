package 字符串;

public class 最长回文子串_5 {
	
	
	 public String longestPalindrome(String str) {
		    if (str == null || str.length() < 1) return "";
		 int start =0;
		 int end =0;
		 for(int i=0;i<str.length();i++) {
			 
			 int len1=expandAroundCenter(str,i,i);
			 int len2=expandAroundCenter(str,i,i+1);
			 int len =Math.max(len1, len2);
			 if(len>end-start) {
				 start=i-(len-1)/2;
				 end=i+len/2;
			 }
		 }
		 return str.substring(start, end+1);
		 
	 }

	private int expandAroundCenter(String str, int l, int r) {
		
		while(l>=0&&r<str.length()&&str.charAt(l)==str.charAt(r)){
			l--;
			r++;
		}
		
		return r-l-1;
	}

}
