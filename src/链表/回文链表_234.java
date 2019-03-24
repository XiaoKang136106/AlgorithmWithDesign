package 链表;

import 链表.归并两个有序的链表_21.ListNode;

public class 回文链表_234 {
/**
 * 请判断一个链表是否为回文链表。

	示例 1:
	
	输入: 1->2
	输出: false
	示例 2:
	
	输入: 1->2->2->1
	输出: true
 */
	 public class ListNode {
		   int val;
		    ListNode next;
		   ListNode(int x) { val = x; }
	 }
	 //思路:定义2个指针,1个慢指针一个快指针,快指针的速度为慢指针的2倍,快指针走到终点,慢指针指向中点
	 //在切分,快指针->慢指针的next,慢指针的next指向null
	 //在反转快指针遍历判断
	public boolean isPalindrome(ListNode head) {
		  if(head==null||head.next==null)
	            return true;
	        ListNode p1 = head;	 //慢节点
	        ListNode p2 = head.next; //快节点
	        
	        while (p2!=null) {
	            p2 = p2.next;//p2为p1的下下个节点
	            if (p2 == null)//p2为null,退出循环
	                break;
	            //进行下一轮遍历
	            p2 = p2.next;
	            p1 = p1.next;
	        }
	        //奇数，则p1指向中点
	        //偶数，则p1指向左边的最后一个节点
	        //切割
	        p2 = p1.next;
	        p1.next = null;
	        //p2逆序
	        ListNode newHead = null;
	        while(p2!=null){
	            ListNode p = p2.next;//保存链表的next
	            p2.next = newHead;//将head的next指向新的链表头
	            newHead = p2;//将新链表头指向头结点
	            p2 = p;//将head赋给之前保存的next
	        }
	        //head 为左边链表 newhead为右边链表
	        while (newHead!=null){
	            if(head.val!=newHead.val)
	                return false;
	            head = head.next;
	            newHead = newHead.next;
	        }
	        return true;
	}
}
