import java.util.ArrayList;
import java.util.List;

/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/
public class Q077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> comb = new ArrayList<List<Integer>>();
        backtrack(comb, new ArrayList<Integer>(), 1, n, k);       
        return comb;
    }
    public void backtrack(List<List<Integer>> comb, List<Integer> temp, int start, int n, int k) {
		if(k==0) {
			comb.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=start;i<=n;i++) {
			temp.add(i);
			backtrack(comb, temp, i+1, n, k-1);
			temp.remove(temp.size()-1);
		}
	}
}
