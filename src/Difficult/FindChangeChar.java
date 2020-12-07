package Difficult;

public class FindChangeChar {
    public static void main(String[] args) {
        minDistance("res","apple");
    }
    private static int minDistance(String s1,String s2){
        int m=s1.length(),n=s2.length();
        //dp[i][j],i为s1要变得次数，j为s2要变得次数
        int[][] dp=new int[m+1][n+1];
        //初始
        for(int i=1;i<=m;i++){
            dp[i][0]=i;
        }
        for (int j=1;j<=n;j++){
            dp[0][j]=j;
        }
        //自底向上
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=MyMin(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }

            }
        }
        return dp[m][n];
    }
    static int MyMin(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
}
