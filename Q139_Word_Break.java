import java.util.List;

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s 
 * can be segmented into a space-separated sequence of one or more dictionary words. You may assume the 
 * dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the 
code definition to get the latest changes.

*/
public class Q139_Word_Break {
	//list of dictionary: wordDict
	public boolean wordBreak(String s, List<String> wordDict) {
		if(s==null) return false;
		return wordBreak(s, wordDict, 0);
    }
	public boolean wordBreak(String s, List<String> wordDict, int start) {
		if(start==s.length()-1) return true;
		else {
			return wordBreak(s, wordDict, start)&&wordBreak(s, wordDict, start);
		}
	}
	/**********************    DP in two ways    *************************/
	public boolean wordBreak_0(String s, List<String> wordDict) {
		boolean[] f = new boolean[s.length() + 1];    
        f[0] = true;
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/      
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }   
        return f[s.length()];
	}
}
