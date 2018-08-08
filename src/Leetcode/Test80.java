package Leetcode;

//删除排序数组中的重复项 II

/**
 *给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 示例 1:
 给定 nums = [1,1,1,2,2,3],
 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 你不需要考虑数组中超出新长度后面的元素。
 */
public class Test80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){//长度小于2，直接返回
            return nums.length;
        }

        boolean isTwice = false;//是否两次
        int len = 0;//最新长度
        for(int i = 0; i < nums.length; i++){//遍历
            //不等于最后一个切数字相等
            if(i != nums.length -1 && nums[i+1] == nums[i]){
                if(!isTwice){//还没两次
                    isTwice = true;
                    nums[len++] = nums[i];  //添加到数组最前
                }
            }else{//不相等
                isTwice = false;//标记为不是两次
                nums[len++] = nums[i];//添加最前
            }
        }
        return len;
    }
}
