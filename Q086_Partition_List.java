/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.*/
public class Q086_Partition_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	/*********this is wrong answer because the original answer has been changed***********/
	public ListNode partition(ListNode head, int x) {
        ListNode newHead = head;
        ListNode tail = head;
        
        while(head!=null) {
        	ListNode next = head.next;
        	if(head.val<x) {
        		head.next = newHead;
        		newHead = head;
        	} else {
        		tail.next = head;
        		tail = head;
        	}
        	head = next;
        }
        tail.next = null;
        return newHead;
    }
	
	/****************************************************************************************/
	public ListNode partition_0(ListNode node, int x) {
		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;
		
		while(node!=null) {
			ListNode next = node.next;
			node.next = null;
			if(node.val < x) {
				//insert node into end of before list
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
				
			} else {
				//insert node into end of after list
				if(afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		if(beforeStart == null) return afterStart;
		//merge before list and after list
		beforeEnd.next = afterStart;
		return beforeStart;
	}
}
