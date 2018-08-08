package Leetcode;

//螺旋矩阵II
//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
public class Test59 {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        int count = 1;
        while (left <= right && up <= down) {
            // 右
            for (int j = left; j <= right; j++)
                ret[up][j] = count++;
            up++;
            // 下
            for (int j = up; j <= down; j++)
                ret[j][right] = count++;
            right--;
            // 左
            for (int j = right; j >= left; j--)
                ret[down][j] = count++;
            down--;
            // 上
            for (int j = down; j >= up; j--)
                ret[j][left] = count++;
            left++;

        }
        return ret;
    }
}
