package Easy;

import java.util.Arrays;

/*
*
* 寻找零钱
*我们有面值为1元3元5元的硬币各无数枚，如何用最少的硬币凑够21(这个值可以随意指定)元？
 * */
public class FindCoins {

    private static int[]coins=null;

    public static void main(String[] args) {
        coinChange(1,new int[]{2,3,5});
    }
    /*
    * @Param amount 价格
    * @Param coins  硬币
    *
    * */
    private static void coinChange(int amount,int[] aa){
        coins=aa;
        find(amount);

    }
    //寻找硬币
    private static void find(int n){

        int temp[] = new int[n+1];
        for(int i=1;i<temp.length;i++) { //取的硬币的数量
            int minV = i; //初始化最小的为minV，因为最小取的硬币数量肯定不会比i还要大
            for(int j=0;j<coins.length;j++) {
                if(i>=coins[j]) { //取的硬币的数目比有的数目要大。
                    int k = temp[i-coins[j]] + 1; //状态转移方程，前面介绍的。
                    if(k<minV) {
                        minV = k;  //保存了，这一趟比较的最小的取的硬币值
                    }
                }
            }
            temp[i] = minV;
        }
        System.out.println("至少需要" + temp[n] + "枚硬币");

    }
}
