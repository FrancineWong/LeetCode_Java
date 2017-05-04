import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*Given a string and a string dictionary, find the longest string in the dictionary that can be formed by 
 * deleting some characters of the given string. If there are more than one possible results, return the longest 
 * word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.*/
public class Q524_Longest_Word_in_Dictionary_through_Deleting {
	public String findLongestWord_1(String s, List<String> d) {
	    Collections.sort(d, (a,b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
	    for (String dictWord : d) {
	        int i = 0;
	        for (char c : s.toCharArray()) 
	            if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
	        if (i == dictWord.length()) return dictWord;
	    }
	    return "";
	}
	/***********************************************************/
	public String findLongestWord_2(String s, List<String> d) {
	    String longest = "";
	    for (String dictWord : d) {
	        int i = 0;
	        for (char c : s.toCharArray()) 
	            if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

	        if (i == dictWord.length() && dictWord.length() >= longest.length()) 
	            if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
	                longest = dictWord;
	    }
	    return longest;
	}
	/*********************************************************************/
	public String findLongestWord(String s, List<String> d) {
		int max = 0;
		String res = "";
		for (String str : d) {
			int id = -1;
			boolean find = true;
			for (char c : str.toCharArray()) {
				id = s.indexOf(c, id+1);
				if (id == -1) {
					find = false;
					break;
				}
			}
			if (find){
				if (str.length() > max){
					max = str.length();
					res = str;
				}else if (str.length() == max) {
					for (int i = 0; i < res.length(); i++) {
						if (str.charAt(i) == res.charAt(i)) continue;
						if (str.charAt(i) < res.charAt(i)) res = str;
						break;
					}
				}
			}
		}
		return res;
	}
	/*****************************************************************/
	public String findLongestWord_0(String s, List<String> d) {
        PriorityQueue<String> queue = new PriorityQueue<String>();
        if(d==null) return new String();
        for(int i=0; i<d.size(); i++) {
            String cur = minStrs(s, d.get(i));
            String bfr = queue.peek();
            if(bfr==null) queue.offer(cur);
            else if(cur.length()==bfr.length()) queue.offer(cur);
            else if(cur.length()>bfr.length()) {
                queue.poll();
                queue.offer(cur);
            }
        }
        return queue.poll();
    }
    public String minStrs(String t, String p) {
        StringBuilder min = new StringBuilder();
        int index_t = 0, index_p = 0;
        while(index_t<t.length()&&index_p<p.length()){
            if(t.charAt(index_t)!=p.charAt(index_p)) index_t++;
            else {
                min.append(p.charAt(index_p++));
                index_t++;
            }
        }
        return min.toString();
    }
}
