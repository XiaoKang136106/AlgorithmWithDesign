package 双指针;

public class 合并K个排序链表_23 {
	 class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	 /**
	     * 解题思路： 可以按照归并排序的原理，两两归并
	     * 时间复杂度为mlogk,m为链表中数字的总个数，k为链表个数
	     * @return
	     */
	    public ListNode mergeKLists(ListNode[] lists) {
	        if (lists.length == 0) {
	            return null;
	        }
	        int k = lists.length;
	        while (k > 1) {
	            for (int i = 0; i < k / 2; i++) {
	                //两两合并(1,2,3,4) =>(1,3)和(2,4)归并
	                lists[i] = mergeTwoLists(lists[i], lists[i + (k + 1) / 2]);
	            }
	            //长度减半
	            k = (k + 1) / 2;
	        }
	        return lists[0];
	    }

	    /**
	     * 归并排序，两两合并
	     */
	    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        ListNode root = new ListNode(0);
	        ListNode node = root;
	        while (list1 != null && list2 != null) {
	            if (list1.val <= list2.val) {
	                node.next = list1;
	                list1 = list1.next;
	            } else {
	                node.next = list2;
	                list2 = list2.next;
	            }
	            node = node.next;
	        }
	        if (list1 == null) {
	            node.next = list2;
	        }
	        if (list2 == null) {
	            node.next = list1;
	        }
	        return root.next;
	    }
}
