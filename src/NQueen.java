public class NQueen {
    static boolean isSafe(int[][] arr,int x,int y,int n){
        for(int row = 0;row <x;row++){//here we check there is no any queen is present in the col
            if(arr[row][y] == 1){
                return false;
            }
        }
        int row  = x;
        int col = y;
        while(row >= 0 && col>=0){
            if(arr[row][col] ==1){
                return false;
            }
            row--;
            col--;
        }
        row = x;
        col = y;
        while(row >= 0 && col<n){
            if(arr[row][col] ==1){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }
    static boolean nQueen(int[][] arr,int x,int n){
        if(x>=n){//here we placed all the queen at there particular position
            return true;
        }
        for(int col = 0;col<n;col++){
            if(isSafe(arr,x,col,n)){
                arr[x][col] =1;
                if(nQueen(arr,x+1,n)){
                    return true;
                }
                arr[x][col] = 0;//this step is backtracking
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        int[][] arr2 = {{0,0,0},
                {0,0,0},
                {0,0,0}};
        int[][] arr1 = {{0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}};
        nQueen(arr1,0, arr1.length);
        for(int[] el:arr1){
            for(int e:el){
                System.out.print(e);
            }
            System.out.println();
        }
    }
}
