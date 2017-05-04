import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where 
 * the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]*/
/*A general approach to backtracking questions in Java (Subsets, Permutations, Combination Sum, Palindrome Partitioning)
 * URL: https://discuss.leetcode.com/topic/46161/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning*/
public class Q040_Combination_Sum_II {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<>(), candidates, target, 0);
		return res;
    }
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList)); //You need to create a COPY of templist before adding it. 
	    //As you see templist keeps getting passed on as an argument and keeps getting modified. If you just add templist, 
	    //all the modifications you make to templist get reflected in the final list.
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i+1); 
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
}
