import java.util.Arrays;

public class Elevator {
    static int[] s = new int[10];
    static int n = s.length ;
    static  int index = 0;
    private static int minPath(int[] r, int A, int B, int u, int d) {
            if(r[B]>0){
                return r[B];
            }
            if(A==B){
                r[A] = Integer.MAX_VALUE;
                s[n-index-1] = B ;
                index++ ;
                return 0;
            }
            if(A>B){
                r[A-u]=Integer.MAX_VALUE;
                return Integer.MAX_VALUE;
            }
            if(A<0){
                r[A+d] = Integer.MAX_VALUE;
                return Integer.MAX_VALUE;
            }
            if (r[A] > 0) {
                return Integer.MAX_VALUE;
            }
            int p =  minPath(r, A+u, B, u, d);
            int q =  minPath(r, A-d, B, u, d);
            r[A] = Math.min(q, p) +1 ;
            s[n-index-1] = A ;
            index++ ;
            return r[A] ;
    }

    public static void main(String[] args) {
        int B = 5 ;
        int A = 2 ;
        int[] r = new int[ B+1 ] ;
        minPath(r, A, B ,4, 2) ;
        int min = r[A] ;
        if (min <= 0 || min == Integer.MAX_VALUE) {
            System.out.println("khoda zad to kamaret");
        } else {
            System.out.println("bikh karma gozashti. min : " + min );
            System.out.println("min path :"+Arrays.toString(s));
        }
    }
}
