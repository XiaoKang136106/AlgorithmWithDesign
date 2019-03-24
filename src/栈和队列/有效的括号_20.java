package 栈和队列;

import java.util.Stack;

public class 有效的括号_20 {
	public boolean isValid(String s) {
		
		
	    Stack<Character> stack = new Stack<>();
	    for(int i = 0; i < s.length(); i++){
	        char c = s.charAt(i);
	        if(c == '(' || c == '{' || c == '[') stack.push(c);
	        else{
	            if(stack.isEmpty()) return false;
	            char cStack = stack.pop();//取出存入的开始符号
	            //判断是否为一对,满足不是一对的话 -> false;
	            if(c == ')' && cStack != '(' ||
	              c == ']' && cStack != '[' ||
	              c == '}' && cStack != '{' ) {
	                return false;
	            }
	        }
	    }
	    //判断是否为空
	    return stack.isEmpty();
	}
}
