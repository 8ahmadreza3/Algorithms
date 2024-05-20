import java.util.Arrays;

public class SumPath {
    public static int minPath(int i, int j, int[][] array, int[][] r, int[] s){
        if(r[i][j]>0){
            return r[i][j];
        }
        if(i==0 && j==0) {
            r[0][0] = array[i][j];
            s[0] = 0;
        } else if(j==0){
            r[i][j] = minPath(i-1, j, array, r, s) + array[i][j];
        }else if(i==j){
            r[i][j] = minPath(i-1, j-1, array, r, s) + array[i][j];
        }else {
            int q = minPath(i-1, j, array, r, s);
            int p = minPath(i-1, j-1, array, r, s);
            s[j] = p > q ? j-1 : j;
            r[i][j] = Math.min(p, q) + array[i][j];
        }
        return r[i][j];
    }
    public static void main(String[] args){
        int[][] array = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}} ;
        int i = array.length ;
        int j = array[i-1].length ;
        int[] result = new int[i] ;
        int[][] res = new int[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=0 ; k<j ; ++k){
            min = Math.min(min ,minPath(i-1, k, array, res, result));
            System.out.println("best way for row " + (k+1) + "th is :" + result[k]);
        }
        System.out.println(min);
    }

}