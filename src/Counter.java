class Counter{
    void increment(int[] c){
        int k = c.length ;
        for(int i=k-1 ; i>=0 ; --i){
            if(a[i] == 0) {
                a[i] = 1;
                break;
            } else
                a[i] = 0;
        }
    }

    void decrement(int[] c){
        int k = c.length ;
        for(int i=k-1 ; i>=0 ; --i){
            if(a[i] == 1) {
                a[i] = 0;
                break;
            } else
                a[i] = 1;
        }
    }
}