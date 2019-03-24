package 剑指offer;

import java.util.Stack;

public class _05用两个栈实现队列 {
	/*
	 * 用两个栈实现队列
	 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	 */
	 	Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();//保存的是stack1反顺序的元素
	     
	    public void push(int node) {
	       //队列的特点:先进先出
	       //栈的特点:先进后出
	       stack1.push(node);
	    }
	     
	    public int pop() {
	        //出栈
	    	//1.需要判断stack1和stack2是否为空
	        if(stack1 ==null && stack2 ==null ){
	            return 0;
	        }
	      //2.stack2中数据就从stack1中全部取出数据
	        if(stack2.isEmpty()){
	              //3需要判断stack1中是否有数据  
	            while(!stack1.isEmpty()){
	                stack2.push(stack1.pop());
	            }
	        }
	      
		    return stack2.pop();
	    }
	}
