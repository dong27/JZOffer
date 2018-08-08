package PDD;

import java.util.Scanner;

//给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            long[] nums=new long[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextLong();
            }
            long max1=Long.MIN_VALUE;
            long max2=Long.MIN_VALUE;
            long max3=Long.MIN_VALUE;
            long min1=Long.MAX_VALUE;
            long min2=Long.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(nums[i]>max1){
                    max3=max2;
                    max2=max1;
                    max1=nums[i];
                }else if(nums[i]>max2){
                    max3=max2;
                    max2=nums[i];
                }else if(nums[i]>max3){
                    max3=nums[i];
                }
                if(nums[i]<min1){
                    min2=min1;
                    min1=nums[i];
                }else if(nums[i]<min2)
                    min2=nums[i];
            }
            System.out.println(Math.max(min1*min2*max1,max1*max2*max3));
        }
    }
}
