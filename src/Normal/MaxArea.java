package Normal;


/*
*
* 11
* */
public class MaxArea {
    int a= (int) Double.MIN_VALUE;
    public int maxArea(int[] height) {

        //右指针
        int j=height.length-1;
        //结果
        int ans=0;
        //左指针
        int i=0;
        while (i<j){
           int area=Math.min(height[i],height[j])*(j-i);
           ans=Math.max(area,ans);
           if (height[i]<=height[j]){
               ++i;
           }else {
               --j;
           }
        }
        return ans;
    }
}
