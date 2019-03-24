	package 剑指offer;

public class _31从1到n整数中1出现的次数 {
	
	/*
	 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现5次,但是对于后面问题他就没辙了。
	 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
	 */
	/*
	  *思路：若百位上数字为0，百位上可能出现1的次数由更高位决定(before*i)；若百位上数字为1，百位上可能出现1的次数
		不仅受更高位影响还受低位影响(before*i+after+1)；若百位上数字大于1，则百位上出现1的情况仅由更高位决定((before+1)*i)
	 */
	
	//暴力:从0开始遍历n,在遍历的时候,将其转换成String,在遍历String,利用charAt(j) ==1,进行判断是否需要count++
		public int NumberOf1Between1AndN_Solution3(int n) {
		 
		    int num = n;
		    int count = 0;// 计算数字中含有1的数字个数。
		    int strLen = 0;//每个数字的长度
		    for (int i = 0; i <= num; i++) {
		        String str = String.valueOf(i);
		        strLen = str.length();
		        for (int j = 0; j < strLen; j++) {
		            if (str.charAt(j) == '1') {
		                count++;
		            }
		        }
		    }
		 
		    return count;
		}
	
/*	public int NumberOf1Between1AndN_Solution(int n) {
		long count = 0; // 1的个数
		long i = 1; // 当前位
		long current = 0,after = 0,before = 0;
		while((n / i) != 0) {
		before = n / (i * 10); // 高位
		current = (n / i) % 10; // 当前位
		after = n - (n / i) * i; // 低位
		if (current == 0)
		//如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
		count = count + before * i;
		else if(current == 1)
		//如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
		count = count + before * i + after + 1;
		else if (current > 1)
		// 如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
		count = count + (before + 1) * i;
		//前移一位
		i = i * 10;
		} 
		return (int) count;
		
    }*/
	public int NumberOf1Between1AndN_Solution2(int n) {
		int count=0;
		//每10位循环一次
		
		for(int i = 1; i <= n; i *= 10){
		int a = n / i; // 高位
		int b = n % i; // 低位
		count += (a+8) / 10 * i;
		
		if(a % 10 == 1){
		count += b + 1;
		}
		} 
		return count;
	}
	
	public int NumberOf1Between1AndN_Solution(int n) {
		int count =0;
		int i=1;
		int current = 0,before = 0,after = 0;
		while((n/i) !=0) {
			
			before = n/(i*10);
			current = (n/i)%10;
			after = n - (n/i)*i;
			
				if (current == 0)
				count = count + before * i;
				else if(current == 1)
				count = count + before * i + after + 1;
				else if (current > 1)
				count = count + (before + 1) * i;
			if(current ==0) 
				count = count +before*i;
			else if(current ==1) 
				count = count + before*i+after+1;
			else if(current >1)
				count = count + (before+1)*i;
			i=i*10;
		}
		return count;
    }
}
