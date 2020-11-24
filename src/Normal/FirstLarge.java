package Normal;

import java.util.PriorityQueue;

/**
 * 215
 */
public class FirstLarge {
    public static void main(String[] args) {
        findKthLargest(new int[]{2,1,4,5,6},2);
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>priorityQueue=new PriorityQueue<Integer>();
        for (int item:nums){
            priorityQueue.offer(item);
            if (priorityQueue.size()>k){
                System.out.println(priorityQueue.poll());
            }
        }
        return priorityQueue.peek();
    }
}
