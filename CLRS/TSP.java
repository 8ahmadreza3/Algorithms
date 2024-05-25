public class TSP {
    static private int n = 4;
    static int[][] costs = {
            {0,10,15,20},
            {5,0,9,10},
            {6,13,0,12},
            {8,8,9,0}
    };
    static int VISITED = (1<<n) -1;
    public static int minGraph(int a, int b){
        if(a == VISITED)
            return costs[b][0];

        int min = Integer.MAX_VALUE;
        for (int i=0 ; i<n; i++){
            if (((a) & (1<<i)) == 0){
                int p = minGraph(a|(1<<i), i) + costs[b][i];
                min = Math.min(min, p);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minGraph(1,0));
    }
}