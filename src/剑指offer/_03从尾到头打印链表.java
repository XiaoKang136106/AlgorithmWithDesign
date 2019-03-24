package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

public class _03从尾到头打印链表 {
	/*
	 * 从尾到头打印链表 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
	 */

	public class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}
	/*
	 *  	思路:链表的特点,使用pre,和next2个指针进行求解,同反转链表这个题目
        //pre指针的作用用于反转链表,next指针的作用用于保存head下一个节点的信息,防止头节点断裂
	 */

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		// 使用栈来实现
		ArrayList<Integer> list = new ArrayList<>();
		if (listNode == null)
			return list;
		Stack<ListNode> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop().val);
		}
		return list;
	}

	
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        //思路:链表的特点,使用pre,和next2个指针进行求解
        //pre指针的作用用于反转链表,next指针的作用用于保存head下一个节点的信息,防止头节点断裂
        //思路2:利用栈的思想进行(简单,不推荐)
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(listNode ==null) return ret;
        ListNode pre =null;
        ListNode next=null;
        //遍历listNode
        while(listNode !=null){
            next = listNode.next;
            //先将pre指向head.next,在将head指向pre,从而进行反转成功
            listNode.next=pre;
            pre=listNode;
            listNode=next;
            
        }
        while(pre !=null){
            ret.add(pre.val);
            pre=pre.next;
        }
        
        return ret;
    }
}
