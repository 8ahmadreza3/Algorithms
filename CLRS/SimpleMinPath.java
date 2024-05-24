public class SimpleMinPath {
    static int minPath(int ia, int ja, int ib, int jb, int[][]w){
        if(ia==ib && ja==jb) {
            return 0;
        }
        if(ja > jb || ia > ib) {
            return Integer.MAX_VALUE ;
        }
        return Math.min(minPath(ia, ja, ib-1, jb, w), minPath(ia, ja, ib, jb-1, w)) + w[ib][jb] ;
    }
    public static void main(String[] args) {
        int ia = 0 , ja = 3 ;
        int ib = 3 , jb = 3 ;
        int[][] w = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {5, 6, 7, 8},
                {7, 8, 9, 10}
        };
        System.out.println(minPath(ia, ja, ib, jb, w));
    }
}
