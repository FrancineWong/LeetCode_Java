import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 *  not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.*/
public class Q215_Kth_Largest_Element_in_an_Array {
	/***You can take a couple of approaches to actually solve it:
	 * O(N lg N) running time + O(1) memory
	 * The simplest approach is to sort the entire input array and then access the element by it's index 
	 * (which is O(1)) operation:
	 * O(N lg K) running time + O(K) memory

	 *****/
	public int findKthLargest(int[] nums, int k) {
		final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
	/*********Other possibility is to use a min oriented priority queue that will store the K-th largest values. 
	 * The algorithm iterates over the whole input and maintains the size of priority queue.
	 * ***
	 * O(N) best case / O(N^2) worst case running time + O(1) memory*******/
	public int findKthLargest_0(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
	/*The smart approach for this problem is to use the selection algorithm (based on the partion method - 
	 * the same one as used in quicksort).
*/
	public int findKthLargest_1(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
    /*So how can we improve the above solution and make it O(N) guaranteed? The answer is quite simple,
     *  we can randomize the input, so that even when the worst case input would be provided the algorithm
     *   wouldn't be affected. So all what it is needed to be done is to shuffle the input.*/
    public int findKthLargest_2(int[] nums, int k) {

        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
/****************************************************************/
    /*//second solution: use a vector to implement min_heap by yourself
//time complexity: O(n*logk + k)
//space complexity: O(k)
//run time: 13ms
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        vector<int> min_heap(k, 0);
        for (int i = 0; i < k; i++)
            min_heap[i] = nums[i];
        intializeHeap(min_heap);
        for (int i = k; i < nums.size(); i++) {
            if (min_heap[0] < nums[i])
                min_heap[0] = nums[i];
            rebuildHeap(min_heap, 0);
        }
        return min_heap[0];
    }
    
    void intializeHeap(vector<int>& min_heap) {
        if (min_heap.size() <= 1) return;
        int pos = ( min_heap.size() - 2 ) / 2;
        while (pos >= 0) {
            rebuildHeap(min_heap, pos); pos--;
        }
    }
    
    void rebuildHeap(vector<int>& min_heap, int i) {
        int j = 2 * i + 1;
        int k = 2 * i + 2;
        if (j >= min_heap.size()) return;
        if (k == min_heap.size()) {
            if (min_heap[j] < min_heap[i])
                swap(min_heap[j], min_heap[i]);
            return;
        }
        int min_val = i;
        if (min_heap[j] < min_heap[i])
            min_val = j;
        if (min_heap[k] < min_heap[min_val])
            min_val = k;
        if (min_val != i) {
            swap(min_heap[min_val], min_heap[i]);
            rebuildHeap(min_heap, min_val);
        }
    }
    
    void swap(int& a, int& b) {
        int tmp = a; a = b; b = tmp;
    }
};

*/
}
