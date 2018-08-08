package Offer;

import java.util.ArrayList;
import java.util.TreeSet;

//最小的K个数
//输入n个整数，找出其中最小的k个数。
public class Test40 {
    public static void main(String[] args) {

    }

    //采用快排
    public static void getLeastNumbers(int[] input,int n,int k){
        int []output=new int[k];
        if(input==null||input.length<=0) return;
        int start=0;
        int end=input.length-1;
        int index=partition(input,start,end);
        while (index!=k-1){
            if(index>k-1){
                end=index-1;
                index=partition(input,start,end);
            }else{
                start=index+1;
                index=partition(input,start,end);
            }
        }
        for(int i=0;i<k;i++){
            output[i]=input[i];
        }
    }
    public static int partition(int[] input,int start,int end){
        int key=input[start];
        while (start<end){
            while (start<end&&input[end]>=key) end--;
            input[start]=input[end];
            while (start<end&&input[start]<=key) start++;
            input[end]=input[start];
        }
        input[start]=key;
        return start;
    }

    //使用容器
    public static ArrayList<Integer> getLeastNumbers1(int[] input,int k){
        if(input==null) return null;
        ArrayList<Integer> list=new ArrayList<>(k);
        if(k>input.length){
            return list;
        }
        TreeSet<Integer> tree=new TreeSet<Integer>();
        for(int i=0;i<input.length;i++){
            tree.add(input[i]);
        }
        int i=0;
        for(Integer elem:tree){
            if(i>=k) break;
            list.add(elem);
            i++;
        }
        return list;
    }
}
