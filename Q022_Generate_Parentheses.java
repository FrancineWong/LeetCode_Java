import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]*/
//back tracking: general solution to find all possible answers
/*procedure bt(c)
  if reject(P,c) then return
  if accept(P,c) then output(P,c)
  s ← first(P,c)
  while s ≠ Λ do
    bt(s)
    s ← next(P,s)*/
public class Q022_Generate_Parentheses {
	
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
	
	public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
	/*The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1 too many close).
	 *  Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. Each of these steps are 
	 *  recursively called.*/
	public Set<String> generateParens_0(int n) {
		Set<String> set = new HashSet<String>();
		if(n==0) set.add("");
		else {
			Set<String> prev = generateParens_0(n-1);
			for(String str:prev) {
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)=='(') {
						String s = insertInside(str, i);
						set.add(s);
					}
				}
				set.add("()"+str);
			}
		}
		return set;
	}
	public String insertInside(String str, int leftIndex) {
		String left = str.substring(0, leftIndex + 1);
		String right = str.substring(leftIndex + 1, str.length());
		return left + "()" + right;
	}
}
