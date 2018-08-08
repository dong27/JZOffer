package Offer;

//正则表达式匹配
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
                || matchCore(str,strIndex+1,pattern,patternIndex+2) //匹配到1个字符的情况
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

    //字符串格式
    public boolean matchFunction(String input,String pattern){
        if(input==null||pattern==null) return false;
        return matchCoreFunction(input,0,pattern,0);
    }
    public boolean matchCoreFunction(String input,int i,String pattern,int p){
        //两个字符串都到达了末尾，则说明匹配成功，返回true
        if(i>=input.length()&&p>=pattern.length()) return true;
        //模式串到了结尾，说明匹配失败
        if(i!=input.length()&&p==pattern.length()) return false;
        //模式串未结束，匹配串可能结束也可能未结束
        if(p+1<pattern.length()&&pattern.charAt(p+1)=='*'){
            //匹配串已经结束
            if(i>=input.length()){
                return matchCoreFunction(input,i,pattern,p+2);
            }else{ //匹配串还未结束
                if(pattern.charAt(p)==input.charAt(i)||pattern.charAt(i)=='.'){
                    return matchCoreFunction(input,i+1,pattern,p+2) //pattern所指下一个字符为'*'时
                    || matchCoreFunction(input,i+1,pattern,p)// pattern所指下一个字符为'.'时
                    || matchCoreFunction(input,i,pattern,p+2);
                }else{
                    return matchCoreFunction(input,i,pattern,i+2);
                }
            }
        }
        if(i>=input.length()){
            return false;
        }else{
            if(input.charAt(i)==pattern.charAt(p)||pattern.charAt(p)=='.'){
                return matchCoreFunction(input,i+1,pattern,p+1);
            }
        }
        return false;
    }
}
