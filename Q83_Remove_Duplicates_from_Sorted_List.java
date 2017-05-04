import org.junit.Test;

/*Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Q83_Remove_Duplicates_from_Sorted_List {
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode deleteDuplicates(ListNode head) {
		ListNode result = head;
		if(head==null) return null;
		while(head.next!=null){
			ListNode next = head.next;
			if(head.val == next.val){
				head.next = next.next;
			}else{
				head = next;
			}
		}
		return result;
    }
	
}
