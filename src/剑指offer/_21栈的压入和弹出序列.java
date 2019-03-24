package 剑指offer;

import java.util.Stack;

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的
 */
public class _21栈的压入和弹出序列 {
	
	//思路:用一个临时的栈来模拟pushA压栈,当临时的栈不为空并且和popA的起始元素相等则出栈,
	//在继续循环判断(注意需要给popA定义一个index),遍历完pushA,如果临时的栈为空,说明popA为出栈的顺序
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA == null && popA ==null) {
			return false;
		}
		if(pushA.length != popA.length) {
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0; 
		//遍历pushA,循环压入到栈中
		for(int i =0; i< pushA.length;i++) {
			stack.push(pushA[i]);
			//栈不为空并且栈顶的元素等于popA的元素,循环判断
			while(!stack.isEmpty() && stack.peek()==popA[index]) {
				//出栈
				stack.pop();
				//索引加1,进行下一轮的判断
				index++;			
				}
		}
		return stack.isEmpty();
			
	      
    }
}
