
/*Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?*/
public class Q234_Palindrome_Linked_List {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
 
        while(fast!=null&&fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        if(fast!=null) slow = slow.next;
        ListNode r_slow = reverseList(slow);
        while(r_slow!=null) {
        	if(r_slow.val!=head.val) return false;
        	r_slow = r_slow.next;
        	head = head.next;
        }
        return true;
    }
	//reverse right part and compare with the left part
	public ListNode reverseList(ListNode head) {
	    ListNode newHead = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = newHead;
	        newHead = head;
	        head = next;
	    }
	    return newHead;
	}
}
