package 字符串;

public class 判断一个整数是否是回文数_9 {
	//思路:获取每个位置的值
	/*
	 * 要求不能使用额外空间，也就不能将整数转换为字符串进行判断。

	将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。
	 */
	public boolean isPalindrome(int x) {
		//<0false  =0 true <10 false
	    if(x == 0) return true;
	    if(x < 0) return false;
	    if(x % 10 == 0) return false;
	    int right = 0;
	    //1221 
	    while(x > right){
	    	//right = 个 十 百 ....
	        right = right * 10 + x % 10;
	        x /= 10; 
	    }
	    //1(千)2(百) = 2(十)1 (个) 或者 中间夹着一个数字(12 2 21)这种情况
	    return x == right || x == right / 10;
	    
	}
	
	public boolean isPalindrome2(int x) {
		if(x<0) return false;
		if(x==0) return true;
		if(x<10) return false;
		int right=0;
		while(x>right) {
			right = right*10 +x%10;
			x /=10;
		}
		return x==right || x == right/10; 
	    
	}

	public static void main(String[] args) {
		判断一个整数是否是回文数_9 判断一个整数是否是回文数_9 = new 判断一个整数是否是回文数_9();
		System.out.println(判断一个整数是否是回文数_9.isPalindrome2(12021));
	}
}
