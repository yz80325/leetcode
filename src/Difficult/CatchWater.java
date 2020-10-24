package Difficult;
/*
*42
* */
public class CatchWater {

    public static void main(String[] args) {
        int a=trap1(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(a);
    }
    /*
    * 暴力解法
    * water[i] = min(
               # 左边最高的柱子
               max(height[0..i]),
               # 右边最高的柱子
               max(height[i..end])
            ) - height[i]
    * */
    public static int trap1(int[] height) {
        int size=height.length;
        int res=0;
        for (int i=0;i<size;i++){
            int l_max=0,r_max=0;
            //右边
            for (int j=i;j<size;j++){
                r_max=Math.max(r_max,height[j]);
            }
            //左边
            for (int k=i;k>=0;k--){
                l_max=Math.max(l_max,height[k]);
            }
            res+=Math.min(l_max,r_max)-height[i];
        }
        return res;
    }
    /*
    * 添加备忘录
    * */
    public static int trap2(int[] height){
        if (height.length==0){
            return 0;
        }
        int res=0;
        int size=height.length;
        //备忘录
        int[] l_max=new int[size];
        int[] r_max=new int[size];
        //初始化
        l_max[0]=height[0];
        r_max[size-1]=height[size-1];
        //左侧
        for (int i=1;i<size;i++){
           l_max[i]=Math.max(height[i],l_max[i-1]);
        }
        //右侧
        for (int j=size-2;j>0;j--){
            r_max[j]=Math.max(height[j],r_max[j+1]);
        }
        for (int i=1;i<size;i++){
            res+=Math.min(l_max[i],r_max[i])-height[i];
        }
        return res;
    }

    /*
    * 双指针
    *
    * */
    public static int trap3(int[] height){
        if (height.length==0){
            return 0;
        }
        int n=height.length;
        int left=0,right=n-1;
        int res=0;
        int l_max=height[0];
        int r_max=height[n-1];
        while (left<=right){
            l_max=Math.max(l_max,height[left]);
            r_max=Math.max(r_max,height[right]);
            if (l_max<r_max){
                res+=l_max-height[left];
                left++;
            }else {
                res+=r_max-height[right];
                right--;
            }
        }
        return res;
    }
}
