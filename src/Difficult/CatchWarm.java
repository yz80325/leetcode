package Difficult;

/*
*
* 接雨水
*
* */
public class CatchWarm {
    public static void main(String[] args) {
        System.out.println(trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //暴力解法
    private static int trap(int[] height) {
        //总量
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            //计算左侧柱子的最大高度
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            //计算右侧柱子的最大高度
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            //总量
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    //双指针
    private static int trap1(int[] height) {
        // leftMax 是从左端开始递推得到的，而 rightMax 是从右端开始递推得到的
        int res = 0, leftMax = 0, rightMax = 0, left = 0, right = height.length - 1;
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right--];
            }
        }
        return res;
    }
}
