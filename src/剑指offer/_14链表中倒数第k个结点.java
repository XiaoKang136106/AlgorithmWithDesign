package 剑指offer;
/*
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class _14链表中倒数第k个结点 {
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
		/*
		 * 思路:定义一快一慢两个指针，快指针走K步，然后慢指针开始走，快指针到尾时，慢指针就找到了倒数第K个节点(二者相差k-1个距离)
			 
		 */
	    public ListNode FindKthToTail(ListNode head,int k) {
	    	if(head ==null || k<=0) {
	    		return null;
	    	}
	    	ListNode fast = head;
	    	ListNode slow = head;
	    	//先走k-1步(倒数第二也就多走了一步)
	    	while(k-- >1) {
	    		if(fast.next !=null ){
	    			fast=fast.next;
	    		}else {
	    			return null;
	    		}
	    	}
	    	//二个指针都开始向链表的尾部走
	    	while(fast.next != null) {
	    		fast = fast.next;
	    		slow = slow.next;
	    	}
	    	return slow;
	   
	    }

}
