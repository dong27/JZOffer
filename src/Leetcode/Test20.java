package Leetcode;

import java.util.Stack;

//有效的括号
public class Test20 {
    boolean isValid(String s) {
        Stack<Character> temp=new Stack<>();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if (x == '(') temp.push(')');
            else if (x == '[') temp.push(']');
            else if (x == '{') temp.push('}');
            else {
                if (temp.empty() || temp.peek() != x)
                    return false;
                else
                    temp.pop();
            }
        }
        return temp.empty();
    }
}
