package leetcode;


public class 是否存在环_141 {

	
	
	public boolean hasCycle(ListNode node) {
		if(node ==null) return false;
		ListNode slow = node;
		ListNode fast = node.next;
		while(fast!=null && fast.next!=null) {
			if(fast==slow) {
				return true;
			}
			slow=slow.next;
		    fast=fast.next.next;
		}
		
		
		return false;
	}
}
