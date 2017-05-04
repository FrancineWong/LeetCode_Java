import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.*/
public class Q17_Letter_Combinations_of_a_Phone_Number {
	/*****************************FIFO**************************************/
	public List<String> letterCombinations_0(String digits) {
	/*This is a iterative solution. For each digit added, remove and copy every element in the queue and 
	 * add the possible letter to each element, then add the updated elements back into queue again. 
	 * Repeat this procedure until all the digits are iterated.

	I did a experiment to compare backtracking(DFS) method and this iterative method. It turns out iterative 
	one is 4 times faster. */
	    LinkedList<String> ans = new LinkedList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	        	//The java.util.LinkedList.peek() method retrieves, but does not remove, the head (first element) of this list.
	            String t = ans.remove(); 
	            /*The java.util.LinkedList.remove() method retrieves and removes the head (first element) of this list.*/
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}
	
	/*********************************       Backtracking      ******************************************/
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
        if(digits==null||digits.length()==0) return res;
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        backtrack(digits, new StringBuilder(), res, map, 0);
        
        return res;
    }
	
	public void backtrack(String digits, StringBuilder temp, List<String> res, Map<Integer, String> map, int index) {
		if(index == digits.length()) {
		    StringBuilder copy = new StringBuilder(temp);
		    res.add(copy.toString());
		} else {
			String dMap = map.get(digits.charAt(index)-'0');
			for(int i = 0; i<dMap.length(); i++) {
				temp.append(dMap.charAt(i));
				backtrack(digits, temp, res, map, index+1);
				temp.deleteCharAt(temp.length()-1);
			}
		}
	}
}
