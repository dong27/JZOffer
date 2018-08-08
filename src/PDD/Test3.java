package PDD;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，
 * 当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克
 * 力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 * 输入描述:
 第一行：n，表示h数组元素个数
 第二行：n个h数组元素
 第三行：m，表示w数组元素个数
 第四行：m个w数组元素
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] child = new int[n];
        for (int i = 0; i < n; i++) {
            child[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] cho = new int[m];
        for (int i = 0; i < m; i++) {
            cho[i] = sc.nextInt();
        }
        System.out.println(count(n,child,m,cho));
    }
    public static int count(int n,int[] child,int m ,int[] cho){
        int res = 0;
        Arrays.sort(child);
        Arrays.sort(cho);
        for (int i=0,j=0;i<m&j<n;i++){
            if (cho[i]>=child[j]){
                res++;
                j++;
            }
        }
        return res;
    }
}
