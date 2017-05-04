/*Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.*/
public class Q061_Rotate_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode rotateRight(ListNode head, int k) {
		ListNode before = head;
        ListNode after = head;
        int size = getSize(head);
        if(head==null) return head;
        if(k%size==0) return head;
        k = k%size;
        for( int i=0; i<size-k; i++) {
        	before = before.next;
        }
        ListNode newHead = before;
        for( int i=0; i<k-1; i++) before = before.next;
        before.next = after;
        for(int i=0; i<size-k; i++) before = before.next;
        before.next = null;
        return newHead;
    }
	
	public int getSize(ListNode head) {
		int size = 0;
		while(head!=null) {
			head = head.next;
			size++;
		}
		return size;
	}
	
}
