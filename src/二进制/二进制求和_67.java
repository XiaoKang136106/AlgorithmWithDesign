package 二进制;

public class 二进制求和_67{
	
	
	
	private String twoSum(String a,String b){
		   String result="";
	        //类似于前一章的carry进位状态符
	        int sum=0;
	        int lengthA=a.length();
	        int lengthB=b.length();
	        while(lengthA>0||lengthB>0){
	            if(lengthA>0){
	                //截取字符串最后一位，类似获取十进制里的个位
	                sum+=Integer.parseInt(a.substring(lengthA-1,lengthA));
	                lengthA--;
	            }
	            if(lengthB>0){
	                sum+=Integer.parseInt(b.substring(lengthB-1,lengthB));
	                lengthB--;
	            }
	            //刚刚好满足进位,当前位为0,sum进位置为1
	            if(sum==2){
	                //相加刚好等于2，所以前一位剩余0，类似于十进制 4+6时，个位满十进位，个位数值为0
	                result="0"+result;
	                //这里重新赋予1，是指进位的那一个数值，所以前面代码是用 sum+=  而不是sum=
	                sum=1;
	                //满足进位,当前位为1,sum进位置为1
	            }else if(sum==3){
	                result="1"+result;
	                sum=1;
	            }else{
	            	//不满足进位,当前位为sum,sum置为0;
	                result=(sum+"")+result;
	                sum=0;
	            }    
	        }
	        //用于处理最高位进位
	        if(sum==1){
	            result="1"+result;
	        }
	        return result;
	}
	
	
}