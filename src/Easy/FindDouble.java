package Easy;

import java.util.*;

public class FindDouble {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(duplicate(new int[]{5,0,4,3,3,2,2,1})));
    }

    private static Integer[] duplicate(int[] numbers){
        Set<Integer> res=new HashSet<>();
        for (int i=0;i<numbers.length;i++){
            while (numbers[i]!=i){
                if (numbers[i]==numbers[numbers[i]]){
                    res.add(numbers[i]);
                    break;
                }
                My_switch(numbers[i],i,numbers);
            }
        }
        return res.toArray(new Integer[res.size()]);
    }
    private static void My_switch(int start,int end,int[] ints){
        int a=ints[start];
        ints[start]=ints[end];
        ints[end]=a;
    }
}
