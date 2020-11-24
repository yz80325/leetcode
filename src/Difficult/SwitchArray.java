package Difficult;

public class SwitchArray {
    public int minArray(int[] numbers) {
        int l=0,r=numbers.length-1;
        while (l<r){

            int mid=((r-1)>>1)-1;
            //判断右侧是否比中间大
            if (numbers[r]>numbers[mid]){
                r=mid;
            }else if (numbers[r]<numbers[mid]){
                l=mid+1;
            }else {
                r--;
            }
        }
        return numbers[l];
    }
}
