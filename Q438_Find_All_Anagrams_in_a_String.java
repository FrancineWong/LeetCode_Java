import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger 
than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/


public class Q438_Find_All_Anagrams_in_a_String {
	
	//run time expired
	
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> index = new ArrayList<Integer>();
        int len_s = s.length();
        int len_p = p.length();
        
        for(int i=0; i<len_s-len_p+1; i++){
        	String temp = s.substring(i, i+len_p);
        	if(isAnagram(p, temp)) index.add(i);
        }
        return index;
    }
	
	public boolean isAnagram(String tr, String pn) {
		int[] tr_b = new int[26];
		int[] pn_b = new int[26];
		for(int i=0; i<tr.length(); i++) tr_b[tr.charAt(i)-'a']++;
		for(int j=0; j<pn.length(); j++) pn_b[pn.charAt(j)-'a']++;
		return Arrays.equals(tr_b, pn_b);
	}
	
	@Test
	public void test() {
		assertEquals(true, isAnagram("abc", "cab"));
		assertEquals(false, isAnagram("", "abc"));
	}
	
	//slide window solution
	public List<Integer> findAnagrams_1(String s, String p) {
		List<Integer> index = new ArrayList<Integer>();
		
		int[] pMap = new int[26];
		for(int i=0; i<p.length(); i++) pMap[p.charAt(i)-'a']++;
		
		int count = p.length(), left = 0, right = 0;
		while(right<s.length()){
			if(pMap[s.charAt(right)-'a']>=1) count--;
			pMap[s.charAt(right++)-'a']--;
			if(count==0) index.add(left);
			
			if (right-left == p.length() ) {
	            if (pMap[s.charAt(left)-'a'] >= 0) {
	                count++;
	            }
	            pMap[s.charAt(left)-'a']++;
	            left++;
	        }	
		}
		
		return index;
	}
	
}














