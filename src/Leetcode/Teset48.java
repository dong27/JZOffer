package Leetcode;

//旋转图像
//给定一个 n × n 的二维矩阵表示一个图像。
//将图像顺时针旋转 90 度。
public class Teset48 {
    public void rotate(int[][] matrix) {
        if(matrix==null)
            return;
        int n=matrix.length-1;
        for (int i = 0; i <= n/2; ++i)
        {
            for (int j = i; j < n-i; ++j)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = tmp;
            }
        }
    }

    public void rotate1(int[][] matrix)
    {
        int h = matrix.length;
        int l = matrix[0].length;
        int tem[][] = new int[h][l];
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<l;j++)
                tem[i][j]=matrix[i][j];
        }
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<l;j++)
            {
                matrix[j][l-i-1]=tem[i][j];
            }
        }
    }
}
