package Offer;

import java.util.Scanner;

//连续子数组的最大和
//输入一个整形数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有的子数组的和的最大值。
public class Test42 {
    public int FindGreatestSumOfSubArray(int[] array) {

        if(array == null || (array.length == 1 && array[0] <= 0))
            return 0;

        int cur = array[0];
        int sum = array[0];
        for(int i = 1;i < array.length;i++){
            if(cur < 0)
                cur = 0;
            cur = cur + array[i];
            if(sum <= cur)
                sum = cur;
        }
        return sum;
    }
    //用动态规划
    public int FindGreatestSumOfSubArray2(int[] arr,int n){
        int sum = arr[0];
        int max = arr[0];
        for(int i = 1; i < n; i++){
            sum = getMax(sum+arr[i],arr[i]);
            if(sum >= max)
                max = sum;
        }

        return max;
    }

    public int getMax(int a,int b){
        return a > b ? a: b;
    }
    public static void main(String args[]){
        Test42 ts = new Test42();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = scan.nextInt();
            System.out.println(ts.FindGreatestSumOfSubArray(a));
            System.out.println(ts.FindGreatestSumOfSubArray2(a,a.length));
        }
    }
}
