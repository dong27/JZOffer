package Leetcode;

//组合之和
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

//candidates 中的数字可以无限制重复被选取。
public class Test39 {
    //c++ code
    /**
     * class Solution {
     public:
     void dfs(vector<int>& candidates, int target, vector<vector<int>> &re, vector<int> &temp, int sum, int level){
     if (sum > target)  return;//减支
     if (sum == target) {
     re.push_back(temp);
     return;
     }

     for (int i=level; i<candidates.size(); ++i){  //避免出现重复元素，减支
        temp.push_back(candidates[i]);
        dfs(candidates, target, re, temp, sum + candidates[i], i);
        temp.pop_back();
    }
}

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());//排序，方便后来减支
        vector<vector<int>> re;
        vector<int> temp;
        dfs(candidates, target, re, temp, 0, 0);
        return re;
    }
};
     */
}
