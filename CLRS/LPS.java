public class LPS {

  public static int lpsBU(char[] x){
    int n = x.length ;
    int[][] c = new int[n][n] ;
    for(int i=0 ; i<n ; i++) {
      c[i][i] = 1 ;
    }

    for(int i=n-1 ; i>=0 ; i--) {
      for(int j=i+1 ; j<n-i ; j++){
        if (i > j)
          c[i][j] = 0 ;
        else if (x[i] == x[j])
          c[i][j] = c[i+1][j-1] + 2 ;
        else
          c[i][j] = Math.max(c[i+1][j], c[i][j-1]) ;
      }
    }
    return c[0][n-1] ;
  }

  public static void main(String[] args) {
    char[] x = "ahamdreza".toCharArray() ;
    System.out.println("Bottom Up: Longest palindromic substring is: " + lpsBU(x));
  }
}