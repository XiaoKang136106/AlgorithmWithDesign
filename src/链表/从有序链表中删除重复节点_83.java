package 链表;

import 链表.反转链表_206.ListNode;

public class 从有序链表中删除重复节点_83 {
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	//思路:递归思路,1.如果head为null并且 下一个也为null 返回head,
	 	//			2.递归,head.next !=null 并且 head==head.next.val?head.next:head
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next ==null) return head;
		head.next =deleteDuplicates(head.next);
		
		return head.next !=null && head.val ==head.next.val ?head.next:head ;
		
		
	}
}
