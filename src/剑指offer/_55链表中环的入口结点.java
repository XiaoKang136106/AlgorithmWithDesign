package 剑指offer;

public class _55链表中环的入口结点 {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	/*
	 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
	 */
	/*
	 * ：定义:快慢两个指针，相遇后（环中相汇点）将快指针指向pHead 然后一起走，每次往后挪一位，相遇的
	 *    节点即为所求。详细分析：相遇即p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,
	 *    设环中有n个节点,p2 比p1多走一圈有2x=n+x; n=x;可以看出p1实际走了一个环的步数，
	 *    再让p2指向链表头部，p1位置不变，
	 * p1,p2 每次走一步直到p1==p2; 此时p1指向环的入口。
	 */

	/*   所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走，
	 *   2个指针速度一样，那么，当从原点的指针走到环入口点的时候（此时刚好走了x）
	 *	  从相遇点开始走的那个指针也一定刚好到达环入口点。
	 *	 所以2者会相遇，且恰好相遇在环的入口点。
	 */
	/*public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null)
			return null;
		ListNode slow = pHead;
		ListNode fast = pHead;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next; //走2步
			if (slow == fast) {
				//指向走到了头结点了
				fast = pHead;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				if (fast == slow)
					return slow;
			}
		}
		return null;

	}*/
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if(pHead == null || pHead.next ==null)
			return null;
		//创建2个指针,快指针和慢指针
		ListNode fast = pHead; 
		ListNode slow = pHead;
		while(fast !=null && fast.next !=null) {
				//开始遍历
				fast= fast.next.next;
				slow = slow.next;
				//都到达相遇点
				if(fast == slow) {
					//fast指向头结点
				fast = pHead;
					//2个指针以相同的速度出发
					while(fast != slow) {
						fast = fast.next;
						slow = slow.next;
					}
					//达到环的入口
					if(fast == slow) {
						return slow;
					}
				}
		}
			return null;
	}
}
