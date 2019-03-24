package 链表;
//使用单向链表实现的
public class StackSingleLink {
	private SingleLinkedList link;
	
	public StackSingleLink() {
		link =new SingleLinkedList();
	}
	
	//添加元素
	    public void push(Object obj){
	        link.addHead(obj);
	    }
	    
	    //移除栈顶元素
	    public Object pop(){
	        Object obj = link.removeHead();
	        return obj;
	    }
	    
	    //判断是否为空
	    public boolean isEmpty(){
	        return link.isEmpty();
	    }
	    
	    //打印栈内元素信息
	    public void display(){
	        link.display();
	    }
	

}
