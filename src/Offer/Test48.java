package Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

//最长不含重复字符的子
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
public class Test48 {
    public static void main(String[] args) {
        System.out.println(longestSubStringWithoutDuplication1("arabcacfr"));
    }
//    public static int longestSubStringWithoutDuplication(String str){
//        if(str.length()==0) return 0;
//        int max=0;// 全局最长
//        int cur=0;//当前最长
//        char[] arr=str.toCharArray();
//        Vector hash=new Vector(26,-1);
//        for(int i=0;i<str.length();i++){
//            int preidx=hash[arr[i]-'a'];
//        }
//    }
    public static int longestSubstringWithoutDuplication(String str){
        if(str.length()==0) return 0;
        int maxLength=1;
        List<Character> list=new ArrayList<Character>();
        list.add(str.charAt(0));
        for(int i=0;i<str.length();i++){
            if(list.contains(str.charAt(i))){
                int index=list.indexOf(str.charAt(i));
                list=list.subList(index+1,list.size());
                list.add(str.charAt(i));
                maxLength=Math.max(maxLength,list.size());

            }else{
                list.add(str.charAt(i));
                maxLength=Math.max(maxLength,list.size());
            }
        }
        return maxLength;
    }
    //剑指offer解法
    public static int longestSubStringWithoutDuplication1(String str){
        int curLenght=0;
        int maxLength=0;
        if(str.length()==0) return 0;
        int []position=new int[26];
        for(int i=0;i<position.length;i++)
            position[i]=-1;
        for(int i=0;i<str.length();i++){
            int prevIndex=position[str.charAt(i)-'a'];
            if(prevIndex<0||i-prevIndex>curLenght){
                ++curLenght;
            }else{
                if(curLenght>maxLength)
                    maxLength=curLenght;
                curLenght=i-prevIndex;
            }
            System.out.println(curLenght);
            position[str.charAt(i)-'a']=i;
        }
        if(curLenght>maxLength)
            maxLength=curLenght;
        return maxLength;
    }
}
