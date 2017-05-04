import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
public class Q090_Subsets_II {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> allSubsets = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(nums, allSubsets, new ArrayList<Integer>(), 0);
		return allSubsets;
    }
	
	public void backtrack(int[] nums, List<List<Integer>> allSubsets, List<Integer> temp, int start) {
		allSubsets.add(new ArrayList<Integer>(temp));
		for (int i=start; i<nums.length; i++) {
			if(i>start&&nums[i]==nums[i-1]) continue;
			temp.add(nums[i]);
			backtrack(nums, allSubsets, temp, start+1);
			temp.remove(temp.size()-1);
		}
	}
}
