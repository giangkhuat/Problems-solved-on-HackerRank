import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * Practice question for recursion
 * Time-Complexity: Proportional to n!
 * Idea:
 *   Base case: if list's size =1 or 0, return list
 *   Else 
 *      * Take the first element in the list
 *      * Create sublist with the rest elements of the list
 *      * Generate permutations on this smaller list (Breaking down the problem)
 *      * Combine each of this permutation with the first element taken out
 *    
 */
public class Permutations {
  public static List<List<Integer>> permute(List<Integer> permuteList, int size) {
    @SuppressWarnings("rawtypes")
    List<List<Integer>> returnList = new ArrayList();
    List<List<Integer>> remaining = new ArrayList();

    // Base Case
    if (size == 0 || size == 1) {
      returnList.add(permuteList);
    } else {
      // Recursive Case
      int num = permuteList.get(0);
      // iterateList sizes are n, n -1, n -2...1
      remaining = permute(permuteList.subList(1, size), size - 1);
      int len = remaining.size();
      // the outer loop will run 1, 2, 3,...n times
      // inner loop runs 1, 2, 3,...n times
      for (int i = 0; i < len; i++) {
        List<Integer> tmp = remaining.get(i);
        for (int j = 0; j < size; j++) {
          List<Integer> tmp2 = new ArrayList<Integer>(tmp);
          tmp2.add(j, num);
          returnList.add(tmp2);
        }
      }
    }
    return returnList;
  }


  public static void main(String[] args) throws Exception {

    BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> list = new ArrayList<Integer>();
    List<List<Integer>> permutList = new ArrayList<>();


    String[] strNums = bi.readLine().split("\\s");
    for (int i = 0; i < strNums.length; i++) {
      Integer x = Integer.parseInt(strNums[i]);
      list.add(x);
    }

    permutList = permute(list, list.size());
    Iterator<List<Integer>> it = permutList.iterator();
    
    while (it.hasNext()) {
      List<Integer> tmp = it.next();
      for (int i = 0; i < tmp.size(); i++) {
        System.out.print(tmp.get(i));
      }
      System.out.println();
    }

    bi.close();
  }
}
