package Normal;

import java.util.Arrays;

/*
* 力扣
* 516
*
* */
public class zuichanghuiwen {
    public static void main(String[] args) {
        longestPalindromeSubseq("abba");
    }
    public static int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        char[] ss=s.toCharArray();
        for(int q=0;q<n;q++){
            dp[q][q]=1;
        }
        for (int i=n-1;i>=0;i--){
            for (int j=i+1;j<n;j++){
                if (ss[i]==ss[j]){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else
                {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

}
