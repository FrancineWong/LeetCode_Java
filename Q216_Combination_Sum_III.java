import java.util.ArrayList;
import java.util.List;

/*Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 
 * can be used and each combination should be a unique set of numbers.
Example 1:
Input: k = 3, n = 7
Output:
[[1,2,4]]
Example 2:
Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]*/
public class Q216_Combination_Sum_III {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
		backtrack(k, n, lists, new ArrayList<Integer>(), 0, 0);
        return lists;
    }
    public void backtrack(int k, int n, List<List<Integer>> lists,List<Integer> cur, int start, int sum) {
		if(start>k) return;
		if(sum==n&&start==k) lists.add(new ArrayList<Integer>(cur));
		else {
			int max = n>9?9:n;
			for( int i = 1; i<=max; i++) {
			    if(cur.contains(i)) break;
				cur.add(i);
				backtrack(k, n, lists, cur, start+1, sum+i);
				cur.remove(cur.size()-1);
			}
		}
	}
}
