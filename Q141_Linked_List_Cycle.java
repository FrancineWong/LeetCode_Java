/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?*/
public class Q141_Linked_List_Cycle {
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		val = x;
		next = null;
		}
	}
	
	public ListNode hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		//find meeting point, this will be LOOP_SIZE-k steps into the linkes list
		while(fast!=null&&fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				//collision
				break;
			}
		}
		
		//error check-no meeting point, and therefore no loop
		if(fast == null||fast.next==null) return null;
		//move slow to Head, Keep fast as meeting point, each are k steps form the loop start
		//if they move at the same pace, they must meet at the loop start
		slow = head;
		while(slow!=fast) {
			slow = slow.next;
			fast = fast.next;
		}
		//both now point to the start of the loop
        return fast;
    }
}
