class KnapSack {

  static int knapsackBU(int[] w, int[] v, int n, int kw, int[][] r, int[][] s){
    for(int k=1 ; k<=n ; ++k){
      for(int wk=1 ; wk<=kw ; ++wk){
        if(w[k] > wk){
          r[k][wk] = r[k-1][wk] ;
          s[k][wk] = s[k-1][wk] ;
        } else {
          int p = r[k-1][wk] ;
          int q = r[k-1][wk-w[k]] + v[k] ;
          if(p>q){
            r[k][wk] = p ;
          } else {
            r[k][wk] = q ;
          }
        }
      }
    }
    return r[n][kw];
  }

  static int knapsackTD(int[] w , int[] v, int kw, int k, int[][] r, int[][] s){
    if(kw==0 || k==0){
      return 0;
    }
    if(r[k][kw] > 0){
      return r[k][kw] ;
    }
    if(w[k] > kw){
      int p = knapsackTD(w, v, kw, k-1, r, s) ;
      r[k][kw] = p ;
      s[k][kw] = s[k-1][kw] ;
      return p ;
    }
    int p = knapsackTD(w, v, kw, k-1, r, s) ;
    int q = knapsackTD(w, v, kw-w[k], k-1, r, s) + v[k] ;
    if(p > q) {
      r[k][kw] = p ;
      s[k][kw] = s[k-1][kw] ;
      return p ;
    }
    r[k][kw] = q ;
    s[k][kw] = k ;
    return q ;
  }

  public static void main(String[] args){
    int[] v = {0, 2, 3, 6, 10, 11} ;
    int[] w = {0, 1, 1, 2, 3, 3} ;
    int size = Math.min(v.length, w.length);
    int knapWeight = 2 ;
    int[][] r = new int[size][knapWeight+1] ;
    int[][] s = new int[size][knapWeight+1] ;
    System.out.println("Top Down: Maximum value is " + knapsackTD(w, v, knapWeight, size-1, r, s));
    System.out.println("Bottom Up: Maximum value is " + knapsackBU(w, v, size-1, knapWeight , r, s));
  }
}