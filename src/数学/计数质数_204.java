package 数学;

public class 计数质数_204 {
/**
 * 统计所有小于非负整数 n 的质数的数量。

	示例:
	
	输入: 10
	输出: 4
	解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */
	
	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++)
            isPrime[i] = true;
        for(int i = 2; i * i < n; i++){
        	//false->退出循环
            if(!isPrime[i])
                continue;
            //
            for(int j = i * i; j < n; j += i){
                isPrime[j] = false;
            }
        }
        for(int i = 2; i < n; i++){
            if(isPrime[i])
                count++;
        }
        return count;
		
		
	}
/*	  public int countPrimes(int n) {
	        int count=0;
	        for(int i=1;i<n;i++) {		
	        	if(isprime(i)) {
	        		count++;
	        	}
	        }
	        		return count;
	   }

  private boolean isprime(int n) {

	  if(n<2) return false;
	  if(n==2) return true;
	  //开根号
	  double sqrt = Math.sqrt(n+0.0);
	  for(int i=1;i<sqrt;i++) {
	      //如果可以被整除,就不是素数
		  if(n%i==0) return false;
	  }
	  return false;
  }*/
}
