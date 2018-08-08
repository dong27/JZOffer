package Offer;

//字符串排列
//输入一个字符串，打印出该字符串中字符的所有排列。
public class Test38 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("abc");
        function(sb,0);
    }
    public static void function(StringBuilder sb,int index){
        if(sb==null||index<0) return;
        if(index==sb.length()-1) {
            System.out.println(sb);
        }else{
            for(int i=index;i<sb.length();i++){ //依次交换当前以及后面的字符，从当前位置开始
                char temp=sb.charAt(i);
                sb.setCharAt(i,sb.charAt(index));
                sb.setCharAt(index,temp);

                //递归求该字符后的字符
                function(sb,index+1); //当前字符已经确定，递归处理余下的字符
                //再次交换第一个字符和sb.charAt(i)
                temp=sb.charAt(i);

                //因为当前和一个位置交换以后，还要和其他位置交换，所以要交换回来
                sb.setCharAt(i,sb.charAt(index));
                sb.setCharAt(index,temp);
            }
        }
    }
}
