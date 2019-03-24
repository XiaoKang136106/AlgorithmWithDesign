package 链表;

import 链表.反转链表_206.ListNode;

public class 链表元素按奇偶聚集_328 {
/**
 * Example:
	Given 1->2->3->4->5->NULL,
	return 1->3->5->2->4->NULL.
 */
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 //思路:新建两个链表，一个放置奇数节点，一个放置偶数节点，最后将偶数链表头放到奇数链表尾节点之后。(此方法不用新建链表，而是在原来链表基础上。)
	public ListNode oddEvenList(ListNode head) {
	    if (head == null) {
	        return head;
	    }
	    //	奇数=odd 偶数 = even
	    ListNode odd = head, even = head.next, evenHead = even;
	    
	    while (even != null && even.next != null) {
	    	odd.next = odd.next.next; //偶数的下下个 等于 偶数的下一个
	    	odd = odd.next; //odd.next指向odd
	    	even.next = even.next.next;
	    	even = even.next;
	    }
	    odd.next = evenHead;//evenHead 最终指向null	
	    return head;
	}
}
