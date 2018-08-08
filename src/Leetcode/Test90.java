package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90. 子集 II
//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

//说明：解集不能包含重复的子集。
public class Test90 {
    List<List<Integer>> list;//结果集
    List<Integer> al;//每一项
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list = new ArrayList<List<Integer>>();
        al = new ArrayList<Integer>();
        Arrays.sort(nums);
        //排列组合
        count(nums,al,0);
        return list;
    }
    private void count(int[] nums,List<Integer> al,int j){

        list.add(new ArrayList<Integer>(al));//不重复的才添加

        for(int i = j; i < nums.length;i++){
            if(i == j || nums[i] != nums[i-1]){//去除重复
                al.add(nums[i]);//添加
                count(nums,al,i+1);
                al.remove(al.size()-1);//去除，为下一个结果做准备
            }
        }
    }
}
