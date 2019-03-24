package 数组与矩阵;

import java.util.Arrays;

public class 寻找重复数_287 {
/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

	示例 1:
	
	输入: [1,3,4,2,2]
	输出: 2
	示例 2:
	
	输入: [3,1,3,4,2]
	输出: 3
 */
	public int findDuplicate(int[] nums) {
	  
		 //使用Arrays
		Arrays.sort(nums);
		int ret =-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==nums[i+1]) {
				ret = nums[i];
				break;
			}
		}
		return ret;
	 }
	
	//使用二分法
	public int findDuplicate2(int[] nums) {
		  int l = 1, h = nums.length - 1;
		     while (l <= h) {
		         int mid = l + (h - l) / 2;
		         int cnt = 0;
		         for (int i = 0; i < nums.length; i++) {
		             if (nums[i] <= mid) cnt++;
		         }
		         if (cnt > mid) h = mid - 1;
		         else l = mid + 1;
		     }
		     return l;
		   
	 }
	//双指针解法 类似于有环链表中找出环的入口：
	public int findDuplicate3(int[] nums) {
		//slow 为0上索引的值,fast为nums[0上索引的值]的值
	      int slow = nums[0], fast = nums[nums[0]];
	      while (slow != fast) {
	          slow = nums[slow]; //slow为slow上面的值
	          fast = nums[nums[fast]]; //fast已nums[fast]的索引的值
	      }

	      fast = 0;
	      while (slow != fast) {
	          slow = nums[slow];
	          fast = nums[fast];
	      }
	      return slow;
	}
	public static  boolean isPowerOfTwo(int n) {
	    return n > 0 && Integer.bitCount(n) == 1;
	}
	
	public static void main(String[] args) {
		boolean powerOfTwo = isPowerOfTwo(7);
		System.out.println(powerOfTwo);
		System.out.println(7&6);
		System.out.println(8&7);
		/*寻找重复数_287 寻找重复数_287 = new 寻找重复数_287();
		寻找重复数_287.findDuplicate3(new int[] {1,3,4,2,2});*/
	}
}
