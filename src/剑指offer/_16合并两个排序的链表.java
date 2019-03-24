package 剑指offer;

public class _16合并两个排序的链表 {
	/*
	 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
	 */
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 递归，小数放在前面
	 */
	public ListNode Merge(ListNode list1, ListNode list2) {

		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode newNode = null;
		if (list1.val <= list2.val) {
			newNode = list1;
			newNode.next = Merge(list1.next, list2);

		} else {
			newNode = list2;
			newNode.next = Merge(list1, list2.next);
		}
		return newNode;
	}

	// 非递归求解
	public ListNode Merge2(ListNode list1, ListNode list2) {

		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode mergeHead = null;	//mergeHead始终指向mergeHead
		ListNode current = null;	//current用于合并list1和list2,保证链表不会断裂
		while (list1 != null && list2 != null) {
			//list1.val<=list2.val
			if (list1.val <= list2.val) {
				
				//如果current为空,list1指向current
				if (mergeHead == null) {
					mergeHead = current = list1;
				//list1指向current.next
				} else {
					current.next = list1;
					current = current.next;
				}
				//指针指向下一个
				list1 = list1.next;
			} else {
				if (mergeHead == null) {
					mergeHead = current = list2;
				} else {
					current.next = list2;
					current = current.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 == null) {
			current.next = list2;
		} else {
			current.next = list1;
		}
		return mergeHead;
	}

}
