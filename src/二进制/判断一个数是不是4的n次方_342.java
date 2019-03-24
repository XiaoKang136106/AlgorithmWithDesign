package 二进制;

public class 判断一个数是不是4的n次方_342 {

	//4的幂级数为1,4,16，即0001，0100,10000，也就是1出现在1,3,5,7。。。。位置上。0x55555555在32位系统里表示0b01010101010101010101010101010101。 
	  public boolean isPowerOfFour(int num) {
	     return num>0 && (num&(num-1))==0 && (num & 0x55555555) !=0;    
	    }
	  public boolean isPowerOfFour2(int num) {
		  int i=1;
		  //i超过最大值就会变成0
		  while(num>0) {
			  if(i==num) return true;
			  i <<=2;
		  }
		  return false;
	  }
	  public static void main(String[] args) {
		
		  判断一个数是不是4的n次方_342 判断一个数是不是4的n次方_342 = new 判断一个数是不是4的n次方_342();
		  System.out.println(判断一个数是不是4的n次方_342.isPowerOfFour2(3));
	  }
}
