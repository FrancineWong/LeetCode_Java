/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?*/
public class Q142_Linked_List_Cycle_II {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		val = x;
		next = null;
		}
	}
	public ListNode detectCycle(ListNode head) {
        ListNode colid = null;
        
        
        
        return colid;
    }
	
	/*************************************************************************************/
	public ListNode detectCycle_0(ListNode head) {
	    if (head == null || head.next == null) return null;
	    
	    ListNode firstp = head;
	    ListNode secondp = head;
	    boolean isCycle = false;
	    
	    while(firstp != null && secondp != null) {
	        firstp = firstp.next;
	        if (secondp.next == null) return null;
	        secondp = secondp.next.next;
	        if (firstp == secondp) { isCycle = true; break; }
	    }
	    
	    if(!isCycle) return null;
	    firstp = head;
	    while( firstp != secondp) {
	        firstp = firstp.next;
	        secondp = secondp.next;
	    }

	    return firstp;
	}
}
