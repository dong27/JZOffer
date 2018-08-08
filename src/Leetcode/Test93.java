package Leetcode;

//复原IP地址
import java.util.ArrayList;
import java.util.List;

//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

/**
 * 这道题其实就是回溯了，IP地址的判断规则是：
 {
 每一段都必须有数字，数字在0~255之间
 一共四段数字
 }
 */
public class Test93 {
    List<String> result;
    char[] digits;
    /**
     * 回溯，为了加快速度可以提前计算下是否可行
     * */
    public void find(int part,int value,String tmp,int index){
        if(part >3 || index>=digits.length){
            if(part ==  3 && index==digits.length){
                result.add(tmp);
            }
            return ;
        }
        if(value*10+digits[index]<=255  && value!=0){
            find(part,value*10+digits[index],tmp+(int)digits[index],index+1);
        }
        find(part+1,digits[index],tmp+"."+(int)digits[index],index+1);

    }
    public List<String> restoreIpAddresses(String s) {
        result=new ArrayList<String>();
        if(s.length()<1)
            return result;
        digits=s.toCharArray();
        for(int i=0;i<s.length();i++)
            digits[i]-='0';
        find(0,digits[0],""+(int)(digits[0]),1);
        return result;
    }
}
