public class Test42 {
    public static void main(String[] args) {
        int[] input={1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSumofSub1(input,input.length));
    }
    public static int findGreatestSumofSub(int[] input,int length){
        int curSum=0;
        int greatestSum=0;
        for(int i=0;i<input.length;i++){
            int curData=input[i];
            if(curSum<=0){
                curSum=curData;
            }else{
                curSum+=curData;
            }
            if(curSum>greatestSum)
                greatestSum=curSum;
        }
        return greatestSum;
    }

    //动态规划算法
    public static int findGreatestSumofSub1(int[] input,int length){
        int sum=input[0];
        int max=input[0];
        for(int i=1;i<input.length;i++){
            sum=getMax(sum+input[i],input[i]);
            if(sum>=max)
                max=sum;
        }
        return max;
    }

    public static int getMax(int a,int b){
        return a>b?a:b;
    }
}
