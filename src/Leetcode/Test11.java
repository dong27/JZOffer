package Leetcode;

//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，
// 使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
public class Test11 {
    public static void main(String[] args) {

    }
    public static int maxArea(int[] heights){
        if(heights==null&&heights.length==0){
            return 0;
        }
        int l=0;
        int r=heights.length-1;
        int maxArea=0;
        while (l<r){
            maxArea=Math.max(maxArea,Math.min(heights[l],heights[r])*(r-l));
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
