package 动态规划_斐波那列;

import java.util.Scanner;
import java.util.Arrays;
public class Main{
    

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }
    
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            int curVal= nums[i];
            for(int j=0;j<i;j++){
                 if(curVal>nums[j]){
                     dp[i] = Math.max(dp[j]+1,dp[i]);
                 }
            }
        }
        int max=dp[0];
        for(int num:dp){
            max=Math.max(num,max);
        }
        return max;
        
    }
	public static void main(String[] args){
		String longestCommonPrefix = longestCommonPrefix(new String[]{"flower","flow","flight"});
               System.out.println(longestCommonPrefix); 
       int lengthOfLIS = lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
       System.out.println(lengthOfLIS);
    }
    
    
}
