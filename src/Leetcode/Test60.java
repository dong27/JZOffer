package Leetcode;

import java.util.ArrayList;
import java.util.List;

//第k个排列
public class Test60 {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<Integer>();//注意存储1-n
        StringBuilder s = new StringBuilder();
        int times = n-1;
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int factorail = 1;//阶乘
        for(int i=2;i<n;i++){//不要×n
            factorail*=i;
        }
        while(times>=0){
            int indexList = k/factorail;
            s.append(list.get(indexList));
            list.remove(indexList);
            k=k%factorail;
            if(times!=0){
                factorail/=times;
            }
            times--;
        }
        return s.toString();
    }
}
