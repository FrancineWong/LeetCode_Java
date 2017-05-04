import java.util.HashMap;
import java.util.HashSet;

/*Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every 
 * character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.*/
public class Q395_Longest_Substring_with_At_Least_K_Repeating_Characters {
	//divide and conquer
	/*统计原始字符串s中各字符的出现次数，统计其中出现次数少于k次的字符，得到数组filters。
	若filters为空数组，则直接返回s的长度。
	以filters为分隔符，将s拆分为若干子串，分别递归计算各子串的结果，返回最大值。*/
	public int longestSubstring(String s, int k) {
	    char[] str = s.toCharArray();
	    return helper(str,0,s.length(),k);
	}
	private int helper(char[] str, int start, int end,  int k){
	    if(end-start<k) return 0;//substring length shorter than k.
	    int[] count = new int[26];
	    for(int i = start;i<end;i++){
	        int idx = str[i]-'a';
	        count[idx]++;
	    }
	    for(int i = 0;i<26;i++){
	        if(count[i]<k&&count[i]>0){ //count[i]=0 => i+'a' does not exist in the string, skip it.
	            for(int j = start;j<end;j++){
	                if(str[j]==i+'a'){
	                    int left = helper(str,start,j,k);
	                    int right = helper(str,j+1,end,k);
	                    return Math.max(left,right);
	                }
	            }
	        }
	    }
	    return end-start;
	}
	/*先统计出字符串中每个字符出现的次数，对于出现次数少于k的字符，任何一个包含该字符的字符串都不是符合要求的子串，因此这样的字符就是分隔符，
	 * 应该以这些出现次数少于k次的字符做分隔符打断原字符串，然后对各个打断得到的字符串进行递归统计，得到最长的符合要求的字符串。如果一个字符
	 * 串中不包含分隔符(即每个字符出现的次数都达到了k次及以上次数)，那么这个字符串就是符合要求的子串。*/
	public int longestSubstring_0(String s, int k) {
        if(k<=1){
            return s.length();
        }
        
        int[] repeat=new int['z'+1];
        for(int i=0;i<s.length();i++){
            repeat[s.charAt(i)]++;
        }
        StringBuilder regex=new StringBuilder("");
        boolean firstSplit=true;
        for(int i='a';i<='z';i++){
            if(repeat[i]>0&&repeat[i]<k){
                if(firstSplit){
                    regex.append((char)i);
                    firstSplit=false;
                }
                else{
                    regex.append("|"+(char)i);
                }
            }
        }
        if(regex.length()>0){
            //说明有分隔符
            String[] strs=s.split(regex.toString());
            int max=0;
            int tmpAns=0;
            for(String str:strs){
                tmpAns=longestSubstring(str, k);
                if(tmpAns>max){
                    max=tmpAns;
                }
            }
            return max;
        }
        else{
            //没有分隔符,说明s中的每一个字符出现的次数都大于等于k
            return s.length();
        }
    }
	public int longestSubstring_1(String s, int k) {
	    HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
	 
	    for(int i=0; i<s.length(); i++){
	 
	        char c = s.charAt(i);
	        if(counter.containsKey(c)){
	            counter.put(c, counter.get(c)+1);
	        }else{
	            counter.put(c, 1);
	        }
	 
	    }
	 
	    HashSet<Character> splitSet = new HashSet<Character>();
	    for(char c: counter.keySet()){
	        if(counter.get(c)<k){
	            splitSet.add(c);
	        }
	    }
	 
	    if(splitSet.isEmpty()){
	        return s.length();
	    }
	 
	    int max = 0;
	    int i=0, j=0;
	    while(j<s.length()){
	        char c = s.charAt(j);
	        if(splitSet.contains(c)){
	            if(j!=i){
	                max = Math.max(max, longestSubstring(s.substring(i, j), k));
	            }
	            i=j+1;
	        }
	        j++;
	    }
	 
	    if(i!=j)
	         max = Math.max(max, longestSubstring(s.substring(i, j), k));
	 
	    return max;
	}
}
