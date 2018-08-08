package Leetcode;

import java.util.Stack;

// 最大矩形
//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
public class Test85 {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int[] heights = new int[m + 1];
        Stack<Integer> stk = new Stack<>();
        int ans = 0, cur, w, pos;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                }
                else {
                    heights[j] = 0;
                }
            }
            pos = 0;
            while(!stk.empty()) {
                stk.pop();
            }
            while (pos <= m) {
                if (stk.empty() || heights[stk.peek()] <= heights[pos]) {
                    stk.push(pos ++);
                }
                else {
                    cur = stk.peek();
                    stk.pop();
                    w = stk.empty() ? pos : pos - stk.peek() - 1;
                    ans = Math.max(ans, w * heights[cur]);
                }
            }
        }
        return ans;
    }
}
