package Stirling;

public class Stirling {
    static long factorial(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return -1;

        long res = 1;
        for (int i=2 ; i<n+1 ; ++i)
            res *= i;

        return res;
    }

    static long stirling_k1_TD(int n, int m) {
        if (m > n)
            return -1;
        if (m == 0)
            return 0;
        if (n == m)
            return 1;
        if (m == 1)
            return factorial(n-1);

        return stirling_k1_TD(n-1, m-1) + (n-1) * stirling_k1_TD(n-1, m);
    }

    static long stirling_k1_BU(int n, int m) {
        long[][] dp = new long[m+1][n+1];

        for (int i=0 ; i<=m; i++)
            dp[i][i] = 1;
        for (int i=1; i<=n ; i++)
            dp[1][i] = factorial(i-1);

        for (int i=2 ; i<=m ; i++)
            for (int j=2 ; j<=n ; j++)
                dp[i][j] = dp[i-1][j-1] + (j-1) * dp[i][j-1];

        return dp[m][n];
    }

    static long stirling_k2_TD(int n, int m) {
        if (m > n)
            return -1;
        if (m == 0)
            return 0;
        if (n == m)
            return 1;
        if (m == 1)
            return 1;
        else
            return stirling_k2_TD(n-1, m-1) + m * stirling_k2_TD(n-1, m);
    }

    static long stirling_k2_BU(int n, int m) {
        long[][] dp = new long[m+1][n+1];

        for (int i=0 ; i<=m ; i++)
            dp[i][i] = 1;
        for (int i=1 ; i<=n ; i++)
            dp[1][i] = 1 ;

        for (int i=2 ; i<=m ; i++)
            for (int j = 2; j <= n; j++)
                dp[i][j] = dp[i-1][j-1] + i * dp[i][j-1];

        return dp[m][n];
    }

    public static void main(String[] args){
        System.out.println(stirling_k1_TD(10,5));
        System.out.println(stirling_k1_BU(10,5));
        System.out.println(stirling_k2_TD(10,5));
        System.out.println(stirling_k2_BU(10,5));
    }
}
