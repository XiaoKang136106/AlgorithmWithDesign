package 栈和队列;

import java.util.Stack;

public class 每日温度_739 {
/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。

	例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
	
	提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
	数组中元素与下一个比它大的元素之间的距离 71-> 下一个比它大的元素为76 4个距离
 */
	
	//在遍历数组时用 Stack 把数组中的数存起来，如果当前遍历的数比栈顶元素来的大，说明栈顶元素的下一个比它大的数就是当前元素。
	/*
	 * 遍历数组，如果栈不空，且当前数字大于栈顶元素，那么如果直接入栈的话就不是递减栈了，
	 * 所以我们取出栈顶元素，那么由于当前数字大于栈顶元素的数字，而且一定是第一个大于栈顶元素的数，
	 * 那么我们直接求出下标差就是二者的距离了，然后继续看新的栈顶元素，直到当前数字小于等于栈顶元素停止，然后将数字入栈，
	 * 这样就可以一直保持递减栈，且每个数字和第一个大于它的数的距离也可以算出来了
	 */
	public int[] dailyTemperatures(int[] temperatures) {
	    int n = temperatures.length;
	    int[] ret = new int[n];//默认为0
	    Stack<Integer> stack = new Stack<>(); //存索引,只存最大的索引,一定为递减栈
	    for(int i = 0; i < n; i++) {
	    	//遍历找到,是否有比他大的数,不为空并且 当前的元素大于栈顶的元素,栈顶元素的下一个比它大的数就是当前元素
	        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
	            int idx = stack.pop();//取出stack中最大索引
	            ret[idx] = i - idx; //表示二者之间的距离 1
	        }
	        stack.push(i); //先移除原来的索引,在添加
	    }
	    return ret;
	}
	public static void main(String[] args) {
		   Stack<Integer> stack1 = new Stack<>();
		   Stack<Integer> stack2 = new Stack<>();
		   stack1.push(1);
		   stack1.push(2);	//2 -> 1
		   stack2.add(1);
		   stack2.add(2);  //2-> 1 
		   System.out.println(stack1.peek()); //2
		   System.out.println(stack2.peek()); //2
		   
		   每日温度_739 每日温度_739 = new 每日温度_739();
		   每日温度_739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
	}
}
