package Easy;

public class Test {
    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});

    }
    public static int maxSubArray(int[] nums) {
        int aa=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            aa=aa+nums[i];
            max=Math.max(aa,max);
        }
        return max;
    }
}
