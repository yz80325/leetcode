package Difficult;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
*239
*
**/
public class maxWindows {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

    /**
    * 单调队列
    * */
    static class MonotonicQueue{
        LinkedList<Integer> q=new LinkedList<>();

        public void push(int data){
            //将小于插入值的书全部删除
            while (!q.isEmpty()&&data>q.getLast()){
                q.pollLast();
            }
            //将数据插入
            q.addLast(data);
        }

        public int max(){
            return q.getFirst();
        }

        public void pop(int n){
            if (n==q.getFirst()){
                q.pollFirst();
            }
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue monotonicQueue=new MonotonicQueue();
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (i<k){
               monotonicQueue.push(nums[i]);
            }
            else {
                //加入新数字
                monotonicQueue.push(nums[i]);
                //记录当前窗口
                res.add(monotonicQueue.max());
                //移除
                monotonicQueue.pop(nums[i-k+1]);
            }
        }
        //需要转成int[]
        int[] arr=new int[res.size()];
        for (int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;
    }
}
