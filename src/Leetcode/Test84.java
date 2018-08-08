package Leetcode;

import java.util.Stack;

//柱状图中最大的矩形
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//求在该柱状图中，能够勾勒出来的矩形的最大面积。

//http://www.cnblogs.com/acbingo/p/9393162.html
public class Test84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int tmp = stack.pop();
                // 把当前的tmp木板作为最短木板，看能组成的最大面积是多少
                max = Math.max(max, heights[tmp] * (stack.empty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }

        int tmp = 0;
        int len = heights.length;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            max = Math.max(max, heights[tmp] * (stack.empty() ? len : len - stack.peek() - 1));
        }

        return max;
    }
}
