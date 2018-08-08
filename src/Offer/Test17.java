package Offer;

//打印从1到最大的n位数
//输入数字n，按顺序打印出从1到最大的n位十进制数。
public class Test17 {
    public static void main(String[] args){
        //Print1ToMaxOfDigits(2);
        Print1ToMaxOfNDigits(2);
    }
    public static void Print1ToMaxOfDigits(int n){
        if(n<=0) return;
        char[] number=new char[n];
        for(int i=0;i<n;i++){
            number[i]='0';
        }
        while (!increment(number)){
            PrintNumber(number);
        }
    }
    public static boolean increment(char[] num){
        boolean isOverFlow=false;
        int nTakeOver=0;
        int n=num.length;
        for(int i=n-1;i>=0;i--){
            int nSum=num[i]-'0'+nTakeOver;
            if(i==n-1)
                nSum++;
            if(nSum>=10){
                if(i==0)
                    isOverFlow=true;
                else{
                    nSum-=10;
                    nTakeOver=1;
                    num[i]=(char)('0'+nSum);
                }
            }
            else{
                num[i]=(char)('0'+nSum);
                break;
            }
        }
        return isOverFlow;
    }
    public static void PrintNumber(char[] num){
        int n=num.length;
        boolean flag=false;
        for(int i=0;i<n;i++){
            char ch=num[i];
            if(ch!='0')
                flag=true;
            if(flag==true)
                System.out.print(ch);
        }
        System.out.println();
    }

    //方法二，使用排列的方式
    //少打印了一位数
    public static void Print1ToMaxOfNDigits(int n){
        if(n<=0) return;
        char[] num=new char[n];
        for(int i=0;i<10;i++){
            num[0]=(char)(i+'0');
            Print1ToMaxOfNDigitsRecursively(num,n,0);
        }
       // Print1ToMaxOfNDigitsRecursively(num,n,0);
    }
    public static void Print1ToMaxOfNDigitsRecursively(char[] num,int length,int index){
        if(index==length)
        {
            PrintNumber(num);
            return;
        }
        for(int i=0;i<10;i++){
            num[index]=(char)(i+'0');
            Print1ToMaxOfNDigitsRecursively(num,length,index+1);
        }
    }
}
