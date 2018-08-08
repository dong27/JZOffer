package Leetcode;

//回文数
public class Test9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
    public static boolean isPalindrome(int x) {
        String str=Integer.toString(x);
        int start=0;
        boolean flag=true;
        int end=str.length()-1;
        while (start<=end){
            if(str.charAt(start)!=str.charAt(end))
                flag=false;
            start++;
            end--;
        }
        return flag;
    }
}
