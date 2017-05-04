

/*Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.*/
public class Q092_Reverse_Linked_List_II {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null) return null;
        if(m==n) return head;
		ListNode res = new ListNode(0);
		res.next = head;
		ListNode before = res;
		int index = 1;
		while(index<m) {
			head = head.next;
			before = before.next;
			index++;
		}
		ListNode after = null;
		while(index<=n&&head!=null) {
			ListNode next = head.next;
			head.next = after;
			after = head;
			head = next;
			index++;
		}
		before.next = after;
		for(int i=0; i<=n-m; i++) if(before!=null) before = before.next;
		if(head!=null) before.next = head;
		return res.next;
    }
/***********************************************************************************************/	
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
/***************************************************************************************************/
	public ListNode reverseBetween_0(ListNode head, int m, int n) {
		if(head == null) return null;
	    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
	    dummy.next = head;
	    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
	    for(int i = 0; i<m-1; i++) pre = pre.next;
	    
	    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
	    ListNode then = start.next; // a pointer to a node that will be reversed
	    
	    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
	    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
	    
	    for(int i=0; i<n-m; i++)
	    {
	        start.next = then.next;
	        then.next = pre.next;
	        pre.next = then;
	        then = start.next;
	    }
	    
	    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
	    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
	    
	    return dummy.next;
	}
}
