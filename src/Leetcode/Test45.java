package Leetcode;

//跳跃游戏 II
//给定一个非负整数数组，你最初位于数组的第一个位置。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
        //你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//贪心算法
public class Test45 {
    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        if (nums[0] == 0)
            return -1;
        // 记录当前活动距离
        int reach = nums[0];
        int steps = 0, start = 0;
        for (; start < nums.length && start <= reach;) {
            ++steps;
            if (reach >= nums.length - 1) {
                return steps;
            }
            // nextMax表示下一步能到达的最远距离
            int nextMax = 0;
            // 在当前start和reach之间，找下一步能到达最远的距离的下标
            for (int i = start; i <= reach; ++i) {
                if ((i + nums[i]) > nextMax) {
                    nextMax = i + nums[i];
                    start = i;
                }
            }
            reach = nextMax;
        }
        return -1;
    }
}
