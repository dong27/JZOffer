package Leetcode;

//矩阵置零
//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法

//【思路-Java】T=O(n)|M=O(n)
//建立一个大小为 n 的数组，用于记录第 j 列是否出现0
public class Test73 {
    public void setZeroes(int[][] matrix) {
        boolean[] flag = new boolean[matrix[0].length];
        for(int i =0; i<matrix.length; i++) {
            boolean contains0 = false;
            for (int j =0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    contains0 = true;
                    flag[j] = true;
                }
            }
            if(contains0)
                for(int j=0; j<matrix[0].length; j++) matrix[i][j] = 0;
        }
        for(int j = 0; j < matrix[0].length; j++)
            if(flag[j])
                for(int i =0; i<matrix.length; i++) matrix[i][j] = 0;
    }
}
