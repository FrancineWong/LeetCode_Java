/*Sort a linked list using insertion sort.*/
public class Q147_Insertion_Sort_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode unsort = head;
        ListNode sort = res;
        sort = sort.next;
        sort.next = null;
        unsort = unsort.next;
        while(unsort!=null) {
        	ListNode next = unsort.next;
        	unsort.next = null;
        	ListNode temp = sort;
        	while(temp!=null) {
        		if(unsort.val<temp.val) {
        			unsort.next = temp;
        			temp = unsort;
        		}
        		if(unsort.val>temp.val&&temp.next==null) {
        			temp.next = unsort;
        		} 
        		else if(unsort.val>temp.val&&unsort.val<temp.next.val) {
        			ListNode n = temp.next;
        			temp.next = unsort;
        			unsort.next = n;
        		}
        		else {
        			temp = temp.next;
        		}
        	}
        	unsort = next;
        }
        return res.next;
    }
	/********************************************************/
	public ListNode insertionSortList_0(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
	}
}
