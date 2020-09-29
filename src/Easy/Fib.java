package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
* 斐波那契数列
*优化后
* */
public class Fib {

    public static void main(String[] args) {
        fib(10);
    }
    static int fib(int N){
        if (N<1)return 0;
        List<Integer> meno=new ArrayList<Integer>();
        for (int i=0;i<=N;i++){
            meno.add(0);
        }
        return helper(meno,N);
    }

    static int helper(List<Integer> memo, int n) {
        // base case
        if (n == 1 || n == 2) return 1;
        // 已经计算过，直接取出
        if (memo.get(n) != 0) {
            return memo.get(n);
        }

        memo.set(n, helper(memo, n - 1) + helper(memo, n - 2));
        return memo.get(n);
    }
}
