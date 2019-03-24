package 其他问题;

public class 复制粘贴字符_650 {
/**
 * 
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：

	Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
	Paste (粘贴) : 你可以粘贴你上一次复制的字符。
	给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。
	输出能够打印出 n 个 'A' 的最少操作次数。
	
	示例 1:
	
	输入: 3
	输出: 3
	解释:
	最初, 我们只有一个字符 'A'。
	第 1 步, 我们使用 Copy All 操作。
	第 2 步, 我们使用 Paste 操作来获得 'AA'。
	第 3 步, 我们使用 Paste 操作来获得 'AAA'。
	如果 N = 4，要生成AAAA，有2种方法: 
	1.复制1次A，然后粘贴1次A， 再复制1次AA再粘贴1次AA，此时output为4。 
	ii.复制1次A，连续粘贴3次A，此时output也为4。
	n=1, minSteps=0;

　　n=2, 步骤：cp，minSteps=2

　　n=3, 步骤：cpp, minSteps=3

　　n=4, 步骤: cppp或者 cpcp（复制S[2]并粘贴一次），minSteps=4

　　n=5, 步骤：cpppp=c+p*4，minSteps=5

　　n=6, 步骤：c+p*5 或者 cp(cpp) (复制S[2]并粘贴2次) 或者 cpp(cp)(复制S[3]并粘贴1次)， minSteps=5

　　。。。。。

　　n=12, 步骤：c+p*11

　　　 或者 先取得“AA”然后c+p*5（这里5=(12-2)/2），S[n] = S[n/2] + 1+(n-2)/2 = S[n/2] + n/2

     或者 先取得 “AAA”然后c+p*3（这里3=(12-3)/3），S[n] = S[n/3] + 1+(n-3)/3 = S[n/3] + n/3

      或者 先取得“AAAA”然后c+p*2（这里2=(12-4)/4），S[n] = S[n/4] + 1+(n-4)/4 = S[n/4] + n/4,S[n/4]为取的“AAAA”的次数
      　S[n] = min(S[n/i]+n/i) 其中i为能被n整除的数
	
 */
	
	
	public int minSteps3(int n) {
	 
		int[] minStep = new int[n+1];
		for (int i = 2; i <= n; i++) {

			minStep[i] = i;
		}
		for(int i=4;i<=n;i++) {
			for(int j=2;j<i;j++) {
				if(i % j==0) minStep[i] =Math.min(minStep[i], minStep[j]+i/j); 
			}
		}
		return minStep[n];
	}
	public int minSteps1(int n) {
	    int[] dp = new int[n + 1];
	    for (int i = 2; i <= n; i++) {
	        dp[i] = i;
	        for (int j = i - 1; j >= 0; j--) {
	            if (i % j == 0) {
	                dp[i] = dp[j] + dp[i / j];
	                break;
	            }
	        }
	    }
	    return dp[n];
	}
	public int minSteps2(int n) {
	    if (n == 1) return 0;
	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) return i + minSteps2(n / i);
	    }
	    return n;
	}
}
