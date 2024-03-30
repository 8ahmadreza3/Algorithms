class ChangeMaking {

  static int changeMakingBU(int[] coins, int n, int m) {
    int[][] r = new int[n + 1][m + 1] ;
    for (int j=1 ; j<=m ; ++j) {
      r[0][j] = Integer.MAX_VALUE ;
      for (int i=1 ; i<=n ; ++i) {
        r[i][0] = 0 ;
        if (coins[i] > j) {
          r[i][j] = r[i - 1][j] ;
        } else {
          int q = r[i-1][j] ;
          int p = r[i][j-coins[i]] + 1 ;
          r[i][j] = Math.min(q, p);
        }
      }
    }
    return r[n][m] ;
  }

  static int changeMakingTD(int[] coins, int n, int m, int[][] r) {
    if (m == 0) {
      return 0 ;
    } else if (n == 0) {
      return Integer.MAX_VALUE ;
    }
    if (r[n][m] > 0) {
      return r[n][m] ;
    }
    if (coins[n] > m) {
      int p = changeMakingTD(coins, n - 1, m, r) ;
      r[n][m] = p ;
      return p ;
    } else {
      int p = changeMakingTD(coins, n - 1, m, r) ;
      int q = changeMakingTD(coins, n, m-coins[n], r) + 1 ;
      if (q > p) {
        r[n][m] = p ;
        return p ;
      } else {
        r[n][m] = q ;
        return q ;
      }
    }
  }

  public static void main(String[] args) {
    int[] coins = {0, 1, 2, 5, 10} ;
    int amount = 9 ;
    int n = coins.length - 1;
    int[][] r = new int[n+1][amount+1];
    for (int i = 0; i < r.length; ++i) {
      for (int j = 0; j < r[0].length; ++j) {
        r[i][j] = 0;
      }
    }

    System.out.println("Bottom Up: Minimum number of coins is: " + changeMakingBU(coins, n, amount));
    System.out.println("Top Down: Minimum number of coins is: " + changeMakingTD(coins, n, amount, r));
  }
}