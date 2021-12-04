package com.interview.xsj.bishi.mocktest.huawei2016.test3;

/**
 * @author xsj
 * @create 2021-07-19 17:16
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] rowUsed;
        boolean[][] colUsed;
        boolean[][][] cubeUsed;
        while (sc.hasNext()) {
            int[][] matrix = new int[9][9];
            rowUsed = new boolean[9][10];
            colUsed = new boolean[9][10];
            cubeUsed = new boolean[3][3][10];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (matrix[i][j] != 0) {
                        rowUsed[i][matrix[i][j]] = true;
                        colUsed[j][matrix[i][j]] = true;
                        cubeUsed[i / 3][j / 3][matrix[i][j]] = true;
                    }
                }
            }
            solve(matrix, rowUsed, colUsed, cubeUsed, 0, 0);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
    private static boolean solve(int[][] matrix,boolean[][] rowUsed,boolean[][] colUsed,
                                 boolean[][][] cubeUsed,int row,int col){
        if(col==matrix[0].length){
            row++;
            col=0;
            if(row==matrix.length){
                return true;
            }
        }
        if(matrix[row][col]==0){
            //需要填充
            for(int num=1;num<=9;num++){
                if(rowUsed[row][num]||colUsed[col][num]||cubeUsed[row/3][col/3][num]){
                    continue;
                }
                rowUsed[row][num]=colUsed[col][num]=cubeUsed[row/3][col/3][num]=true;
                matrix[row][col]=num;
                if(solve(matrix,rowUsed,colUsed,cubeUsed,row,col+1)){
                    return true;
                }
                matrix[row][col]=0;
                rowUsed[row][num]=colUsed[col][num]=cubeUsed[row/3][col/3][num]=false;
            }
        }else{
            return solve(matrix,rowUsed,colUsed,cubeUsed,row,col+1);
        }
        return false;
    }

}