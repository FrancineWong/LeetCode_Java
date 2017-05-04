
public class moveZeros {
	public static void moveZero(int[] nums){
		int i=0;
		while(i<nums.length-1){
			if(nums[i]==0){
				for(int j=i; j<nums.length-1; j++){
					nums[j]=nums[j+1];
				}
				nums[nums.length-1]=0;
				if(allZero(nums, i)){
					System.out.println(i);
					System.out.println();
					return;
				}
			}else{
				i++;
			}
		}
	}
	
	public static void main(String[] args){
		int[] nums = {0,0,1};
//		int[] nums = {1,0,2,0,13};
//		int[] nums = {0,0,0,0};
		moveZero(nums);
		for(int i=0; i<nums.length; i++){
			System.out.println(nums[i]);
		}
	}
	
	public static boolean allZero(int[] nums, int index){
		for(int m=index; m<nums.length; m++){
			if(nums[m]!=0) return false;
		}
		return true;
	}
}
