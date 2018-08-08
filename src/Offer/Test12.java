package Offer;

//矩阵中的路径

/**
 * 请设计一个函数，用来推断在一个矩阵中是否存在一条包括某字符串全部字符的路径。路径能够从矩阵中随意一格開始。
 * 每一步能够在矩阵中间向左、右、上、下移动一格。假设一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 */
public class Test12 {
    /**
     *
     * @param matrix 输入矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param str 输入的字符串
     * @return
     */
    public static boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        //参数校验
        if(matrix==null||matrix.length!=cols*rows||str==null||str.length<1)
            return false;
        //变量初始化
        boolean[] visited=new boolean[rows*cols];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        // 记录结果的数组。
        int[] pathLength = {0};
        // 以每个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @param visited
     * @param row
     * @param col
     * @param pathLength
     * @return
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited,
                                       int row, int col, int[] pathLength) {
        if (pathLength[0] == str.length) {
            return true;
        }
        boolean hasPath = false;

        // 推断位置是否合法
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]) {

            visited[row * cols + col] = true;
            pathLength[0]++;

            // 按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);

            if (!hasPath) {
                pathLength[0]--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
    public static void main(String[] args) {
        //ABCE  //ABCCED
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCCED".toCharArray()) + "[true]");// true
    }
}
