import java.util.ArrayList;
import java.util.List;

/*Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/
public class Q078_Subsets {
	public List<List<Integer>> subsets_0(int[] nums) {
        return getSubsets(nums, 0);
    }
	public List<List<Integer>> getSubsets(int[] nums, int index) {
		List<List<Integer>> allSubsets = new ArrayList<List<Integer>>();
        int size = nums.length;
        if(size==index) {
        	allSubsets = new ArrayList<List<Integer>>();
        	allSubsets.add(new ArrayList<Integer>()); //empty set
        } else {
        	allSubsets = getSubsets(nums, index++);
        	List<List<Integer>> moreSubsets = new ArrayList<List<Integer>>();
        	for(List<Integer> subset : allSubsets) {
        		List<Integer> newSubset = new ArrayList<Integer>();
        		newSubset.addAll(subset);
        		newSubset.add(nums[index]);
        		moreSubsets.add(newSubset);
        	}
        	allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
	}
	/*******************************************************************************************/
	
	public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> allsubsets = new ArrayList<List<Integer>>();
        int max = 1<<nums.length; //compute 2^n
        for(int i = 0; i<max; i++) {
        	List<Integer> subset = convertIntToSet(i, nums);
        	allsubsets.add(subset);
        }
        return allsubsets;
    }
	
	public List<Integer> convertIntToSet(int x, int[] nums) {
		List<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for(int k=x; k>0; k>>=1) {
			if((k&1)==1) {
				subset.add(nums[index]);
			}
			index++;
		}
		return subset;
	}
}
