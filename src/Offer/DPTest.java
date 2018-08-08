package Offer;

public class DPTest {
    /**
     *
     * @param str 存储可用的字符种类
     * @param m 可用的字符种类数
     * @param n 组合中的最大长度
     * @return
     */
    public static int allCombination(char[] str, int m, int n){

        //base condition
        if(m == 0 && n > 0)
            return 1;

        if(n == 0)
            return 0;

        return allCombination(str, m-1, n-1)+ allCombination(str, m-1, n);
    }


    public static int dpAllCombination(char[] str, int n){
        int[][] c = new int[n+1][n+1];


        //可根据上面的递归来判断初始条件
        for(int i = 0; i <=n; i++)
        {
            c[0][i] = 1;
            c[i][0] = 0;//c[0][0]=0
        }

        //c[n][n]=c[n-1][m-1] + c[n-1][m]
        for(int i = 1; i <=n; i++)
        {
            for(int j = 1; j <=n; j++)
            {
                c[i][j] = c[i-1][j-1] + c[i-1][j];
            }
        }
        return c[n][n];
    }

    public static void main(String[] args) {
        char[] str = {'a','b','c','d'};
        int m ,n ;
        m = n = str.length;
        int result = allCombination(str, m, n);
        int result2 = dpAllCombination(str, n);
        System.out.println(result);
        System.out.println(result2);
    }
}
