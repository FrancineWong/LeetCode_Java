
public class Q492_Construct_the_Rectangle {
	public int[] constructRectangle(int area) {
        int[] rec =  new int[2];
        int W = (int) Math.sqrt(area);
        while(area%W!=0) {
        	W--;
        }
        int L = area/W;
        rec[0] = L;
        rec[1] = W;
        return rec;
    }
}
