
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QKeyboardRow {
	public String[] findWords(String[] words) {
		List<String> res = new ArrayList<String>();
        for( int i=0; i<words.length; i++) {
        	if(containsInLine(words[i])) res.add(new String(words[i]));
        }
        String[] realRes = new String[res.size()];
        for( int i=0; i<res.size(); i++) {
        	realRes[i] = new String(res.get(i));
        }
        return realRes;
    }
	public boolean containsInLine(String word) {
		Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
		map.put(1, Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
		map.put(2, Arrays.asList('a','s','d','f','g','h','j','k','l'));
		map.put(3, Arrays.asList('z','x','c','v','b','n','m'));
		int index = 0;
		for( int i = 1; i<=3; i++) {
			List<Character> temp = map.get(i);
			if(temp.contains(toLowCase(word.charAt(0)))) index = i;
		}
		for( int i=1; i<word.length(); i++) {
			//not the same line as word[1]
			List<Character> temp = map.get(index);
			if(!temp.contains(toLowCase(word.charAt(i)))) return false; 
		}
		return true;
	}
	public Character toLowCase(char c) {
		if(c>=65&&c<=90) c = (char)(c+32);
		return c;
	}
}
