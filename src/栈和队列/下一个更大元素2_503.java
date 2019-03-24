package 栈和队列;

import java.util.Arrays;
import java.util.Stack;

public class 下一个更大元素2_503 {
/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，	
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

	示例 1:
	
	输入: [1,2,1]
	输出: [2,-1,2]
	解释: 第一个 1 的下一个更大的数是 2；
	数字 2 找不到下一个更大的数； 
	第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
	public int[] nextGreaterElements(int[] nums) {
	    int n = nums.length, next[] = new int[n];
	    Arrays.fill(next, -1);
	    Stack<Integer> stack = new Stack<>();
	    //遍历查找,一遍数组所以是n*2,以为最后一个需要重头查找一遍是否有下一个更大的元素
	    for (int i = 0; i < n * 2; i++) {
	    	//取模,就是用来重头开始查找
	        int num = nums[i % n];
	        //stack不为空 并且 num 大于栈中最大的值
	        while (!stack.isEmpty() && nums[stack.peek()] < num)
	            //当前索引的下一个更大的元素为num
	        	next[stack.pop()] = num;
	        //只保存第一次遍历的索引,下一个更大元素的索引
	        if (i < n) stack.push(i);
	   
	    }
	  
	    return next;
	}
}
