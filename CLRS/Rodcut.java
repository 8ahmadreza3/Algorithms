import java.util.Arrays;

class Rodcut {
  static int rodcutBU(int[] price, int n){
    int[] r = new int[n+1];
    r[0] = 0 ;
    r[1] = price[1] ;
    for(int i=2 ; i<=n ; ++i){
      int max = -1 ;
      for(int k=1 ; k<=i ; ++k){
        int p = price[k] + r[i-k];
        if(p > max){
          max = p ;
        }
      }
      r[i] = max ;
    }
    return r[n] ;
  }

  static int rodcutTD(int[] price, int index, int[] r){
    if (index <= 1) {
      return price[index];
    }
    if( r[index] > 0){
      return r[index];
    }
    int max = Integer.MIN_VALUE;
    for(int k=1 ; k<=index ; ++k){
      int p = price[k] + rodcutTD(price, index - k, r);
      if(p > max){
        max = p ;
      }
    }
    r[index] = max ;
    return max ;
    }

  public static void main(String[] args){
    int[] price = { 0, 5, 7};
    int size = price.length;
    int[] r = new int[size];
    System.out.println("Top Down: Maximum Value is " + rodcutTD(price, size - 1, r));
    System.out.println("Bottom Up: Maximum Value is " + rodcutBU(price, size - 1));
  }
}