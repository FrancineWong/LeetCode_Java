
public class Q328_Odd_Even_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode oddEvenList(ListNode head) {
		if(head==null) return null;
		ListNode odd = head;
		ListNode oddT = odd;
		ListNode even = head.next;
		ListNode evenT = even;
		while(oddT.next!=null&&evenT.next!=null) {
			ListNode nextO = oddT.next;
			ListNode nextE = evenT.next;
			oddT.next = nextO.next;
			oddT = nextO.next;
			evenT.next = nextE.next;
			evenT = nextE.next;
		}
		oddT.next = even;
        return odd;
    }
}
