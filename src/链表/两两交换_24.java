package 链表;


public class 两两交换_24 {
	
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	//递归
    public ListNode swapPairs(ListNode head) {
        if(head ==null) return null;
        if(head.next ==null) return head;
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }

}
