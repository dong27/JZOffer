package Leetcode;

//不同路径 II

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class Test63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m==0||n==0){
            return 0;
        }
        //如果第一个格子就有障碍物，那么到达右下角的可能也就为0了
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        //构造矩阵
        int [][]dp = new int[m][n];
        dp[0][0] = 1;
        //对于这种情况就需要判断obstacleGrid元素是否为 1
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]==1){//那么后面的格子都不能走
                for(int j=i;j<m;j++){
                    dp[j][0] = 0;
                }
                break;
            }else{
                dp[i][0] = 1;
            }
        }
        //对于第一行处理
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==1){
                for(int j=i+1;j<n;j++){
                    dp[0][j] = 0;
                }
                break;
            }else{
                dp[0][i] = 1;
            }
        }
        //对于其他格子，分析得
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
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
