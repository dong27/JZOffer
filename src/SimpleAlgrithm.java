public class SimpleAlgrithm {
    //1.选择排序，每次选择最小的
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=minIndex+1;j<arr.length;j++){
                if(arr[i]>arr[j])
                    minIndex=j;
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
    //2.插入排序
    public static void insertSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int j=i;
            int target=arr[i];
            while (j>0&&target<arr[j]){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=target;
        }
    }
    //3.冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    //4.快速排序
    public static void quicSort(int[] arr,int low,int high){
       int start=low;
       int end=high;
       int key=arr[low];
       while (start<end){
           while (arr[end]>key)
               end--;
           if(arr[end]<key){
               int temp=arr[end];
               arr[end]=arr[start];
               arr[start]=temp;
           }
           while (arr[start]<key)
               start++;
           if(arr[start]>key){
               int temp=arr[start];
               arr[start]=arr[end];
               arr[end]=temp;
           }
       }
       if(low<start) quicSort(arr,low,start-1);
       if(end<high) quicSort(arr,end+1,high);
    }
    public static void merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=high){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid)
            temp[k++]=arr[i++];
        while (j<=high)
            temp[k++]=arr[j++];
        for(int k1=0;k1<temp.length;k1++){
            temp[k1+low]=arr[k1];
        }
    }
    public static void mergeSort(int[] arr,int low,int high){
        int mid=(low+high)/2;
        if(low<high){
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void main(String[] args) {
        int[] arr={4,2,5,1,6,3};
        quicSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
