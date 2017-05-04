/*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

*/
public class Q143_Reorder_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null) return;
        while(fast.next!=null&&fast.next.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode newHead = head;
        ListNode right = reverse(slow);
        while(right!=null&&newHead!=null) {
        	ListNode next = newHead.next;
        	ListNode nextR = right.next;
        	newHead.next = right;
        	right.next = next;
        	right = nextR;
        	newHead = next;
        }
    }
    public ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while(head!=null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}
