import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/*Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.*/
public class Q049_Group_Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if(strs==null || strs.length == 0){
			return new ArrayList<List<String>>();
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		//Arrays.sort(strs);
		for (String s:strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if(!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}
		
		for(String key: map.keySet()) {
			Collections.sort(map.get(key));
		}
		return new ArrayList<List<String>>(map.values());
    }
	
	public boolean isAnagram(String a, String b) {
		if(a.length()!=b.length()) return false;
		else {
			Map<Character, Integer> mapA = new HashMap<Character, Integer>();
			for(int i=0; i<a.length(); i++) mapA.put(a.charAt(i), mapA.getOrDefault(a.charAt(i), 0)+1);
			for(int j=0; j<b.length(); j++) mapA.replace(b.charAt(j), mapA.get(b.charAt(j))-1);
			for(Integer i:mapA.values()) if(i!=0) return false;
		}
		return true;
	}
	
	@Test
	public void test() {
		assertEquals(true, isAnagram("abc", "bac"));
	}
	
}
