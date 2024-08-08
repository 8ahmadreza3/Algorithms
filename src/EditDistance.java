public class EditDistance {

    private static int minCost(String x, String y, int i, int j) {
        int n = x.length();
        int m = y.length();
        if(i>=n)
            return m-j;
        else if(j>=m)
            return n-i;
        else if(x.charAt(i-1)==y.charAt(j-1))
            return minCost(x,y,i+1,j+1);
        int q = 1 + minCost(x, y, i, j+1);
        int p = 1 + minCost(x, y, i+1,j);
        int z = 1 + minCost(x, y, i+1,j+1);
        int min = Integer.MAX_VALUE;
        if (p<q & p<z)
            min = p;
        else if (q<p & q<z)
            min = q;
        else
            min=z;
        return min;
    }

    public static void main(String[] args) {
        String x = "ahmadrezaa";
        String y = "ahmmadreza";
        System.out.println(minCost(x, y, 1, 1));
    }
}