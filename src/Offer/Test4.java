package Offer;

//二维数组中的查找
//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 /*
     * 选取数组查找范围内的右上角的数字，如果该数字等于要查找的数字，则查找结束。
     * 如果该数字小于要查找的数字，则剔除该数字所在的行；
     * 如果该数字大于要查找的数字，则剔除该数字所在的列；
     */
public class Test4 {
    public static boolean findByTheUpperRightCorner(int target,int[][] array){
        if(array.length>0){
            int rows=array.length;
            int columns=array[0].length;
            int row=0;
            int column=columns-1;
            while (row<rows&&column>=0){
                if(array[row][column]==target)
                    return true;
                if(array[row][column]>target)
                    column--;
                else
                    row++;
            }
            return false;
        }
        return false;
    }
}
