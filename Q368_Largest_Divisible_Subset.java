import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements 
 * in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]*/
public class Q368_Largest_Divisible_Subset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] count = new int[n];
		int[] pre = new int[n];
		Arrays.sort(nums);
		int max = 0, index = -1;
		for(int i=0; i<n; i++) {
			count[i] = 1;
			pre[i] = -1;
			for(int j=i-1; j>=0; j--) {
				if(nums[i]%nums[j]==0) {
					if(1+count[j]>count[i]) {
						count[i] = count[j]+1;
						pre[i] = j;
					}
				}
			}
			if(count[i]>max) {
				max = count[i];
				index = i;
			}
		}
        List<Integer> list = new ArrayList<>();
        while(index!=-1) {
        	list.add(nums[index]);
        	index  = pre[index];
        }
        return list;
    }
}
