package 链表;

public class 归并两个有序的链表_21 {

 public class ListNode {
		   int val;
		    ListNode next;
		   ListNode(int x) { val = x; }
	 }
 /**
  * 	输入：1->2->4, 1->3->4
 		输出：1->1->2->3->4->4
  */
 /*
  * 思路:
  * 	链表和树一样，可以用递归方式来定义：链表是空节点，或者有一个值和一个指向下一个链表的指针。因此很多链表问题可以用递归来处理。
  */
 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	 	//为空,直接返回,不用合并
	    if(l1 == null) return l2;
	    if(l2 == null) return l1;
	    ListNode newHead = null;
	    //小的值指向新节点	
	    if(l1.val < l2.val){
	        newHead = l1; //l1指向新节点
	        newHead.next = mergeTwoLists(l1.next, l2);//递归
	    } else{
	        newHead = l2;
	        newHead.next = mergeTwoLists(l1, l2.next);
	    }
	    return newHead;
	}
}
