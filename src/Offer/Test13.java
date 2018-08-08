package Offer;

import java.util.Scanner;

//机器人的运动范围
//地上有个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，它每一次可以向左、右、上、下移动一格，
// 但不能进入行坐标和列坐标的数位之和大于k的格子。
public class Test13 {
    public static int movingCount(int threshold,int rows,int cols){
        boolean[] visited=new boolean[rows*cols];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        int count=movingCountCore(threshold,rows,cols,0,0,visited);
        return count;
    }
    public static int movingCountCore(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        int count=0;
        if(check(threshold,rows,cols,row,col,visited)){
            visited[row*cols+col]=true;
            count=1+movingCountCore(threshold,rows,cols,row-1,col,visited)+
                    movingCountCore(threshold,rows,cols,row,col-1,visited)+
                    movingCountCore(threshold,rows,cols,row+1,col,visited)+
                    movingCountCore(threshold,rows,cols,row,col+1,visited);
        }
        return count;
    }
    public static boolean check(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        if(row >= 0 && row < rows && col >= 0 && col < cols
                && (getDigitSum(row) + getDigitSum(col) <= threshold)
                && !visited[row* cols + col])
            return true;
        return false;
    }
    public static int getDigitSum(int number){
        int sum = 0;
        while(number > 0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入限制条件k:");
        int k = scanner.nextInt();
        System.out.println("请输入方格的行数m：");
        int m = scanner.nextInt();
        System.out.println("请输入方格的列数n:");
        int n = scanner.nextInt();

        scanner.close();
        System.out.println("矩阵能到达的方格数是：");
        System.out.println(movingCount(k, m, n));
    }
}
