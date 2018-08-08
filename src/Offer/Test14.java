package Offer;

//剪绳子
//给定一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
// 每段绳子的长度记为k[0],k[1],…,k[m]。请问k[0]* k[1] * … *k[m]可能的最大乘积是多少？
public class Test14 {
    public static void main(String[] args) {
        int length = 7;
        // int result = matProductAfterCutting_1(length);
        int result = matProductAfterCutting_2(length);
        System.out.println(result);
    }
    /**
     * 贪婪算法
     *
     * @param length
     * @return
     */
    private static int matProductAfterCutting_2(int length) {

        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // 当n>=5的时候，尽可能剪长度为3的绳子
        int timeOf3 = length / 3;
        // 当n=4的时候，剪成长度为2的两段
        if (length - timeOf3 * 3 == 1) {
            timeOf3 -= 1;
        }
        // 剪成长度为2的两段
        int timeOf2 = (length - timeOf3 * 3) / 2;
        return (int) ((Math.pow(3, timeOf3)) * (Math.pow(2, timeOf2)));
    }

    /**
     * 动态规划
     *
     * @param length
     * @return
     */
    private static int matProductAfterCutting_1(int length) {

        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // 将最优解存储在数组中
        int[] products = new int[length + 1];
        // 数组中第i个元素表示把长度为i的绳子剪成若干段之后的乘积的最大值
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;

        for (int i = 4; i <= length; i++) {
            max = 0;
            // 求出所有可能的f(j)*f(i-j)并比较出他们的最大值
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];

        return max;
    }
}
