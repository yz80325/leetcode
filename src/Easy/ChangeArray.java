package Easy;

import java.util.Arrays;
import java.util.Stack;

public class ChangeArray {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        
        ChangeMy(new int[]{1,2,3,4,5,6});
    }
    private static void ChangeMy(int[]arrays){
        int start=0,end=arrays.length-1;
        while (start<arrays.length){
            if (arrays[start]%2==0){
                while (arrays[end]%2!=1){
                    end--;
                }
                swap(arrays, start, end);
            }else {
                start++;
            }
        }
        System.out.println(Arrays.toString(arrays));
    }

    private static void swap(int[] arrays, int start, int end) {
        int a= arrays[end];
        arrays[end]= arrays[start];
        arrays[start]=a;
    }

}
