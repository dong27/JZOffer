package Leetcode;

//缺失的第一个正数

/**
 * 由于线性时间和常数空间的要求，我们开不了数组，用不了哈希表，不能排序。
 能用的就只有数组本身以及额外常数个变量。。。
 我们考虑如果整数都出现，那么最后数组排列应该是[1,2,3,4,5,…,n]，每个都是递增1。
 于是乎，如果我们最后也排列成这种形式，那么只要不满足nums[i]-nums[i-1]不等于1，那么就找到了最小的未出现的整数，但是我们没法排序。
 所以我们可以强行另数组下标和存的值产生联系-> 令数字i出现在下标为i-1的位置，如果会越界则不做处理。
 比如[3,4,-1,1]->[-1,4,3,1]->[-1,1,3,4]->[1,-1,3,4];
 */
public class Test41 {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;){
            if(nums[i]>0&&nums[i]<=nums.length&&nums[i]!=nums[nums[i]-1]){
                //确定nums[i]的值对应的下标不越界，同时排除num[i]本身位置正确或者nums[i]应该放入的位置nums[i]-1原本就是nums[i](如[1,1])

                int index = nums[i];//
                nums[i] = nums[index -1];
                nums[index -1]=index;
                //换位置之后需要继续判断换过来的值是否在对的位置上，因此不能i++;
            }else{
                i++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
