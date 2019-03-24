package 数学;

import 剑指offer._03从尾到头打印链表.ListNode;

public class 除自身以外数组的乘积_238 {
/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

	示例:
	
	输入: [1,2,3,4]
	输出: [24,12,8,6]
	说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
	//遍历一遍
	左边: result : [1,1,2,6]  记录它左边所有数的乘积
	temp=1
	最终 result:
	 result[3]=6
	 temp = nums[3]*temp=4 
	 result[2]=result[2]*temp=4*2=8
	 
	 temp = nums[2]*temp=12 
	 result[1]=result[1]*temp=12*1=12
	 
	 temp = nums[1]*temp=24
	 result[0]=result[0]*temp=24*1=24
	给定一个数组，创建一个新数组，新数组的每个元素为原始数组中除了该位置上的元素之外所有元素的乘积。
 */

	
/**
 * 思路:对于一个数组[1,2,3,4]，可以对它进行两次遍历。第一次从左到右遍历，第二次从右到左遍历。
 *     第一次遍历时记录它左边所有数的乘积，第二次遍历时将它右边的数乘上这个乘积就是这个数组中除了自身这个数以外所有数的乘积了
 */
	  public int[] productExceptSelf(int[] nums) {
	        int size=nums.length;
	        int[] result = new int[size];
	        result[0]=1;//索引为0的左边值一定为1
	        //开始遍历左边
	        for(int i=1;i<size;i++){
	            result[i]=result[i-1]*nums[i-1];
	        }
	        int temp=1;
	        //遍历右边,获取最终结果
	        for(int i=size-1;i>=0;i--) {
	        	result[i] = result[i] * temp; //左边的值 * 右边的值
	        	temp = temp *nums[i]; //每次遍历获取的右边值
	        }
	        return result;
	  }
	

}
