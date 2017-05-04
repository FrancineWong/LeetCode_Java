
public class Q520_Detect_Capital {
	public boolean detectCapitalUse(String word) {
		int cnt = 0;
		for(char c : word.toCharArray()) if('Z'-c>=0) cnt ++;
		return ((cnt==0||cnt==word.length()))||(cnt==1&&'Z'-word.charAt(0)>=0);
    }
	public boolean detectCapitalUse_0(String word) {
		//http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
		return word.matches("[A-Z]+[a-z]+[A-Z][a-z]");
	}
}
