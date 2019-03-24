package 背包问题;

public class 分割等和子集_416 {
/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
	
	注意:
	
	每个数组中的元素不会超过 100
	数组的大小不会超过 200
	示例 1:
	
	输入: [1, 5, 11, 5]
	
	输出: true
	
	解释: 数组可以分割成 [1, 5, 5] 和 [11].
	 
	
	示例 2:
	
	输入: [1, 2, 3, 5]
	
	输出: false
	
	解释: 数组不能分割成两个元素和相等的子集.
 */
	/*
	 * 首先,A可以分成两个和相等的数组,换句话说,这个A总和至少可以被2整除;

其次,A数组能够找到一个这样数组,就是和为sum(A)/2,说明这个数组可以分割成,反之不然;


但是,如何找到一个数组A是否存在和sum(A)/2的子数组呢?两种方法:

第一种:动态规划,就是不放回的取与不取的问题.

用dp[i][j]代表取nums前i是否可以凑成总和为j的布尔值.
	 */
	public boolean canPartition2(int[] nums) {  
	     int sum=0;  
	     for (int num:nums) sum+= num;
	     if(sum % 2 == 1) return false;
	     else{  
	        sum /=2;
	        int n=nums.length;  
	        // dp[i][j] 表示 如果我们取前i个数字，且背包容量为j的情况下，最多能放入多少东西
	        int dp[][]=new int[n][sum + 1];  
	        // dp[0][0] 为初始状态，表示，没有任何没有东西没有体积，其余部分初始化
	        for(int i=nums[0];i<=sum;i++){
	             dp[0][i] = nums[0];
	        }
	        //遍历n个数字，即视为n个产品
	        for(int i=1;i<n;i++){  
	            //加入了这种物品后更新状态
	            for(int j=nums[i];j<=sum;j++){  
	                dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);  
	            }  
	        }  
	        //放满了才能表示正好1/2
	        if(dp[n-1][sum]==sum) 
	            return true;  
	        else
	            return false;  
	     }  

	 }  
	public boolean canPartition(int[] nums) {
	    int sum = 0;
	   //获取所有的总数
	    for (int num : nums) {
	        sum += num;
	    }
	    //为奇数,无法进行拆分,因为奇数+奇数=偶数,偶数+偶数=偶数
	    if (sum % 2 == 1) {
	        return false;
	    }
	    //拆分成一半
	    int W = sum / 2;
	    
	    boolean[] dp = new boolean[W + 1];
	    int n = nums.length;//获取nums的长度
	    //遍历
	    for(int i = 0; i <= W; i++) {
	    	//判断放一件,是否可以满足背包需求
	        if(nums[0] == i) dp[i] = true;
	    }
	    for(int i = 1; i < n; i++) {
	        for(int j = W; j >= nums[i]; j--) {
	            dp[j] = dp[j] || dp[j - nums[i]];
	        }
	    }

	    return dp[W];
	}
}
