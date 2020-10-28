package Easy;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496
 *下一个最大元素
 * */
public class NextBig {

    /*
    * 单调栈
    *
    * */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //对于num2的排列
        Map<Integer,Integer> map=new HashMap<>();
        //存放栈
        Stack<Integer> stack=new Stack<>();
        int[]res=new int[nums1.length];
        for (int i=0;i<nums2.length;i++){
            while (!stack.isEmpty()&&nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()){
            map.put(stack.pop(),-1);
        }
        for (int j=0;j<nums1.length;j++){
            res[j]=map.get(nums1[j]);
        }
        return res;
    }

}
