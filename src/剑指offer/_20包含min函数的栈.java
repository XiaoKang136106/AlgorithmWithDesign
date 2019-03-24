package 剑指offer;

import java.util.Stack;

/*
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class _20包含min函数的栈 {

	// 思路:dataStack为存储数据的栈，minStack为存储最小值的栈.	

	Stack<Integer> dataStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int node) {
		dataStack.push(node);
		if (minStack.isEmpty() || node < minStack.peek()) {
			minStack.push(node);
		} else {
			//否则,栈中最小的元素还是minStack,由于,要和date中的元素个数和位置一一对应,所以,minStack
			//压入自己最小的值(栈顶的值),从而取出时候还是一一对应栈中最小的元素
			minStack.push(minStack.peek());
		}
	}

	public void pop() {
		dataStack.pop();
		minStack.pop();
	}

	public int top() {
		return dataStack.peek();
	}

	public int min() {
		return minStack.peek();
	}
}
