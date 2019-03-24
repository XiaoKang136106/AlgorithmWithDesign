package 链表;

public class 反转链表_206 {
	 public class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
	 }
	 //思路:创建一个新节点,从head开始指向newNode,遍历head,newNode每次都向后移动,从而head成为了newNode的尾节点
	 public ListNode reverseList(ListNode head) {
		    ListNode newHead = null; // 设为 null，作为新链表的结尾
		    while(head != null){
		        ListNode nextNode = head.next;
		        head.next = newHead; //指向当前节点的下一个节点
		        newHead = head; //当前节点指向新节点
		        head = nextNode;
		    }
		    return newHead;
		}
}
