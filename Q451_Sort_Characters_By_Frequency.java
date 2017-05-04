import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Q451_Sort_Characters_By_Frequency {
	//may have some problems
	public String frequencySort(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for(int i=0; i<s.length(); i++) {
        	map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        
        for(char c:map.keySet()) {
        	for(int i=0; i<map.get(c); i++) {
        		sb.insert(0, c);
        	}
        }
        
        return sb.toString();
    }
	//
	public String frequencySort_1(String s) {
		int[] freq = new int [256];
        for (char ch: s.toCharArray()) freq[ch]++;
        TreeMap<Integer, List<Character>> tree = new TreeMap<Integer, List<Character>>();
        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (!tree.containsKey(freq[i])) {
                    tree.put(freq[i], new LinkedList<Character>());
                }
                tree.get(freq[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(tree.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            for (Character ch: entry.getValue()) {
                sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
            }
        }
        return sb.toString();
	}
	public String frequencySort_0(String s) {
		HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(charFreqMap.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
	}
}
