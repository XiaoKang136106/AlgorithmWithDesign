package 链表;/*package 链表;
*//**
 * 
* @ClassName: TwoWayLinkedList 
* @Description: TODO(双向链表) 
* @author xiaok 
* @date 2018年9月29日 上午8:48:03 
*
 *//*
public class TwoWayLinkedList {
	
	private Node head;
	
	private Node tail;
	private int size;
	
	
	class Node{
		
		private Object data; //数据
		private Node next; //指向下一个节点的指针
		private Node prev; //指向前一个节点的指针
		
		public Node(Object data) {
			this.data = data;
		}
	}
	
	public TwoWayLinkedList() {
		size=0;
		head=null;
		tail=null;
	}
	
	//在链表中添加节点
	public void addHead(Object data) {
		Node newNode = new Node(data);
		//判断是否为空
		if(size ==0) {
			head=newNode;
			tail=newNode;
			size++;
		}else {
			head.prev=newNode;
			newNode.next=head;
			newNode=head;
			size++;
		}
	}
	  //在链表尾增加节点
	public void addTail(Object data) {
		
		Node newNode = new Node(data);
		
		if(size == 0) {
			head = newNode;
			tail = newNode;
			size++;
		}else {
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			size++;
		}
	}
	 //删除链表头
	public Node deleteHead() {
		 Node temp = head;
		if(size==0) {
			return null;
		}
		 head=head.next;
		 head.prev=null; //现在的head为原来head.next
		 size--;
		 return temp;
	}
	//删除链表尾
	public Node deleteTail() {
		Node temp = tail;
		if(size ==0) {
			return null;
		}
		tail=tail.prev;
		tail.next=null;
		size--;
		return temp;
		
	}
	    //获得链表的节点个数
	     public int getSize(){
	         return size;
	     }
	     //判断链表是否为空
	     public boolean isEmpty(){
	         return (size == 0);
	     }
	     
	     //显示节点信息
	     public void display(){
	         if(size >0){
	             Node node = head;
	             int tempSize = size;
	             if(tempSize == 1){//当前链表只有一个节点
	                 System.out.println("["+node.data+"]");
	                 return;
	             }
	             while(tempSize>0){
	                 if(node.equals(head)){
	                     System.out.print("["+node.data+"->");
	                 }else if(node.next == null){
	                     System.out.print(node.data+"]");
	                 }else{
	                     System.out.print(node.data+"->");
	                 }
	                 node = node.next;
	                 tempSize--;
	             }
	             System.out.println();
	         }else{//如果链表一个节点都没有，直接打印[]
	             System.out.println("[]");
	         }
	         
	     }
	 }
	
	
	

}
*/