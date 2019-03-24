package 数学;

public class 七进制_504 {
/**
 * 
 *  输入: 100
	输出: "202"
	示例 2:
	
	输入: -7
	输出: "-10"
	注意: 输入范围是 [-1e7, 1e7] 。
 */
	public String convertToBase7(int num) {
		
		if(num<0) {
			return "-"+convertToBase7(-num); 
		}
		if(num<7) {
			//转换成字符串
			return num+""; 
		}
		return convertToBase7(num/7)+num%7;
		
	}

}
