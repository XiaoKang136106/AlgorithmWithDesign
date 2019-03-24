package 栈和队列;

import java.util.Stack;

public class 用栈实现队列_232 {
/**
 * 	使用栈实现队列的下列操作：

	push(x) -- 将一个元素放入队列的尾部。
	pop() -- 从队列首部移除元素。
	peek() -- 返回队列首部的元素。
	empty() -- 返回队列是否为空。
	示例:

	MyQueue queue = new MyQueue();

	queue.push(1);
	queue.push(2);  
	queue.peek();  // 返回 1
	queue.pop();   // 返回 1
	queue.empty(); // 返回 false
 */
	//队列的特点:先进先出 栈的特点:先进后出
		
		    //4 -> 1,2,3  栈
			// 1,2,3,4 形成队列的顺序 	将4放入到栈尾,从而进行队列的顺序
	//创建一个栈
	private Stack<Integer> st =new Stack<Integer>();
    /** Initialize your data structure here. */
    public 用栈实现队列_232() {
        
    }
    
    /** Push element x to the back of queue. */
    //压入后新值一定要为栈底
    public void push(int x) {
    	 Stack<Integer> temp = new Stack();
    	 //st不为空添加到临时
         while(!st.isEmpty()){
             temp.push(st.pop());
         }
         st.push(x);
         while(!temp.isEmpty()){
             st.push(temp.pop());
         }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return st.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       return st.peek(); 
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.isEmpty();
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
