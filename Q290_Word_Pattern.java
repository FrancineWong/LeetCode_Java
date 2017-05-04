import java.util.HashMap;
import java.util.Map;

public class Q290_Word_Pattern {
	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if(pattern.length()!=strs.length) return false;
		Map mrk = new HashMap();
		for(Integer i=0; i<strs.length; i++) { //should put object into the map
			if(mrk.put(strs[i], i)!=mrk.put(pattern.charAt(i), i)) return false;
		}
        return true;
    }
	
	public boolean wordPattern_0(String pattern, String str) {
		
		String[] strs = str.split(" ");
		if(pattern.length()!=strs.length) return false;
		HashMap<Character, Integer> pa = new HashMap<Character, Integer>();
		HashMap<String, Integer> st = new HashMap<String, Integer>();
		
		for(Integer i=0; i<pattern.length(); i++) {
			if(st.put(strs[i], i)!=pa.put(pattern.charAt(i), i)) return false;
		}
		
		return true;
	}

}
