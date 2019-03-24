package 二进制;

public class _2的幂_231 {
	
	public boolean isPowerOfTwo(int n) {
      
		return n>0 && (n&(n-1))==0;
    }

}
