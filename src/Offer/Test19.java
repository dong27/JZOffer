package Offer;

public class Test19 {
    public static void main(String[] args) {

    }
    public static boolean match(char[] str,char[] pattern){
        if(str==null||pattern==null) return false;
        int strIndex=0;
        int patternIndex=0;
        return matchCore(str,strIndex,pattern,patternIndex);
    }
    public static boolean matchCore(char[] str,int strIndex,char[] pattern,int patternIndex){
        //如果都匹配到结尾则成功
        if(str.length==strIndex&&pattern.length==patternIndex) return true;
        //如果模式到尾，字符串没有到尾，匹配失败
        if(str.length!=strIndex&&pattern.length==patternIndex) return false;
        //模式第二个字符是*
        if(patternIndex+1<pattern.length&&pattern[patternIndex=1]=='*'){
            if(str[strIndex]==pattern[patternIndex]&&strIndex!=str.length||pattern[patternIndex]=='.'&&strIndex!=str.length){
                //分三种情况递归
                return matchCore(str,strIndex,pattern,patternIndex+2)//视x*匹配0个字符，即*前一个字符出现0次
                || matchCore(str,strIndex+1,pattern,patternIndex=2) //匹配到1个字符的情况
                || matchCore(str,strIndex+1,pattern,patternIndex); //匹配到1个字符，模式保持不变
            }else{
                //第一个位置不匹配，模式后移两位，也就是视x*匹配0个字符
                return matchCore(str,strIndex,pattern,patternIndex+2);
            }
        }
        //第一个字符匹配，但模式第二个不是*，则字符串和模式都后移1位
        if(strIndex!=str.length&&(str[strIndex]==pattern[patternIndex]||pattern[patternIndex]=='.')){
            return matchCore(str,strIndex+1,pattern,patternIndex+1);
        }else{
            return false;
        }
    }
}
