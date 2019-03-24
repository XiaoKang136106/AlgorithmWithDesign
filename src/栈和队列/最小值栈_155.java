package 栈和队列;

import java.util.Stack;

public class 最小值栈_155 {
	//用两个栈实现，一个存储数据，一个存储最小值。
	/**
	 * 
	 * push(x) -- 将元素 x 推入栈中。
	pop() -- 删除栈顶的元素。
	top() -- 获取栈顶元素。
	getMin() -- 检索栈中的最小元素。
	示例:
	
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	-3 , 0 , -2
	minStack.getMin();   --> 返回 -3.
	minStack.pop();
	minStack.top();      --> 返回 0.
	minStack.getMin();   --> 返回 -2.
	 */
	 private Stack<Integer> dataStack = new Stack<Integer>();
	 private Stack<Integer> minStack = new Stack<Integer>();
	 private int min = Integer.MAX_VALUE;
    public void push(int x) {
    	 dataStack.push(x);
         if(x < min) {
             min = x;
         }
         minStack.push(min);
    }
    
    public void pop() {
    	dataStack.pop();
        minStack.pop();
        if(!minStack.isEmpty()) {
            min = minStack.peek();
        } else{
            min = Integer.MAX_VALUE;
        }
    	
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
