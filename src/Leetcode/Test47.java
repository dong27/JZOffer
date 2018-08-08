package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//全排列II
//给定一个可包含重复数字的序列，返回所有不重复的全排列。

public class Test47 {
    List<List<Integer>> list;
    public List<Integer> toList(int nums[]){
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
            list.add(nums[i]);
        return list;
    }
    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
    public void dfs(int[] nums,int index){
        if(index==nums.length)
            list.add(toList(nums));
        Set<Integer> set = new HashSet<Integer>(); //因为有重复，所以每次交换之和一个出现相同的元素进行交换，可以排序实现，我这里使用Set来表示
        for(int i=index;i<nums.length;i++){
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            swap(nums,i,index);
            dfs(nums,index+1);
            swap(nums,index,i);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        list=new ArrayList<List<Integer>>();
        if(nums.length==0)
            return list;
        dfs(nums,0);
        return list;
    }
}
