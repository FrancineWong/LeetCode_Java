
public class Q19_Remove_Nth_Node_From_End_of_List {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	//fast pointer
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
    }
	//my solution
	public ListNode removeNthFromEnd_1(ListNode head, int n) {
		ListNode copy = head;
		ListNode ret = copy;
		int len = 0;
		while(head!=null) {
			len++;
			head = head.next;
		}
		for(int i=0; i<len-n-1; i++) {
			copy = copy.next;
		}
		if(len==n) return ret.next;
		else if(n==1) {copy.next = null;}
		else{
			ListNode next = copy.next;
			copy.next = next.next;
		}
		return ret;
	}
}
