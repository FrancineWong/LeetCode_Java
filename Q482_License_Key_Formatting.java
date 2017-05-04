
public class Q482_License_Key_Formatting {
	public String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();
        
        for(int i = S.length() -1; i>=0; i--) {
        	if(S.charAt(i)!='-') {
        		res.append(res.length()%(K+1)==K?'-':"").append(S.charAt(i));
        	}
        }
        
        return res.reverse().toString().toUpperCase();
    }
}
