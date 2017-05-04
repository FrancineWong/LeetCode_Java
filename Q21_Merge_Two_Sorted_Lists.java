/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together 
 * the nodes of the first two lists.*/
public class Q21_Merge_Two_Sorted_Lists {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
		ListNode fakeHead = new ListNode(0);
		ListNode current = fakeHead;

		while (l1 != null || l2 != null) {
			if (l1 == null || (l2 != null && l1.val >= l2.val)) {
				current.next = l2;
				current = l2;
				l2 = l2.next;
			} else {
				current.next = l1;
				current = l1;
				l1 = l1.next;
			}
		}
		return fakeHead.next;
    }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l1;
		if(l2==null) return l2;
		if(l1.val<=l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}
	}
	
	
	
}
