package Leetcode;

//二进制求和
//给定两个二进制字符串，返回他们的和（用二进制表示）。
//输入为非空字符串且只包含数字 1 和 0。
public class Test67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int da = 0;
        int db = 0;
        int adv = 0;
        StringBuffer result = new StringBuffer();
        while (i >= 0 && j >= 0) {
            da = a.charAt(i--) == '0' ? 0 : 1;
            db = b.charAt(j--) == '0' ? 0 : 1;
            int d = da + db + adv;
            result.append(d % 2 == 0 ? '0' : '1');
            adv = d >> 1;
        }
        if (i >= 0) {
            while (i >= 0) {
                da = a.charAt(i--) == '0' ? 0 : 1;
                int d = da + adv;
                result.append(d % 2 == 0 ? '0' : '1');
                adv = d >> 1;
            }
        } else if (j >= 0) {
            while (j >= 0) {
                db = b.charAt(j--) == '0' ? 0 : 1;
                int d = db + adv;
                result.append(d % 2 == 0 ? '0' : '1');
                adv = d >> 1;
            }
        }
        if (adv == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }
}
