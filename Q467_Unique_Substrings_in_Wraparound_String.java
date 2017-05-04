

public class Q467_Unique_Substrings_in_Wraparound_String {
	/*1. The max number of unique substring ends with a letter equals to the length of max contiguous substring ends with 
	 * that letter. 
	 * 2. If there are overlapping, we only need to consider the longest one because it covers all the possible substrings,
	 * 3. No matter how long is a contiguous substring in p, it is in s has infinite length
	 * 4. Now we know the max number of unique substrings in p ends with 'a, 'b, 'c.....'z; and those substrings are all in
	 * s,
	 * 
	 * */
	public int findSubstringInWraproundString(String p) {
        //count[i] is th maximum unique substring end with ith letter
		//0-'a, 1-'b,... 25-'z
		int[] count = new int[26];
		//store longest contiguous substring ends at current position
		int maxLengthCur = 0;
		for(int i=0; i<p.length(); i++) {
			if(i>0&&(p.charAt(i)-p.charAt(i-1)==1||(p.charAt(i-1)-p.charAt(i)==25))) {
				maxLengthCur++;
			} else maxLengthCur = 1;
			int index = p.charAt(i) - 'a';
			count[index] = Math.max(count[index], maxLengthCur);
		}
		//sum to get result
		int sum = 0;
		for(int i=0; i<26; i++) sum += count[i];
		return sum;
    }
}
