package 数学;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class 二进制相乘_xx {
	
	
	public int multiplication(int a,int b) {
		
		int sign=1;
		if(a<0) {
			sign=-sign;
			a=-a;
		}
		if(b<0) {
			sign=-sign;
			b=-b;
		}
		 int ret = 0;
	    while (b>0) 
	    {
	    	//位运算,如果为1,a就相当于扩容2倍
	        if ((b & 1)==1) 
	        {
	            ret = ret + a;
	        }
	        a <<= 1;
	        b >>= 1;
	    }
		if(sign<0) {
			ret=-ret;
		}
		
		return ret;
	}
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
	}

}
