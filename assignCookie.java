import static org.junit.Assert.*;

import org.junit.Test;

public class assignCookie {
	public int findContentChidren(int[] g, int[] s){
		int num = 0;
		int[] gSort = sortArray(g);
		int[] sSort = sortArray(s);
		
		int i=0,j=0;
		while(i<g.length&&j<s.length){
			if(gSort[i]<=sSort[j]){
				num++;
				i++;
				j++;
			}else j++;
		}
		return num;
	}
	
	public int[] sortArray(int[] a){//insert sort
		for (int i=1; i<a.length; i++){
            int index = a[i]; int j = i;
            while (j > 0 && a[j-1] > index){
                a[j] = a[j-1];
                j--;
            }
            a[j] = index;
        }
        return a;
	}
	
	@Test 
	public void test(){
		int[] g = {1,2,3};
		int[] s = {3};
		assertEquals(1, findContentChidren(g, s));
	}

}
