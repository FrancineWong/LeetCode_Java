/*Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.
Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/
public class Q151_Reverse_Words_in_a_String {
	public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+"); //\S - Matches anything but white-space characters.
        StringBuilder res = new StringBuilder();
        for( int i=split.length-1; i>0; i--) {
        	res.append(split[i]+" ");
        }
        res.append(split[0]);
        return res.toString();
    }
	/***********************************  in place   ******************************************/
//	public void reverseWords_0(String s) {
//	    reverse(s.begin(), s.end());
//	    int storeIndex = 0;
//	    for (int i = 0; i < s.size(); i++) {
//	        if (s[i] != ' ') {
//	            if (storeIndex != 0) s[storeIndex++] = ' ';
//	            int j = i;
//	            while (j < s.size() && s[j] != ' ') { s[storeIndex++] = s[j++]; }
//	            reverse(s.begin() + storeIndex - (j - i), s.begin() + storeIndex);
//	            i = j;
//	        }
//	    }
//	    s.erase(s.begin() + storeIndex, s.end());
//	}
	public String reverse(String s) {
		StringBuilder rev = new StringBuilder();
		for(int i=s.length()-1; i>=0; i--) rev.append(s.charAt(i));
		return rev.toString();
	}
}
