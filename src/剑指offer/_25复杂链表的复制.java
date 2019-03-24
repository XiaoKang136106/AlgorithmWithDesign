package 剑指offer;

/*
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class _25复杂链表的复制 {
	public class RandomListNode {
	    int label;	//节点值
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
		//1.A -> B  -> C
		//2.A -> A1 -> B -> B1-> C-> C1
		//3.A1-> B1 -> C1
	    //思路:先复制链表的next节点，将复制后的节点接在原节点后，然后复制其它的节点，最后取偶数位置的节点 （复制后的节点）
	    public RandomListNode Clone(RandomListNode pHead)
	    {
	    	
	    	if(pHead == null)
	    		return null;
	    	
	    		//创建一个复制节点的head
	    		RandomListNode head = new RandomListNode(pHead.label) ;//创建复制的链表
	    		//temp 指向 head A-A'
	    		RandomListNode temp = head ;
	    		//如果这里为phead,无法判断pHead.next是否为空
	    	while(pHead.next != null) {
	    		//让A'指向B'
	    		temp.next = new RandomListNode(pHead.next.label) ;//进行复制操作
	    		
	    		if(pHead.random != null) {
	    		
	    			temp.random = new RandomListNode(pHead.random.label) ;
	    		} 
	    		
	    		pHead = pHead.next ;
	    		
	    		temp = temp.next ;
	    		}
	    		return head ;
	    }
	        
}
