
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

/*A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the 
 * bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, 
return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not 
valid, it should be "10:02".

*/

public class Q401_Binary_Watch {
	public List<String> readBinaryWatch(int num) {
        List<String> time = new ArrayList<String>();
        if(num>8) return time;
        if(num==0) {
            time.add("0:00");
            return time;}
        //initialize
        int[] led = new int[]{0,0,0,0,0,0,0,0,0,0};
		for(int i=0; i<num; i++) led[i] = 1;
        
        boolean flag = true;   
        boolean tempFlag = false;   
        int pos = 0;   
        int sum = 0;   
        //首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边   
        do{   
            sum = 0;   
            pos = 0;   
            tempFlag = true;    
            time.add(countTime(led));   
               
            for(int i=0;i<9;i++){   
                if(led[i]==1 && led[i+1]==0 ){   
                    led[i]=0;   
                    led[i+1]=1;   
                    pos = i;   
                    break;   
                }   
            }   
            //将左边的1全部移动到数组的最左边   
               
            for(int i=0;i<pos;i++){   
                if(led[i]==1){   
                    sum++;   
                }   
            }   
            for(int i=0;i<pos;i++){   
                if(i<sum){   
                    led[i]=1;   
                }else{   
                    led[i]=0;   
                }   
            }   
               
            //检查是否所有的1都移动到了最右边   
            for(int i= 10-num;i<10;i++){   
                if(led[i]==0){   
                    tempFlag = false;   
                    break;   
                }   
            }   
            if(tempFlag==false){   
                flag = true;   
            }else{   
                flag = false;   
            }   
               
        }while(flag);  
        time.add(countTime(led));
        
        return time;
    }
	
	public String countTime(int[] led){
		int hour = 0, minute = 0;
		for(int i=0; i<4; i++) hour += led[i]*Math.pow(2, (3-i));
		for(int i=4; i<10; i++) minute +=led[i]*Math.pow(2, (9-i));
		if(minute<=59||hour<=11) return null;
		return minute>9?(hour+":"+minute):(hour+":0"+minute);
	}
	
	@Test
	public void test() throws Exception{
		List<String> expected = Arrays.asList("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32");
		assertEquals(expected, readBinaryWatch(1));
	}
	
	@Test
	public void test1() throws Exception{
		assertEquals(null, readBinaryWatch(2));
	}

}
