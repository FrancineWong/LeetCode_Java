import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
public class Q046_Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(result, new ArrayList<>(), nums);
		return result;
    }
	public void backtrack(List<List<Integer>> result,  List<Integer> temp, int[] nums) {
		if(temp.size()==nums.length) result.add(new ArrayList<Integer>(temp));
		else {
			for(int i = 0; i<nums.length; i++) {
				if(temp.contains(nums[i])) continue;
				temp.add(nums[i]);
				backtrack(result, temp, nums);
				temp.remove(temp.size()-1);
			}
		}
	}
}
