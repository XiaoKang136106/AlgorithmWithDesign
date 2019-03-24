package 分治;

import java.util.ArrayList;
import java.util.List;

public class 为运算表达式设计优先级_241 {
	
	//分治，字面上的解释是“分而治之”，就是把一个复杂的问题分成两个或更多的相同或相似的子问题，再把子问题分成更小的子问题
/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

		示例 1:
		
		输入: "2-1-1"
		输出: [0, 2]
		解释: 
		((2-1)-1) = 0 
		(2-(1-1)) = 2
		示例 2:
		
		输入: "2*3-4*5"
		输出: [-34, -14, -10, -10, 10]
		解释: 
		(2*(3-(4*5))) = -34 
		((2*3)-(4*5)) = -14 
		((2*(3-4))*5) = -10 
		(2*((3-4)*5)) = -10 
		(((2*3)-4)*5) = 10
 * 
 * 
 * 
 */
	public List<Integer> diffWaysToCompute(String input) {
	    int n = input.length();//先获取长度
	    List<Integer> ret = new ArrayList<>();
	    
	    //遍历
	    for (int i = 0; i < n; i++) {
	        //获取上面的数字
	    	char c = input.charAt(i);
	    	//判断是否满足条件
	    	if (c == '+' || c == '-' || c == '*') {
	            //左边的值
	    		List<Integer> left = diffWaysToCompute(input.substring(0, i));
	            //获取右边的值
	    		List<Integer> right = diffWaysToCompute(input.substring(i + 1));
	            //遍历左边
	    		for (int l : left) {
	                //遍历右边
	    			for (int r : right) {
	    				//判断是＋,-,*
	                    switch (c) {
	                        case '+': ret.add(l + r); break;
	                        case '-': ret.add(l - r); break;
	                        case '*': ret.add(l * r); break;
	                    }
	                }
	            }
	        }
	    	/*System.out.println("---------------");
	    	System.out.println(input);
	    	System.out.println(ret.size());
	    	System.out.println("---------------");*/
	    }
	    //System.out.println(input);
	    if (ret.size() == 0) ret.add(Integer.valueOf(input));
	    return ret;
	}
	
	//思路:对输入的字符串进行从头到尾扫描，当遇到运算符时以该运算符为分界位置将字符串分成两个部分，并分别把这两部分作为形参传递给diffWaysToCompute函数（递归），
	//最终会得到两个数值（result1，result2），再进行最后一步运算得到结果，把结果存储在动态数组中（result），进行下一次循环。循环结束，所有的可能结果都保存在result中了。 
	
	
	public List<Integer> diffWaysToCompute2(String input) {
		
		//先获取长度
		int n = input.length();
		//定义一个返回数组
		List<Integer> ret = new ArrayList<Integer>();
		//开始遍历
		for (int i = 0; i < n; i++) {
			char c = input.charAt(i);
			//获取分隔符(+,-,*)确定分段的位置
			if( c=='+' ||c=='-' || c=='*' ) {
				//分割
				List<Integer> left = diffWaysToCompute2(input.substring(0, i));
				
				List<Integer> right = diffWaysToCompute2(input.substring(i+1));
				
				//遍历
				for (Integer l : left) {
					
					for (Integer r : right) {
						
						//进行判断,是什么符号
						switch(c) {
						
						case '+': ret.add(l + r); break;
						case '-': ret.add(l - r); break;
						case '*': ret.add(l * r); break;
						}
					}
				}
			}
		}
		//当input仅只有一个字符,ret的size为空时,添加进来
		if(ret.size()==0) {
			
			ret.add(Integer.valueOf(input));
		}
		return ret;
	}
	
}
