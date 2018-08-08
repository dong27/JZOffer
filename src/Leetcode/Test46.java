package Leetcode;

import java.util.ArrayList;
import java.util.List;

//全排列
//给定一个没有重复数字的序列，返回其所有可能的全排列。
//思路1采用位置两两交换，交换后出现一种新的组合，将这种新的组合添加到中间集，再添加到结果集中。
// 而这种思路是采用逐一向中间集添加元素，并将当中间集元素个数等于 nums 长度的时候，将中间集添加到结果集中，并终止该层递归
public class Test46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                dfs(res, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
