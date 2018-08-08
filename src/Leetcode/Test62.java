package Leetcode;

//不同路径
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//问总共有多少条不同的路径？

/**
 * 该题目依然是动态规划问题。
 因为机器人只能向右或者下移动，那么对于我们需要移动的那一个点来说，只需要获取当前点的上一个点和左边一个点的值就行，然后相加。
 */
public class Test62 {
    public int uniquePaths(int m, int n) {
        if(m==0||n==0){
            return 0;
        }
        //构造矩阵
        int [][]dp = new int[m][n];
        //第一个只有一种方式行走
        for(int i=0;i<m;i++){//细节问题，假如只有一个点，那么到达的路径是 1
            dp[i][0] = 1;
        }
        //第一列只有一种方式行走
        for(int i=1;i<n;i++){
            dp[0][i] = 1;
        }
        //对于其他格子，分析得
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        //输出矩阵
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[m-1][n-1];
    }
}
