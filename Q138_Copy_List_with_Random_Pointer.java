import java.util.HashMap;

/*A linked list is given such that each node contains an additional random pointer which could point to any 
 * node in the list or null.
 * Return a deep copy of the list.*/


public class Q138_Copy_List_with_Random_Pointer {
	
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
	/*An intuitive solution is to keep a hash table for each node in the list, via which we just need to 
	 * iterate the list in 2 rounds respectively to create nodes and assign the values for their random pointers. 
	 * As a result, the space complexity of this solution is O(N), although with a linear time complexity.
	 * 
	 * As an optimised solution, we could reduce the space complexity into constant. The idea is to associate 
	 * the original node with its copy node in a single linked list. In this way, we don't need extra space to 
	 * keep track of the new nodes.
	 * 
	 * The algorithm is composed of the follow three steps which are also 3 iteration rounds.
	 * Iterate the original list and duplicate each node. The duplicate of each node follows its original 
	 * immediately.
	 * Iterate the new list and assign the random pointer for each duplicated node.
	 * Restore the original list and extract the duplicated nodes.*/
	
	public RandomListNode copyRandomList(RandomListNode head) {
		/*第一遍，对每个node进行复制，并插入其原始node的后面，新旧交替，变成重复链表。如：原始：1->2->3->null，
		 * 复制后：1->1->2->2->3->3->null
		 * 
		 * 第二遍，遍历每个旧node，把旧node的random的复制给新node的random，因为链表已经是新旧交替的。所以复制方法为：
                                      node.next.random = node.random.next
             前面是说旧node的next的random，就是新node的random，后面是旧node的random的next，正好是新node，是从旧random复制来的。
         * 第三遍，则是把新旧两个表拆开，返回新的表即可。

 */
		RandomListNode iter = head, next;
		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			next = iter.next;
			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;
			iter = next;
		}
		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}
		// Third round: restore the original list, and extract the copy list.
		iter = head;
		RandomListNode pseudoHead = new RandomListNode(0);
		RandomListNode copy, copyIter = pseudoHead;
		while (iter != null) {
			next = iter.next.next;
			// extract the copy
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;
			// restore the original list
			iter.next = next;
			iter = next;
		}
		return pseudoHead.next;
    }
	/*第一种方法，就是使用HashMap来坐，HashMap的key存原始pointer，value存新的pointer。
	 * 第一遍，先不copy random的值，只copy数值建立好新的链表。并把新旧pointer存在HashMap中。
	 * 第二遍，遍历旧表，复制random的值，因为第一遍已经把链表复制好了并且也存在HashMap里了，所以只需从HashMap中，
	 * 把当前旧的node.random作为key值，得到新的value的值，并把其赋给新node.random就好。
	 */
	public RandomListNode copyRandomList_0(RandomListNode head) {
        if(head==null)
            return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode newhead = new RandomListNode(head.label);
        map.put(head,newhead);
        RandomListNode oldp = head.next;
        RandomListNode newp = newhead;
        while(oldp!=null){
            RandomListNode newnode = new RandomListNode(oldp.label);
            map.put(oldp,newnode);
            newp.next = newnode;
            oldp = oldp.next;
            newp = newp.next;
        }
        oldp = head;
        newp = newhead;
        while(oldp!=null){
            newp.random = map.get(oldp.random);
            oldp = oldp.next;
            newp = newp.next;
        }
        return newhead;
    }
}
