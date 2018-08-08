package Leetcode;

//最长公共前缀
public class Test14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0)return "";
        String com = strs[0];
        for(int i=1;i<strs.length;i++){
            //计数
            int index =0;
            while(index<strs[i].length()&&index<com.length()
                    &&strs[i].charAt(index) == com.charAt(index)){
                //!!不能用if比较strs[i].charAt(index) == com.charAt(index)
                index++;
            }
            if(index==0)return "";
            ////再求出共同的字串，再去和之后的对比
            com = com.substring(0,index);
        }
        return com;
    }
}
