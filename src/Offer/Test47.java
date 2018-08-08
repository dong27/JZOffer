package Offer;

//礼物的最大值
//在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0)。你可以从棋盘的左上角开始拿格子里的礼物，
//并每次向左或向下移动一格，直到到达棋盘的右下角。给定一个棋盘及上面的礼物，计算最多能拿到多少价值的礼物。

public class Test47 {
    public static void main(String[] args) {
        int[][] data= {{1, 10, 3, 8},
                        {12,2,9,6},
                        {5,7,4,11},
                        {3,7,16,5}
                        };
        System.out.println(getMaxValue(data));
    }
    public static int getMaxValue(int[][] data){
        int row=data.length;
        int col=data[0].length;
        if(data==null) return 0;
        int []maxValue=new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int left=0;
                int up=0;
                if(i>0)
                    up=maxValue[j];
                if(j>0)
                    left=maxValue[j-1];
                maxValue[j]=Math.max(up,left)+data[i][j];
            }
        }
        int max=maxValue[col-1];
        return max;
    }
}
