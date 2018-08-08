package Leetcode;

//最小路径和
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
public class Test64 {
    public int minPathSum(int[][] grid) {
        int length = grid.length; //m行
        if(length==0){
            return 0;
        }
        int n = grid[0].length; //n列

        //构造矩阵
        int [][]dp = new int[length][n];
        dp[0][0] = grid[0][0];
        //对第一行处理
        for(int i=1;i<length;i++){
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        //对第一列处理
        for(int j=1;j<n;j++){
            dp[0][j] = grid[0][j]+dp[0][j-1];
        }

        //其他行列处理,从第二行开始
        for(int i=1;i<length;i++){
            for(int j=1;j<grid[i].length;j++){
                dp[i][j] = Math.min( dp[i][j-1],dp[i-1][j] )+grid[i][j];
            }
        }
        //输出矩阵
//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp[i].length;j++){
//                System.out.print( dp[i][j] +" " );
//            }
//            System.out.println();
//        }
        return dp[length-1][n-1];
    }
}
