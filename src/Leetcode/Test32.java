package Leetcode;

import java.util.LinkedList;

//最长有效括号
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

/**
 * 1、使用栈，遇到左括号，把左括号的下标入栈。
 2、遇到右括号时，
 （1）若此时栈内为空，则将序列开始标识start变为i + 1(说明之前有效括号序列终止重新开始)
 （2）若此时栈不空，则出栈，若此时栈为空，计算有效序列长度为 i - start + 1，更新记录max；若此时栈不空，则计算有效序列长度为i - 栈顶元素值，更新记录max。
 （3）最后max值即为最长有效括号序列长度。
 */
public class Test32 {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(') stack.addFirst(i);//左括号入栈
            else if (s.charAt(i) == ')')//若为右括号
            {
                if (stack.size() == 0)
                    start = i + 1;
                else
                {
                    stack.removeFirst();
                    if (stack.size() == 0)
                    {
                        if (i - start + 1 > max)
                            max = i - start + 1;
                    }
                    else
                    {
                        if (i - stack.getFirst() > max)
                            max = i - stack.getFirst();
                    }

                }
            }

        }
        return max;
    }
}

