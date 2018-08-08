package Offer;

import java.util.HashMap;

//数组中出现次数超过一半的数字
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
public class Test39 {
    public static void main(String[] args) {
        int[] arr={1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum(arr,arr.length));
    }
    public static int MoreThanHalfNum(int[] numbers,int length){
        if(checkInvalidArray(numbers))
            return 0;
        int middle=length>>1;
        int start=0;
        int end=length-1;
        int index=partition(numbers,start,end);
        while (index!=middle){
            if(index>middle){
                index=partition(numbers,start,end-1);
            }else{
                index=partition(numbers,start+1,end);
            }
        }
        return index;
    }
    public static boolean checkInvalidArray(int[] numbers){
        if(numbers==null||numbers.length<=0)
            return false;
        return true;
    }
    public static boolean checkMoreThanHalf(int[] numbers,int length,int number){
        int times=0;
        for(int i=0;i<length;i++){
            if(numbers[i]==number)
                times++;
        }
        if(times*2<=length)
            return false;
        return true;
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

    //利用java的语法特性
    public int MoreThanHalfNum_Solution1(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<array.length;i++){
            if(map.get(array[i])!=null){
                map.put(array[i],map.get(array[i])+1);
            }else{
                map.put(array[i],1);
            }
            if(map.get(array[i])>array.length/2){
                return array[i];
            }
        }
        return 0;
    }
}
