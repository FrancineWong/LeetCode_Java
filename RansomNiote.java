//Given an arbitrary ransom note string and another string containing letters from all the magazines, 
//write a function that will return true if the ransom note can be constructed from the magazines ; 
//otherwise, it will return false.
//
//Each letter in the magazine string can only be used once in your ransom note.


public class RansomNiote {
	public boolean canConstruct(String ransomNote, String magazine) {
        int[] bRan = new int[26];
        int[] bMag = new int[26];
        if(ransomNote.length()>magazine.length()) return false;
        for(int i=0; i<ransomNote.length(); i++){
        	bRan[ransomNote.charAt(i)-97]++;
        }
        for(int j=0; j<magazine.length(); j++){
        	bMag[magazine.charAt(j)-97]++;
        }
        for(int k=0; k<26; k++){
        	if(bRan[k]>bMag[k]) return false;
        }
        return true;
    }
}
