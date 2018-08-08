package PDD;

import java.util.Scanner;

//有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            int alen = str1.length();
            int blen = str2.length();

            char[] s1 = str1.toCharArray();
            char[] s2 = str2.toCharArray();
            // 高低位对调
            covertdata(s1, alen);
            covertdata(s2, blen);
            // 两数乘积位数不会超过乘数位数和+ 3位
            int csize = alen + blen + 3;
            // 开辟乘积数组
            int[] c = new int[csize];
            // 乘积数组填充0
            for (int ii = 0; ii < csize; ii++) {
                c[ii] = 0;
            }
            // 对齐逐位相乘(没有进位处理)
            for (int j = 0; j < blen; j++) {
                for (int i = 0; i < alen; i++) {
                    c[i + j] += Integer.parseInt(String.valueOf(s1[i])) * Integer.parseInt(String.valueOf(s2[j]));
                }
            }
            // System.out.println(Arrays.toString(c));
            int m = 0;
            // 进位处理
            for (m = 0; m < csize; m++) {
                int carry = c[m] / 10;
                c[m] = c[m] % 10;
                if (carry > 0)
                    c[m + 1] += carry;
            }
            // 找到最高位（避免前导0）
            for (m = csize - 1; m >= 0; ) {
                if (c[m] > 0)
                    break;
                m--;
            }
            // 由最高位开始打印乘积
            for (int n = 0; n <= m; n++) {
                System.out.print(c[m - n]);
            }
            System.out.println("");
        }
    }
    public static void covertdata(char data[], int len) {
        // 高低位对调
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }
}
