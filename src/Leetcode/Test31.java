package Leetcode;

//下一个排列

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class Test31 {
    public void nextPermutation(int[] num) {
        if(num==null||num.length==0)
            return ;
        int i=num.length-2;
        while(i>=0&&num[i]>=num[i+1])
            i--;
        if(i>=0){
            int j=i+1;
            while(j<num.length&&num[j]>num[i])
                j++;
            j--;
            swap(num,i,j);
        }
        reverse(num,i+1,num.length-1);
    }
    public void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
    }
    public void reverse(int[] num,int i,int j){
        while(i<j)
            swap(num,i++,j--);
    }
}

