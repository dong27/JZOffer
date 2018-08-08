package Leetcode;

import java.util.ArrayList;
import java.util.List;

//电话号码的字母组合
//这道题理解成两个层次的遍历，一是给定输入字符串的遍历（如“23”），我们可以理解成进入到更深一层；
// 二是对每一个字符所对应的字母的遍历（如“2”对应的“abc”）。
//回溯+递归
public class Test16 {
    static String[] dict={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> res=new ArrayList<String>();
        if(digits==null||digits.length()==0)
            return res;
        backTracing(new StringBuilder(),digits,0,res);
        return res;
    }
    public static void backTracing(StringBuilder temp,String digits,int index,List<String> res){
        if(temp.length()==digits.length()){
            res.add(temp.toString());
            return;
        }
        for(int i=0;i<dict[digits.charAt(index)-'0'].length();i++){
            temp.append(dict[digits.charAt(index)-'0'].charAt(i));
            backTracing(temp,digits,index+1,res);
            if(temp.length()>0)
                temp.deleteCharAt(temp.length()-1);
        }
    }
}
