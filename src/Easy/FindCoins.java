package Easy;

import java.util.Arrays;
import java.util.Queue;

/*
*
* 寻找零钱
*我们有面值为1元3元5元的硬币各无数枚，如何用最少的硬币凑够21(这个值可以随意指定)元？
 * */
public class FindCoins {

    private static int[]coins=null;

    public static void main(String[] args) {
        coinChange(new int[]{2,3,5},11);

    }
    /**
    * @Param amount 价格
    * @Param coins  硬币
    *
    * */
    public static int coinChange(int[] coins, int amount) {
        if (coins==null||coins.length==0){
            return -1;
        }
        int[] res=new int[amount+1];
        Arrays.fill(res,amount+1);
        res[0]=0;
        for (int i=1;i<res.length;i++){
            for (int coin:coins){
                if (i-coin<0){
                    continue;
                }
                res[i]=Math.min(res[i],res[i-coin]+1);
            }

        }
        return res[amount]==amount+1?-1:res[amount];
    }
}
