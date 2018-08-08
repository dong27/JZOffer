package Leetcode;

//报数
//报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数
public class Test38 {
    public String countAndSay(int n) {
        int result = 1;
        String str = "";
        if (n == 0) return str;
        if (n == 1) return str + result;
        if (n == 2) return str + result + result;
        if (n == 3) return "21";
        str = "21";

        String tempresult = "";
        int sum = 1;  //计数君
        for (int i = 3; i < n; i++) {
            for (int j = 0; j < str.length(); j++) {
                // 在遍历到末尾前，当前的数与后一个数相等
                if (j != str.length() - 1 && str.charAt(j) == str.charAt(j+1)) {
                    sum++;  // 相邻且相同的数计数+1
                    continue;
                    // 若遍历到末尾，未位数与前一个数相等
                }else if (j == str.length() - 1 && str.charAt(j) == str.charAt(j-1)){
                    tempresult += sum + String.valueOf(str.charAt(j));
                    sum = 1;    // 已完成报数，计数君重置为0
                }else {
                    tempresult += sum + String.valueOf(str.charAt(j));
                    sum = 1;    // 已完成报数，计数君重置为0
                }
            }
            str = tempresult;
            tempresult = "";

        }
        System.out.println("str:" + str);
        return str;
    }
}
