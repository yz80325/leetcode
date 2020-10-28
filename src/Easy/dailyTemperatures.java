package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
* 一个月有多少天
*1118
* */
public class dailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemp(new int[]{73, 74, 75, 71, 69, 76})));
    }
    /**
     * 对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
    * */
    private static int[] dailyTemp(int[] a){
        Stack<Integer>stack=new Stack<>();
        int[] res=new int[a.length];
        for (int i=a.length-1;i>=0;i--){
            while (!stack.isEmpty()&&a[i]>a[stack.peek()]){
                stack.pop();
            }
            //获取间距
            res[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return res;
    }
}
