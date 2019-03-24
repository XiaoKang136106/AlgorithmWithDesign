package 数学;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角_118 {
	
	
	 public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> ret =new ArrayList<List<Integer>>();
	        if(numRows<=0){
	            return ret;
	        }
	        List<Integer> tem1 = new ArrayList<Integer>();
	        tem1.add(1);
	        ret.add(tem1);
	        if(numRows==1){
	            return ret;
	        }
	         List<Integer> tem2 = new ArrayList<Integer>();
	        tem2.add(1);
	        tem2.add(1);
	        ret.add(tem2);
	        if(numRows==2){
	            return ret;
	        }
	        for(int i=2;i<numRows;i++){
	            List<Integer> tem = new ArrayList<Integer>();
	            tem.add(1);
	            for(int j=1;j<i;j++){
	                tem.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
	            }
	            tem.add(1);
	            ret.add(tem);
	        }
	        return ret;
	    }

}
