import java.util.ArrayList;
import java.util.List;

/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]*/
public class Q131_Palindrome_Partitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        backtrack(s, res, new ArrayList<String>(), 0);
        return res;
    }
	
	public void backtrack(String s, List<List<String>> lists,List<String> cur,  int start) {
		int n = s.length();
		if(start>n) return;
		if(start == n) lists.add(new ArrayList<String>(cur));
		else {
			for(int i=start;i<n;i++){
	            if(isPalin(s.substring(start, i+1))){
	                cur.add(s.substring(start,i+1));
	                backtrack(s,lists, cur, i+1);
	                cur.remove(cur.size()-1);
	            }
	        }
		}
	}
	public boolean isPalin(String s) {
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	/**************************************************************************/
	List<List<String>> resultLst;
    ArrayList<String> currLst;
    public List<List<String>> partition_0(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
            && l>=s.length()){
                List<String> r = (ArrayList<String>) currLst.clone();
                resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
