package Easy;

/*
* 二分查找
*
* */
public class binarySearch {

    /*
    * 最简单二分
    * */
    private int BinarySearch1(int[] nums,int target){
        if (nums.length==0){
            return 0;
        }
        int left=0;
        int right=nums.length-1;//
        /*
        * while(left <= right) 的终止条件是 left == right + 1，写成区间的形式就是 [right + 1, right]，
        * 或者带个具体的数字进去 [3, 2]，可见这时候区间为空，因为没有数字既大于等于 3 又小于等于 2 的吧。所以这时候 while 循环终止是正确的，直接返回 -1 即可。
        * */
        while (left<=right){
            //为了防止左侧加右侧的长度过长
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if (nums[mid]<target){
                /*
                *
                * */
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid-1;
            }
        }
        return -1;
    }
    /*
    * 寻找左侧边界
    * */
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /*
    *
    * 寻找右侧边界
    *
    * */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}
