import java.util.ArrayList;
import java.util.List;

/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from 
 * the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.*/
public class Q082_Remove_Duplicates_from_Sorted_List_II {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode prev = fakeHead;
		ListNode cur = head;
		
		while(cur!=null) {
			while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(prev.next==cur){
                prev=prev.next;
            }
            else{
                prev.next=cur.next;
            }
            cur=cur.next;
		}
		
		return fakeHead.next;
    }
	
	
}
