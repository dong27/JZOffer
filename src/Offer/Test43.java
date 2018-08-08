package Offer;

//1-n整数中1出现的次数
//输入一个整数，求1-n这n个整数的十进制中表示1出现的次数
public class Test43 {
    public static int numberOf1BetweenAndN(int n){
        if(n<=0){
            return 0;
        }
        String str=n+"";
        return numberOf1(str);
    }
    public static int numberOf1(String str){
        char[] strN=str.toCharArray();
        int length=strN.length;
        if(length==1&&strN[0]=='0'){
            return 0;
        }
        if(length==1&&strN[0]>'1'){
            return 1;
        }
        int numFirstDigit=0;
        if(strN[0]>'1')
            numFirstDigit=(int) Math.pow(10,length-1);
        else if(strN[0]=='1')
            numFirstDigit=Integer.parseInt(str.substring(1))+1;
        int numOtherDigits=(int) ((strN[0]-'0')*(length-1)*Math.pow(10, length-2));
        int numRecursive=numberOf1(str.substring(1));
        return numFirstDigit+numOtherDigits+numRecursive;

    }
}
