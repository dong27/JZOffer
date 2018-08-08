package Leetcode;

//搜索二维矩阵

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 每行中的整数从左到右按升序排列。
 每行的第一个整数大于前一行的最后一个整数。
 */
public class Test74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0){
            return false;
        }
        int row=matrix.length;
        int column=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=column-1;j>=0;j--){
                if(matrix[i][j]==target){
                    return true;
                }else if(matrix[i][j]>target){
                    continue;
                }else{
                    break;
                }
            }
        }
        return false;
    }
}
