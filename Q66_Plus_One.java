/*Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.*/
public class Q66_Plus_One {
	public int[] plusOne(int[] digits) {
		int cr = 1;
		boolean all_9 = true;
		for(int i=0; i<digits.length; i++){
			if(digits[i]!=9) all_9 = false;
		}
		if(all_9){
			int[] newDig = new int[digits.length+1];
			newDig[0] = 1;
	        return newDig;
		}else{
			for(int j=digits.length-1; j>=0; j--){
				int temp = digits[j];
				digits[j] = (temp+cr)%10;
				cr = (temp+cr)/10;
				if(cr==0) return digits;
			}
			return digits;
		}
    }
}
