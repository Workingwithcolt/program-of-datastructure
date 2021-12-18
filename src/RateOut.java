import java.util.Scanner;

public class RateOut {
    static boolean isSafe(int[][] arr,int x,int y,int n){
        if(x <  n && y<n && arr[x][y] == 1){
            return true;
        }else{
            return false;
        }
    }
    static boolean rateinMaze(int[][] arr,int x,int y,int n,int[][] solArr){
        if(x == n-1 && y == n-1){
            solArr[x][y] = 1;
            return true;
        }
        if(isSafe(arr,x,y,n)){
            solArr[x][y] = 1;
            if(rateinMaze(arr,x+1,y,n,solArr)){//to move the right direction
                return true;
            }
            if(rateinMaze(arr,x,y+1,n,solArr)){//to move the downward
                return true;
            }
            solArr[x][y] = 0;//Backtracking here we intantiate the position by setting it the
            //the zero
            return false;
        }
        return false;
    }
    public static void main(String [] args){
        int n;
        n = 5;
        int[][] solarr ={
                {1,0,1,0,1},
                {1,1,1,1,1},
                {0,1,0,1,0},
                {1,0,0,1,1},
                {1,1,1,0,1}};
        int[][] arr = {{0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}};
        rateinMaze(solarr,0,0,n,arr);
        for (int[] el:arr) {
            for (int e:el) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
}
