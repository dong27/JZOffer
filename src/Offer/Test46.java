package Offer;

/**
 * 动态规划
 * 把数字翻译成字符串
 */
public class Test46 {
    public static void main(String[] args) {

    }
    public static int translateNumbertoString(int number){
        if(number<0)
            return 0;
        if(number==1)
            return 1;
        return getTranslationCount(Integer.toString(number));
    }
    public static int getTranslationCount(String number){
        int f1=0,f2=1,g=0;
        int temp=0;
        for(int i=number.length()-2;i>=0;--i){
            if(Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))<26)
                g=1;
            else
                g=0;
            temp=f2;
            f2=f2+g*f1;
            f1=temp;
        }
        return f2;
    }

    public static class Test54 {
        public static void main(String[] args) {

        }

    }
}
