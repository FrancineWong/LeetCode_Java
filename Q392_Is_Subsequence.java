
public class Q392_Is_Subsequence {
	public boolean isSubsequence(String s, String t) {
	    for (int sIdx = 0, tIdx = -1, len = s.length(); sIdx < len;)
	        if ((tIdx = t.indexOf(s.charAt(sIdx++), ++tIdx)) == -1) return false;
	    return true;
	}
	public boolean isSubsequence_0(String s, String t) 
    {
        if(t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1) return false;
            prev++;
        }
        
        return true;
    }
	public boolean IsSubsequence_1(String s, String t) 
    {
        int count = 0;
        for (int i = 0; i < t.length() && count < s.length(); i++)
        {
            if (s.charAt(count) == t.charAt(i)) count++;
        }
        return count == s.length();
    }
}
