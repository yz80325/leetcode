package Study.Dontai;

import java.util.Arrays;
import java.util.HashMap;

/*
* 凑零钱
* 动态规划 最优子解
* */
public class coinChange {

    /*
    * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
    * */
    // coins 中是可选硬币面值，amount 是目标金额
    public static void main(String[] args) {
        int a=coinChange(new int[]{1, 2, 5},11);
        System.out.println(a);
    }

    static int[] all=null;
    //备忘录防止重复便利
    static HashMap<Integer,Integer> memo=new HashMap<>();
    public static int coinChange(int[] coins, int amount){
        all=coins;
        return dp(amount);
    }
    //返回目标金额所需的最少货币数量
    private static int dp(int a){
        if (memo.containsKey(a)){
            return memo.get(a);
        }
        if (a==0){
            return 0;
        }
        if (a<0)
            return -1;
        int res=Integer.MAX_VALUE;
        //做选择，选择需要硬币最少的那个结果
        for (int coin:all){
            //子问题，此金额往下遍历
            int sp=dp(a-coin);
            if (sp==-1){
                continue;
            }
            /*
            * 比如你想求 amount = 11 时的最少硬币数（原问题），如果你知道凑出 amount = 10 的最少硬币数（子问题），你只需要把子问题的答案加一（再选一枚面值为 1 的硬币）就是原问题的答案。
            * */
            res=Math.min(res,1+sp);
        }
        memo.put(a,res==Integer.MAX_VALUE?-1:res);
        return memo.get(a);
    }


    /*
    * 自底向上
    * int[] a和参数int i值的意思是为了凑i元钱所组成的最小硬币组合
    * */
    public int coinChange1(int[] coins, int amount) {
        //定义dp,数组大小为amount+1，默认值为amount+1,因为最大值为amount,所以amount+1就为正无穷
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        //base
        dp[0]=0;
        //循环
        for (int i=0;i<dp.length;i++){
            for (int coin:coins){
                //如果无解,继续下一个
                if (i-coin<0){
                    continue;
                }
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return (dp[amount]==amount+1)?-1:dp[amount];
    }

}
