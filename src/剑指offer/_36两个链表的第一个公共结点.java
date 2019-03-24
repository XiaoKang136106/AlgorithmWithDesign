package 剑指offer;

public class _36两个链表的第一个公共结点 {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	/*
	 * 输入两个链表，找出它们的第一个公共结点。
	 */
	//思路:创建2个遍历的指针,分别指向它们2个,如果到达链表的尾部重新开始遍历

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode p1= pHead1;
		ListNode p2 =pHead2;
		while(p1 != p2) {
			//不为空继续遍历,为空重新指向头结点
			p1=(p1 !=null)?p1.next:pHead1;
			p2=(p2 !=null)?p2.next:pHead2;
		}
		
		return p1;
	}

}
