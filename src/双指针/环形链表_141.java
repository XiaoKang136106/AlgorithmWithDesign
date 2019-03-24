package 双指针;

public class 环形链表_141 {
	
	
	 class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) {
		         val = x;
		         next = null;
		     }
		 }
	 //给定一个链表，判断链表中是否有环。
	 //思路:	使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
	 public boolean hasCycle(ListNode head) {
	       if(head ==null) return false;
	       ListNode l1 = head; ListNode l2=head.next;
	       while(l1 !=null && l2 !=null) {
	    	   
	    	   if(l1 == l2 ) return true;
	    	   
	    	   l1 = l1.next;
	    	   
	    	   if(l2.next ==null) break;
	    	  
	    	   l2 = l2.next.next;
	    	  
	       }
	       return false;
	 }

}
