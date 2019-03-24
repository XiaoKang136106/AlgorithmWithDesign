package 数学;

public class _2的幂次方 {
	
	
	public boolean powerOfTwo(int n) {
		if(n<=0) return false;

		return (n&(n-1))==0?true:false;
	}

}
