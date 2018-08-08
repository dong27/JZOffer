package Leetcode;

//有效数字
//验证给定的字符串是否为数字

/**
 * 首先分析下，什么是一个valid的number：
 （1）"."只能有一个但是必须和数存在 只有一个"."，false, '1.' true, '.2' true, '..' false '2.5' true
 （2）"e"只有有一个，必须两边都有数，而且e后面的数可以有正负号"1e-10" true, 'e9' false, '7e' false
 （3）"e" 和 '.'  可以有"45.e9",true, 但是不可以"45e9." why?我也不知道，我总觉"45.e9"也不是很对
 */
public class Test65 {
    public boolean isNumber(String s) {
        if (s == null)
            return false;
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }
        if (start > end)
            return false;
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasDot = false;
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }
        // first judge +/-
        while (start <= end) {

            if (s.charAt(start) >= '0' && s.charAt(start) <= '9') {
                // is number
                hasNum = true;
            } else if (s.charAt(start) == 'e') {
                if (hasE || !hasNum)
                    return false;
                hasE = true;
                hasNum = false;
            } else if (s.charAt(start) == '.') {
                if (hasDot || hasE)
                    return false;
                hasDot = true;
            } else if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                if (s.charAt(start - 1) != 'e')
                    return false;
            } else {
                return false;
            }
            start++;
        }
        return hasNum;
    }
}
