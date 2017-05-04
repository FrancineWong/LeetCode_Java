
public class Q203_Remove_Linked_List_Elements {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;                   
    }
	
	public ListNode removeElemnts_1(ListNode head, int val) {
		//fake head to avoid edge case
		ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
	}
}
