package Leetcode;

//爬楼梯
//假设你正在爬楼梯。需要 n 步你才能到达楼顶。
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

public class Test70 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] r = new int[n+1];
        r[1] = 1;
        r[2] = 2;
        for (int i = 3; i <= n; i++) {
            r[i] = r[i-1] + r[i-2];
        }
        return r[n];
    }
}
