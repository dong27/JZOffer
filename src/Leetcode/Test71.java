package Leetcode;

//简化路径

import java.util.Stack;

/**
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 例如，
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
public class Test71 {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<String> ();
        while(path.length()>0){
            int start=path.indexOf("/"); //第一个斜杠的位置
            path=path.substring(start+1); //Path一进被截取
            int end=path.indexOf("/");//第二个斜杠的位置
            if(end==-1)
                end=path.length();

            String part=path.substring(0,end);
            path=path.substring(end);

            // System.out.println(part+"  "+path);
            if(part.equals(".") || part.equals(""))
                continue;
            if(part.equals("..")){
                if(stack.isEmpty()==false)
                    stack.pop();
            }
            else stack.push("/"+part);
        }
        String result="";
        while(stack.isEmpty()==false){
            result=stack.pop()+result;
        }
        if(result.length()==0)
            result="/";
        return result;
    }
}
