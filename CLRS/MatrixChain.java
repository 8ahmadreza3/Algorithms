class MatrixChain{

  static int matrixChainBU(int[] p, int n){
    int[][] r = new int[n][n];
  }

  static int matrixChainTD(int[] p, int i, int j, int[][] r){
    if(j <= i)
      return 0;
    if(r[i][j] > 0)
      return r[i][j] ;
    int min = Integer.MAX_VALUE ;
    for(int k=i ; k<j ; ++k){
      int q = matrixChainTD(p, i, k, r) + matrixChainTD(p, k+1, j, r) + p[i] * p[k+1] * p[j+1] ;
      if(q < min){
        min = q ;
      }
    }
    r[i][j] = min ;
    return min ;
  }

  public static void main(String[] args){


  }
}