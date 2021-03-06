import java.util.Random;

/*Given a singly linked list, return a random node's value from the linked list. Each node must have the same 
 * probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently 
without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();*/
public class Q382_Linked_List_Random_Node {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	ListNode h;
	Random random;
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Q382_Linked_List_Random_Node(ListNode head) {
	    h = head;
	    random = new Random();
	}
	
	/** Returns a random node's value. */
	public int getRandom() {
	    ListNode c = h;
	    int r = c.val;
	    for(int i=1; c.next!=null; i++) {
	    	c = c.next;
	    	if(random.nextInt(i+1)==i) r = c.val;
	    }
	    return r;
	}
	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(head);
	 * int param_1 = obj.getRandom();
	 */
}
