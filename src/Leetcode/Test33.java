package Leetcode;

//搜索旋转排序数组
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//这题说的旋转，实际上就是左右整体互换，也就导致出现了两个递增序列。
// 也就是说当我们二分查找时，有两种可能，一种是选择的部分一个递增序列，而另一种可能选择的部分横跨两个递增序列。
public class Test33 {
    public int search(int[] nums, int target) {
        //实际上就是两个递增序列，依旧是二分法
        //只不过只在递增序列中二分
        if(nums.length==0){
            return -1;
        }
        int st = 0,end = nums.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[st]){
                if(nums[st]<=target&&target<nums[mid]){
                    end = mid-1;
                }else{
                    st = mid+1;
                }
            }else{
                if(nums[mid]<target&&target<=nums[end]){
                    st = mid+1;
                }else{

                    end = mid==0?mid:mid-1;
                }
            }
        }
        return -1;
    }
}
