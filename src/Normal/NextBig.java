package Normal;

import java.util.Stack;

/**
 *
 * 503
 * 循环数组找下一个元素
 *
 * */
public class NextBig {
    /**
     * 对于循环数组，采用取模运算来进行循环
     * 当前的位置%数组的长度
     * */
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[n];
        for (int i=n*2-1;i>=0;i--){
            while (!stack.isEmpty()&&stack.peek()<=nums[i%n]){
                stack.pop();
            }
            res[i%n]=stack.isEmpty()?0:stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
