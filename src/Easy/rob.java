package Easy;

import java.util.Arrays;

/*
* 198
* 打劫家舍
* */
public class rob {

    /*
    * 和买股票一样列举状态和结果
    * */
    public int rob(int[] nums) {
        //为了防止重复遍历,初始化备忘录
        int[] memo=new int[nums.length];
        Arrays.fill(memo,-1);
        //从0号房间开始
        return dp(nums,0);
    }

    private int dp(int[] nums, int i) {
        if (i>=nums.length){
            return 0;
        }
        //
        return 0;
    }
}
