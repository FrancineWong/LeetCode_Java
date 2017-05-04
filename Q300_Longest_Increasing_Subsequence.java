import java.util.Arrays;

/*Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more 
than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?*/
public class Q300_Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
        int len = 0;
        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }
        return len;
    }
	/*public static int binarySearch(long[] a,
               int fromIndex,
               int toIndex,
               long key)
    Parameters:
	a - the array to be searched
	fromIndex - the index of the first element (inclusive) to be searched
	toIndex - the index of the last element (exclusive) to be searched
	key - the value to be searched for
	Returns:
	index of the search key, if it is contained in the array within the specified range; otherwise,
	 (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted 
	 into the array: the index of the first element in the range greater than the key, or toIndex if all 
	 elements in the range are less than the specified key. Note that this guarantees that the return value 
	 will be >= 0 if and only if the key is found.
    */
	/*****************************************************************************/
/*tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6
We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.

Each time we only do one of the two:

(1) if x is larger than all tails, append it, increase the size by 1
(2) if tails[i-1] < x <= tails[i], update tails[i]*/
	public int lengthOfLIS_0(int[] nums) {
	    int[] tails = new int[nums.length];
	    int size = 0;
	    for (int x : nums) {
	        int i = 0, j = size;
	        while (i != j) {
	            int m = (i + j) / 2;
	            if (tails[m] < x)
	                i = m + 1;
	            else
	                j = m;
	        }
	        tails[i] = x;
	        if (i == size) ++size;
	    }
	    return size;
	}
}
