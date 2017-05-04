
/*Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level 
revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37*/
public class Q165_Compare_Version_Numbers {
	/*By "bigger" I mean "newer".
	In this example of version numbers of "2.105" and "2.22", their major numbers are both "2". And for the 
	minor numbers, "105" is bigger than "22". Since the version number always increases for each product 
	release, version "2.105" is released after "2.22". So "2.105" is the later release.
	Therefore for this problem, compareVersion("2.105", "2.22") should return 1.*/
	public int compareVersion(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
	    String[] levels2 = version2.split("\\.");
	    
	    int length = Math.max(levels1.length, levels2.length);
	    for (int i=0; i<length; i++) {
	    	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
	    	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
	    	int compare = v1.compareTo(v2);
	    	if (compare != 0) {
	    		return compare;
	    	}
	    }
	    
	    return 0;
    }
}
