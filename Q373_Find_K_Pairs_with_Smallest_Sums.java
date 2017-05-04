import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]*/
public class Q373_Find_K_Pairs_with_Smallest_Sums {
	class Pair{
		int[] pair;
		int idx; //current index to nums2
		long sum;
		Pair(int idx, int n1, int n2) {
			this.idx = idx;
			pair = new int[] {n1, n2};
		}
	}
	class CompPair implements Comparator<Pair> {
		public int compare(Pair p1, Pair p2) {
			return Long.compare(p1.sum, p2.sum);
		}
	}
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0) return list;
        int len1 = nums1.length, len2 = nums2.length;
        PriorityQueue<Pair> q = new PriorityQueue(k, new CompPair());
        for(int i=0; i<nums1.length&&i<k; i++) {//only need first k numbers
        	q.offer(new Pair(0, nums1[i], nums2[0]));
        }
        for(int i=1; i<=k&&!q.isEmpty(); i++) { //get the first k sums
        	Pair p = q.poll();
        	list.add(p.pair);
        	if(p.idx<len2-1) {//get to next value in nums2
        		int next = p.idx+1;
        		q.offer(new Pair(next, p.pair[0], nums2[next]));
        	}
        }
        return list;
    }
	/**************************************************/
	/*
	 * Basic idea: Use min_heap to keep track on next minimum pair sum, and we only need to maintain K possible 
	 * candidates in the data structure.
	 * Some observations: For every numbers in nums1, its best partner(yields min sum) always strats from 
	 * nums2[0] since arrays are all sorted; And for a specific number in nums1, its next candidate sould 
	 * be [this specific number] + nums2[current_associated_index + 1], unless out of boundary;)
	 * */
	public List<int[]> kSmallestPairs_0(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
		List<int[]> res = new ArrayList<>();
		if(nums1.length==0||nums2.length==0||k==0) return res;
		for(int i=0; i<nums1.length&&i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0}); //last value maintain the index
		while(k-->0&&!que.isEmpty()) {
			int[] cur = que.poll();
			res.add(new int[]{cur[0], cur[1]});
			if(cur[2]==nums2.length-1) continue;
			que.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
		}
		return res;
	}
}
