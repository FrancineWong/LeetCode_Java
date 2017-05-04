import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA 
molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].*/
public class Q187_Repeated_DNA_Sequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		if(s.length()<=10) return list;
		for( int i=0; i<s.length()-9; i++) {
			String cur = s.substring(i, i+10);
			if(!set.add(cur)) {
			    if(!list.contains(cur)) list.add(cur);
			}
		}
        return list;
    }
	/******************************************************************************************************/
	public List<String> findRepeated(String s) {
		Set<Integer> words = new HashSet<>();
	    Set<Integer> doubleWords = new HashSet<>();
	    List<String> rv = new ArrayList<>();
	    char[] map = new char[26];
	    //map['A' - 'A'] = 0;
	    map['C' - 'A'] = 1;
	    map['G' - 'A'] = 2;
	    map['T' - 'A'] = 3;

	    for(int i = 0; i < s.length() - 9; i++) {
	        int v = 0;
	        for(int j = i; j < i + 10; j++) {
	            v <<= 2;
	            v |= map[s.charAt(j) - 'A']; //convert string to value
	        }
	        if(!words.add(v) && doubleWords.add(v)) {
	            rv.add(s.substring(i, i + 10));
	        }
	    }
	    return rv;
	}
}
