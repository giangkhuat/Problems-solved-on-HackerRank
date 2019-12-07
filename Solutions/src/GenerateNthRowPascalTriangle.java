import java.util.ArrayList;
import java.util.List;

public class GenerateNthRowPascalTriangle {
  public static void main(String[] args) throws Exception {
    ArrayList<Integer> nthRow = computeNthRow(5);

    for (int i = 0; i < nthRow.size(); i++) {
      System.out.print(nthRow.get(i) + " ");
    }

  }

  /*
   * Non recursive way
   */
  public static ArrayList<Integer> computeNthRow(int n) {

    if (n <= 0)
      throw new IllegalArgumentException("The nth row value must > 0");

    ArrayList<Integer> prevRow = new ArrayList<Integer>();
    prevRow.add(1);
    int len = 1;

    for (int i = 2; i <= n; i++) {
      ArrayList<Integer> nextRow = new ArrayList<Integer>();
      nextRow.add(1);
      for (int j = 1; j < prevRow.size(); j++)
        nextRow.add(prevRow.get(j) + prevRow.get(j - 1));
      nextRow.add(1);
      prevRow = nextRow;
    }
    return prevRow;

  }

}
