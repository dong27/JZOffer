package Leetcode;

//格雷编码

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 */
public class Test89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        if(n==0){
            ret.add(0);
            return ret;
        }
        ret.add(0);
        ret.add(1);
        int dp=1;
        for(int i=1;i<n;i++){
            dp=dp*2;
            int len=ret.size();
            for(int j=len-1;j>=0;j--){
                ret.add(ret.get(j)+dp);
            }
        }
        return ret;
    }
}
