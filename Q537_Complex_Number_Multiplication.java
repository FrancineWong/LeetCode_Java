import java.util.stream.Stream;

public class Q537_Complex_Number_Multiplication {
	public String complexNumberMultiply(String a, String b) {
        int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(),
        		coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        return (coefs1[0]*coefs2[0]-coefs1[1]*coefs2[1])+"+"+(coefs1[0]*coefs2[1]+coefs1[1]*coefs2[0])+"i";
    }
	
	public String complexNumberMultiply_0(String a, String b) {
		int[] coef = Stream.of((a+b).split("\\+|i")).mapToInt(Integer::parseInt).toArray();
		return (coef[0]*coef[2]-coef[1]*coef[3])+"+"+(coef[1]*coef[2]+coef[0]*coef[3])+"i";
	}
	
	public String complexNumberMultiply_1(String a, String b) {
		String res = "";
		String[] A = a.split("\\+");
		String[] B = b.split("\\+");
		int a1 = Integer.parseInt(A[0]);
		int b1 = Integer.parseInt(A[1].replace("i", ""));
		
		int a2 = Integer.parseInt(B[0]);
		int b2 = Integer.parseInt(B[1].replace("i", ""));
		
		int a1a2 = a1*a2;
		int b1b2 = b1*b2;
		int a1b2a2b1 = a1*b2+b1*a2;
		
		String afinal = (a1a2+(-1*b1b2))+"";
		String bfinal = a1b2a2b1+"i";
		res = afinal+"+"+bfinal;
		return res;
 	}
}
