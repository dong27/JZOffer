package Leetcode;

import java.util.ArrayList;
import java.util.List;

//子集
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
public class Test78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length ==0){
            return list;
        }
        backtrack(list,new ArrayList<Integer>(),nums,0);
        return list;
    }
    private void backtrack(List<List<Integer>> list,List<Integer> temp,int[] nums,int begin){
        list.add(new ArrayList<Integer>(temp));
        for(int i=begin;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(list,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
