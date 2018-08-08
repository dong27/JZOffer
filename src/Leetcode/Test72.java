package Leetcode;

//编辑距离

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 你可以对一个单词进行如下三种操作：
 插入一个字符
 删除一个字符
 替换一个字符
 */

/**
 定义一个动态数组dp[word1.length + 1][word2.length + 1],
 之所以是word1和word2的长度加1，是因为从0开始变化到每一位，总共是长度＋1总情况，
 dp[i][j] 代表的是从word1的前i个字符转化到word2的前j个字符，需要的最少的次数。
 每次循环中，分为两种情况，比如word1遍历到了第i个字符，字符为a，word2遍历到了第j个字符，字符为b，
 （1） 如果a == b， 不需要做任何编辑操作，dp［i］［j］ ＝ dp［i－1］［j－1］
 （2）如果a  ！＝ b
 操作方法一：插入字符的方式，在word1中插入b，那么dp[ i ] [ j ]＝ dp[ i ][ j -  1]＋ 1；
 操作方法二：删除字符的方式，在word1中将a删除，那么dp[ i ] [ j ] = dp[ i - 1] [ j ] + 1;
 操作方法三：替换字符的方式，在word1中将a替换为b， 那么dp [i - 1][j - 1] + 1;
 取这三者的最小值作为最少操作次数。
 返回dp[word1.length + 1][word2.length + 1]
 */
public class Test72 {
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length(),cost;
        int dp[][]=new int [n+1][m+1];
        //初始化
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int i=0;i<=m;i++)
            dp[0][i]=i;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                cost= word1.charAt(i-1)==word2.charAt(j-1)?0:1;
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+cost);
            }
        }
        return dp[n][m];
    }
}
