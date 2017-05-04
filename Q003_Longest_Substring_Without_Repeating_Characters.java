import java.util.HashSet;

/*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" 
is a subsequence and not a substring.*/
public class Q003_Longest_Substring_Without_Repeating_Characters {
	//hashtable, two pointers, string
	public int lengthOfLongestSubstring(String s) {
        int max = 0, i = 0, j = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
