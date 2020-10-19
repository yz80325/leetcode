package Easy;

/*
* 283
* */
public class moveZero {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,2,2,3});
    }

    public static void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j]=nums[i];
                if (j!=i){
                    nums[i]=0;
                }
                j++;
            }
        }
    }
}
