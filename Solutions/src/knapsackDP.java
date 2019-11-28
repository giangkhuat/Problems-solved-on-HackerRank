

public class knapsackDP {

  
  public static int recursive(int maxPossible, int[] vals, int[] weights, int pos) {
    if (pos == 0 || maxPossible == 0) {
      return 0;
    }
    if (weights[pos-1] > maxPossible) {
      return recursive(maxPossible, vals, weights, pos-1);
    } else {
      // including the current 
      int max_incl = vals[pos-1] + recursive(maxPossible - weights[pos-1], vals, weights,pos -1 );
      int max_excl = recursive(maxPossible, vals, weights, pos-1);
      return Math.max(max_incl, max_excl);
    }
    
  }
  
  
  public static int knapsackDp(int W, int[] wt, int[] vals, int n) {
    int[][] table = new int[n+1][W+1];
    int i = 0, w = 0;
    
    for (i = 0; i<= n ;i++ ) {
      for ( w = 0; w <= W; w++) {
        if (i == 0 || w == 0) {
          table[i][w] = 0;
        } else if (wt[i-1] <= w) {
          int val_including_current = vals[i-1] + table[i-1][w - wt[i-1]];
          int val_excld = table[i-1][w];
          table[i][w] = Math.max(val_including_current, val_excld);
        } else {
          table[i][w] = table[i-1][w];
        }
      }
    }

    return table[n][W];
    
  }
  public static void main(String[] args) throws Exception {
    int[] weights = new int[] {10, 20, 30};
    int[] vals = new int[] {60, 100, 120};
    int max_weight = 60;
    int n = vals.length;
   // System.out.println(recursive(max_weight, vals, weights, vals.length));
    System.out.println(knapsackDp(max_weight,  weights,vals, n));
    
    
    
  }
}
