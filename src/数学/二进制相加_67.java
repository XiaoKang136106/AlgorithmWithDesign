package 数学;

public class 二进制相加_67 {
/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。

	输入为非空字符串且只包含数字 1 和 0。
	
	示例 1:
	
	输入: a = "11", b = "1"
	输出: "100"
	示例 2:
	
	输入: a = "1010", b = "1011"
	输出: "10101
 */
	public String addBinary(String a, String b) {
	    //从低位开始
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
	    String str = "";
	    while(i >= 0 || j >= 0){
	    	
	        if(i >= 0 && a.charAt(i--) == '1') carry++;
	        if(j >= 0 && b.charAt(j--) == '1') carry++;
	        //carry=0或者2的话,都为0
	        str = (carry % 2) + str;
	        //为2   carry进一位
	        carry /= 2;
	    }
	    //最后判断是否为 进位的情况
	    if(carry == 1) str = "1" + str;
	    return str;
	}
}
