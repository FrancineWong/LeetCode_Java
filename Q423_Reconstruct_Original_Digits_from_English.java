
public class Q423_Reconstruct_Original_Digits_from_English {
	//字符统计，枚举
	//zero one two three four five six seven eight nine
	//z         w          u         x         g         unique we can confirm the numbers of these numbers
	//   o o     o        o                              we can know the number of one's from o
	//              h                          h         we can get the number of three
	//                    f    f                         we can get the number of five
	//                              s     s              we can get the number of seven
	//                         i     i         i    i    we can get the number of nice
	public String originalDigits(String s) {
		int[] count = new int[10];
	    for (int i = 0; i < s.length(); i++){
	        char c = s.charAt(i);
	        if (c == 'z') count[0]++;
	        if (c == 'w') count[2]++;
	        if (c == 'x') count[6]++;
	        if (c == 's') count[7]++; //7-6
	        if (c == 'g') count[8]++;
	        if (c == 'u') count[4]++; 
	        if (c == 'f') count[5]++; //5-4
	        if (c == 'h') count[3]++; //3-8
	        if (c == 'i') count[9]++; //9-8-5-6
	        if (c == 'o') count[1]++; //1-0-2-4
	    }
	    count[7] -= count[6];
	    count[5] -= count[4];
	    count[3] -= count[8];
	    count[9] = count[9] - count[8] - count[5] - count[6];
	    count[1] = count[1] - count[0] - count[2] - count[4];
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i <= 9; i++){
	        for (int j = 0; j < count[i]; j++){
	            sb.append(i);
	        }
	    }
        return sb.toString();
    }
}
