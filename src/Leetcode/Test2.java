package Leetcode;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(atoi("   -42"));
       // atoi("asef-123adb");
       // System.out.println(Integer.MAX_VALUE);
       // System.out.println(Integer.MIN_VALUE);
    }
    public static int atoi(String str){
        if(str.length()<1) return 0;
        //过滤字符串开头空格
        int pos=0;
        while (pos<str.length()&&str.charAt(pos)==' '){
            pos++;
        }
        str=str.substring(pos,str.length());
        //过滤空串
        if(str.equals("")) return 0;
        //数据为正或负 true为正
        boolean operator=true;
        String numString;
        //字符串开头非数字情况
        if(str.charAt(0)<'0'||str.charAt(0)>'9'){
            //非+或者-不合法返回0
            if(str.charAt(0)!='+'&&str.charAt(0)!='-') return 0;
            //数字为负数
            if(str.charAt(0)=='-')
                operator=false;
            //获取数值
            numString=getNumStr(str.substring(1,str.length()));
        }else{
            numString=getNumStr(str);
        }
        //过滤数据部分为空串的情况
        if(numString.equals("")) return 0;
        //过滤掉数据超出Long的情况
        if(numString.length()>10){
            if(operator)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        //转化数值
        long num=Long.parseLong(numString);
        if(!operator)
            num=-num;
        //根据结果范围返回数值
        if(num<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(num>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int)num;
    }
    //截取字符串的开头数值
    public static String getNumStr(String s){
        StringBuilder num=new StringBuilder();
        boolean isStart=true;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (isStart && s.charAt(i) == '0') {
                    continue;
                }
                isStart = false;
                num.append(s.charAt(i));
            } else {
                break;
            }
        }
        return num.toString();
    }
}
