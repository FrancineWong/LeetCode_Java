import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Q206_Reverse_Linked_List {
	public class ListNode{
		int val; 
		ListNode next;
		ListNode(int x) { val =x;}
	}
	
	/*recursively*/
	public ListNode reverseList(ListNode head) {
	    /* recursive solution */
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null)
	        return newHead;
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
	
	/*iteratively*/
	//add next to the head
	//这是对的，只是自己的测试通不过
	public ListNode reserseList_2(ListNode head) {
		if(head==null) return null;
		ListNode newHead = head;
		while(head.next!=null){
			ListNode next = head.next;
			ListNode temp = newHead;
			newHead = next;
			head.next = next.next;
			newHead.next = temp;
		}	
		return newHead;
	}
	
	public ListNode reverseList_standard(ListNode head) {
	    /* iterative solution */
		//切断头，形成新的LinkList
	    ListNode newHead = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = newHead;
	        newHead = head;
	        head = next;//并不是后移，而是head 定位到后半部的LinkList首部
	    }
	    return newHead;
	}
	
	@Test
	public void test(){
		ListNode head = new ListNode(1);
		ListNode h_n = new ListNode(2);
		ListNode h_n2 = new ListNode(3);
		ListNode h_n3 = new ListNode(4);
		head.next = h_n;
		head.next.next = h_n2;
		head.next.next.next = h_n3;
		
		while(head.next!=null){
			System.out.println(head.val);
			head = head.next;
		}
		
		ListNode expected = new ListNode(4);
		ListNode e_n = new ListNode(3);
		ListNode e_n2 = new ListNode(2);
		ListNode e_n3 = new ListNode(1);
		expected.next = e_n;
		expected.next.next = e_n2;
		expected.next.next.next = e_n3;
		
		assertEquals(expected, reserseList_2(head));
	}
}
