package Leetcode;

// 扰乱字符串
//给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
//下图是字符串 s1 = "great" 的一种可能的表示形式。
public class Test87 {
    private int[] frequency(char[] sa, int from, int to) {
        int[] f = new int[26];
        for(int i=from; i<=to; i++) {
            f[sa[i]-'a'] ++;
        }
        return f;
    }
    private boolean equalFrequency(int[] f1, int[] f2) {
        for(int i=0; i<f1.length; i++) {
            if (f1[i] != f2[i]) return false;
        }
        return true;
    }
    private boolean scramble(char[] sa1, int f1, int t1, char[] sa2, int f2, int t2) {
        if (t1 - f1 != t2 - f2) return false;
        if (f1>t1) return false;
        if (f1==t1) return sa1[f1] == sa2[f2];
        int[] c1 = frequency(sa1, f1, t1);
        int[] c2 = frequency(sa2, f2, t2);
        if (!equalFrequency(c1, c2)) return false;
        for(int i=0; i<t1-f1; i++) {
            if (scramble(sa1, f1, f1+i, sa2, f2, f2+i) && scramble(sa1, f1+i+1, t1, sa2, f2+i+1, t2)) return true;
            if (scramble(sa1, f1, f1+i, sa2, t2-i, t2) && scramble(sa1, f1+i+1, t1, sa2, f2, t2-i-1)) return true;
        }
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        char[] sa1 = s1.toCharArray();
        char[] sa2 = s2.toCharArray();
        return scramble(sa1, 0, sa1.length-1, sa2, 0, sa2.length-1);
    }
}
