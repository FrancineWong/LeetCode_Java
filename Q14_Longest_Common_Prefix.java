/*Write a function to find the longest common prefix string amongst an array of strings.*/
public class Q14_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
		StringBuilder pref = new StringBuilder();
        if(strs.length==0) return ""; 
        if(strs.length==1) return strs[0];
        for(int i=0; i<strs.length; i++) {
            if(strs[i].length()==0) return "";
        }
        int minLen = 0;
        for(int i=0; i<strs.length; i++) {
        	if(strs[i].length()<=minLen) minLen = strs[i].length();
        }
        int index = strs[0].length();
        while(index<minLen) {
        	for(int i=0; i<strs.length; i++) {
        		if(strs[0].charAt(index)!=strs[i].charAt(index)) return pref.toString();;
        	}
        	pref.append(strs[0].charAt(index++));
        }
        return pref.toString();
    }
}
