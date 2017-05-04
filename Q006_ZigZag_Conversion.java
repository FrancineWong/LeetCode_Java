
public class Q006_ZigZag_Conversion {
	public String convert(String s, int numRows) {
		if(s==null) return null;
		if(numRows==1) return s;
        StringBuilder res = new StringBuilder();
        int pr = 2*numRows-2;
        int line = s.length()/pr+1;
        for(int i=0; i<numRows; i++) {
    		if(i==0) {
    			for(int j=0; j<line; j++) {
    				if(pr*j<s.length()) res.append(s.charAt(pr*j));
    			}	
    		}else if(i==numRows-1) {
    			for(int j=0; j<line; j++) {
    				if((pr*j+numRows-1)<s.length()) res.append(s.charAt(pr*j+numRows-1));
    			}
    		}else{
    			for(int j=0; j<line; j++) {
    				if((pr*j+i)<s.length()) res.append(s.charAt(pr*j+i));
    				if((pr*j+pr-i)<s.length()) res.append(s.charAt(pr*j+pr-i));
    			}
    		}
        }    
        return res.toString();
    }
	
	/*excellent solution*/
	//Create nRows StringBuffers, and keep collecting characters from original string to corresponding 
	//StringBuffer. Just take care of your index to keep them in bound.
	public String convert_0(String s, int nRows) {
		char[] c = s.toCharArray();
	    int len = c.length;
	    StringBuffer[] sb = new StringBuffer[nRows];
	    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
	    
	    int i = 0;
	    while (i < len) {
	        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
	            sb[idx].append(c[i++]);
	        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
	            sb[idx].append(c[i++]);
	    }
	    for (int idx = 1; idx < sb.length; idx++)
	        sb[0].append(sb[idx]);
	    return sb[0].toString();
	}
}
