package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈_225 {
	 public 用队列实现栈_225() {
	        
	    }
	 //队列的特点:先进先出 栈的特点:先进后出
	 // 2,3,4 <- 1 队列
	    // 1,2,3,4 形成栈的顺序		 1添加进来,需要放入到栈的头部
	 private Queue<Integer> queue = new LinkedList<Integer>();
	    /** Push element x onto stack. */
	    public void push(int x) {
	    	//1.添加
	    	queue.add(x);
	    	if(queue !=null)
	    	//放入到队尾
	    		//最后一个不用移除
	    	for (int i = 1; i < queue.size(); i++) {
				//从而变成先进后出的特点
	    		 queue.add(queue.remove());
			}
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	    	 return queue.remove();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	return queue.peek();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	    	  return queue.isEmpty();
	    }
}
