package Easy;

import static java.lang.Math.max;

/*
* base case：
* dp[天数][可交易次数][持有股票数]=利润（-infinity为不可能发生事件）
*
dp[-1][k][0] = dp[i][0][0] = 0
dp[-1][k][1] = dp[i][0][1] = -infinity

状态转移方程：
* 解释：今天我没有持有股票，有两种可能：
要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
*
解释：今天我持有着股票，有两种可能：
要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
* */
public class maxProfile {

    public static void main(String[] args) {
        int[][][] a=new int[2][2][2];
        int b=a[2][2][1];
        //int a=maxProfit(new int[]{7,1,5,3,6,4});
        //System.out.println(a);
    }
    /*
    力扣121
    * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
       dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
            = max(dp[i-1][1][1], -prices[i])
       解释：k = 0 的 base case，所以 dp[i-1][0][0] = 0。

       现在发现k 都是 1，不会改变，即 k 对状态转移已经没有影响了。
       可以进行进一步化简去掉所有 k：
       dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
       dp[i][1] = max(dp[i-1][1], -prices[i])

    *
    * */
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                // 解释：
                //   dp[i][0]
                // = max(dp[-1][0], dp[-1][1] + prices[i])
                // = max(0, -infinity + prices[i]) = 0
                dp[i][1] = -prices[i];
                //解释：
                //   dp[i][1]
                // = max(dp[-1][1], dp[-1][0] - prices[i])
                // = max(-infinity, 0 - prices[i])
                // = -prices[i]
                continue;
            }
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = max(dp[i-1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    /*
    * 力扣122
    *  dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
       dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    * k-1=k(因为可以多次交易是等价的)
    * 简化
    * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
      dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
    * */
    public int maxProfit2(int[] prices) {
        int n=prices.length;
        //只存储两边的数值
        int dp_i_0=0,dp_i_1=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            int temp=dp_i_0;
            dp_i_0= max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1= max(dp_i_1,temp-prices[i]);
        }
        return dp_i_0;
    }

    /*
    * 力扣123
    *dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
     dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
     dp[i][1][0] = max(dp[i-1][1][0],dp[i-1][1][1]+prices[i])
     dp[i][1][1]=max(dp[i-1][1][1],-prices[i])
    *只能用列举法
    * */
    public int maxProfit3(int[] prices) {
        int dp_i10=0,dp_i11=Integer.MIN_VALUE;
        int dp_i20=0,dp_i21=Integer.MIN_VALUE;
        for (int price:prices){
            dp_i20= max(dp_i20,dp_i21+price);
            dp_i21= max(dp_i21,dp_i10-price);
            dp_i10 = max(dp_i10, dp_i11 + price);
            dp_i11 = max(dp_i11, -price);
        }
        return dp_i20;
    }

    /*
    *力扣188
    *
    * */
    public int maxProfit4(int k,int[] prices) {
        int len=prices.length;
        //如果k的值大于长度的一般就是无限
        if (k>len/2){
            return new maxProfile().maxProfit2(prices);
        }
        int[][][] dp=new int[len][k+1][2];
        for (int i=0;i<len;i++){
            for (int j=k;j>=1;j--){
                //处理base case
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[len-1][k][0];
    }
}
