package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class Mian {
	
	   public static int[] plusOne(int[] digits) {
	         long cnt=0;
	        for(int num:digits){
	            cnt =cnt*10+num;
	        }
	        cnt+=1;
	          List<Long> list = new ArrayList<Long>();
	        while(cnt>0){
	            long r=cnt %10;
	            list.add(r);
	            cnt/=10;
	        }
	        int [] ret =new int[list.size()];
	        
	       for(int i=list.size()-1,j=0;i>=0;i--){
	    	   ret[i] = list.get(j++).intValue();
	       }
	        
	        return ret;
	    }
	   
	   public static void main(String[] args) {
		   plusOne(new int[] {9,8,7,6,5,4,3,2,1,0});
	}
}
