import java.util.HashMap;

/*Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.*/

public class FirstUniqueChar {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> mark = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) mark.put(s.charAt(i), 0);
		for(int i=0; i<s.length(); i++) mark.put(s.charAt(i), mark.get(s.charAt(i))+1);
		for(int i=0; i<s.length(); i++){
			if(mark.get(s.charAt(i))==1) return i;
		}
		return -1;  
    }

}
