package 数学;

import java.util.Random;

public class x的平方根_69 {

	/*
	 * 输入: 4
		输出: 2
		示例 2:
		
		输入: 8
		输出: 2
		说明: 8 的平方根是 2.82842..., 
		     由于返回类型是整数，小数部分将被舍去。
	 */
	
	public int mySqrt(int x) {
	      if(x<=0) return 0;
	        int ret=0;
	        int left=1;
	        int right=x;
	        while(left<=right){
	         int mid =(left+right)>>1;
	         int sqrt=x/mid;
	            if(sqrt==mid){
	                return sqrt;
	            }else if(sqrt>mid){
	                left=mid+1;
	            }else{
	                right=mid-1;
	            }
	        }
	        
	        
	        return right;
	       
	    }
	public static void main(String[] args) {
		String s="a";
        String t="aa";
        boolean contains = t.contains(s);
        System.out.println(contains);
	}
}
