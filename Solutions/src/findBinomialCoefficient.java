
public class findBinomialCoefficient {
  
  /*
   * Reference Link:
   * http://www.csl.mtu.edu/cs4321/www/Lectures/Lecture%2015%20-%20Dynamic%20Programming%20Binomial%20Coefficients.htm
   */

  public static void main(String[] args) throws Exception {
    int n = 5;
    int k = 2;
    System.out.println("Coefficient of nCk is " + binCoefRec(n, k));
    System.out.println("Coefficient of nCk is " + binCoefDynProg(n, k));
    
  }
  public static int binCoefRec(int n, int k) {
    if (n == k || k == 0) {
      return 1;
    } else {
      return binCoefRec(n-1, k -1) + binCoefRec(n-1, k);
    }
  }
  
  public static int binCoefDynProg(int n, int k) {
    int[][] dp = new int[n+1][k+1];
    
    for (int i = 0; i <= n; i++) {
      int min = Math.min(i, k);
      for (int j = 0; j <= min; j++) {
        if (j == 0 || j == i) {
          // two edges of the triagle table
          dp[i][j] = 1;
        } else  {
          // nCk = (n-1)C(k-1) + (n-1)C(k)
          dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }
      }
    }
    return dp[n][k];
    
  }
  
}
