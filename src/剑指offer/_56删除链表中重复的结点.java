package 剑指offer;

import demo11.Node;
import 剑指offer._56删除链表中重复的结点.ListNode;

public class _56删除链表中重复的结点 {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
	 *  例如，链表1->2->3->3->4->4->5
	 * 处理后为 1->2->5
	 */
	// 思路：先新建一个头节点，然后向后查找值相同的节点，重复查找后删除
	/*public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null)
			return null;
		// 新建一个节点，防止头结点被删除
		ListNode first = new ListNode(-1);
		first.next = pHead;
		ListNode p = pHead;
		// 指向前一个节点
		ListNode preNode = first;//first也是一个指针
		//不为最后一个节点
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				int val = p.val;
				// 向后重复查找
				while (p != null && p.val == val) {
					p = p.next;
				}
				// 上个非重复值指向下一个非重复值：即删除重复值,当前的p肯定不为重复的数
				preNode.next = p;
			} else {
				// 如果当前节点和下一个节点值不等，则向后移动一位
				preNode = p;
				p = p.next;
			}
		}
		return first.next;

	}
	*/ 
	public ListNode deleteDuplication3(ListNode pHead) {
		 if (pHead == null || pHead.next == null)
		        return pHead;
		 pHead.next=deleteDuplication3(pHead.next);
		 return pHead.val==pHead.next.val? pHead.next:pHead;
		 
	}
	public ListNode deleteDuplication(ListNode pHead) {
	    if (pHead == null || pHead.next == null)
	        return pHead;
	    ListNode next = pHead.next;
	    if (pHead.val == next.val) {
	        while (next != null && pHead.val == next.val)
	            next = next.next;
	        return deleteDuplication(next);
	    } else {
	        pHead.next = deleteDuplication(pHead.next);
	        return pHead;
	    }
	}
	public ListNode deleteDuplication2(ListNode pHead) {
		if(pHead ==null)
			return null;
		//新建一个头结点,避免头结点有重复元素而删除的情况
		ListNode first = new ListNode(-1);
		first.next = pHead;//获取头节点的第一个元素
		ListNode p = pHead; //用于查找的
		ListNode preNode = first; //用于返回的指针
		//开始遍历
		while(p!=null && p.next !=null) {
			//前一个元素和后一个元素相同
			if( p.val == p.next.val) {
				int val = p.val; 
				//向后查找重复元素
				while(p !=null && p.val == val) {
					p=p.next;
				}
				// 如果当前节点和下一个节点值不等，则向后移动一位,其实就是删除
				preNode.next = p;
				
			}else{
				//不相同继续遍历,1,2,3
				preNode =p;
				p = p.next;
				
				
			}
			
		}
		return first.next;
		
	}
	
	public ListNode swapPairs(ListNode head) {
		
		ListNode  newHead = new ListNode(-1);
		newHead.next=head;
		ListNode pre = newHead;
		while (pre.next != null && pre.next.next != null) {
	        ListNode l1 = pre.next, l2 = pre.next.next;
	        ListNode next = l2.next;
	        l1.next = next;
	        l2.next = l1;
	        //重新连接
	        pre.next = l2;

	        pre = l1;
	    }
		
		return newHead.next;
	}
	public ListNode deleteDuplication5(ListNode pHead) {
		if(pHead ==null ||pHead.next==null)  return pHead;
		ListNode next = pHead.next;
		if(pHead.val ==next.val) {
			while(next!=null && pHead.val==next.val)
			next = next.next;
			return deleteDuplication5(next);
		}else {
			pHead.next=deleteDuplication5(pHead.next);
			return pHead;
		}
	}
	

	          private String a;

	          public void printOne(){

	          System.out.println(a+"One");

	         }

	 

	 

	        public void printTwo(){

	        	String b = null;

	          System.out.println(b+"Two");

	        }
	public static void main(String[] args) {

		  String a = "this is String a";

		            String b = a;

		            a = "this is String b";

		            System.out.println(b);
	}
}
