package 二进制;

public class 交替位二进制数_693 {

	
	//二进制数相邻的两个位数永不相等,判断一个数的位级表示是否不会出现连续的 0 和 1
	//思路:将n右移一位,在和原来的数进行异或,得到的结果为11111就为true,将1111和(其+1)进行&判断是否等于0
	 public boolean hasAlternatingBits(int n) {
	       int a = n ^ (n>>1);
	       return (a&(a+1)) ==0;
	 }
}
