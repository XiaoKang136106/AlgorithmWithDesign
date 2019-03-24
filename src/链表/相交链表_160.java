package 链表;

public class 相交链表_160 {
/**
 * 编写一个程序，找到两个单链表相交的起始节点。

	例如，下面的两个链表：
	
	A:          a1 → a2
	                   ↘
	                     c1 → c2 → c3
	                   ↗            
	B:     b1 → b2 → b3
 */
	  public class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) {
		         val = x;
		         next = null;
		     }
		  }
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		if(headA ==null ||headB ==null ) return null;
		ListNode l = headA; ListNode r = headB;
		while(l != r) {
			l = (l==null)? headA:l.next;
			r = (r==null)? headB:r.next;		
		}
		return l;
	}
	
	
}
