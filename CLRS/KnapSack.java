class KnapSack {

  static int knapsackBU(){

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

  }
}