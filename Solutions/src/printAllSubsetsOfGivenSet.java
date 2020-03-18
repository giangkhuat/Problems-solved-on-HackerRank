
public class printAllSubsetsOfGivenSet {
  static int[] givenArr = {1, 2, 3};

  public static void generateSets(int[] arr, int index) {
    if (index == arr.length - 1) {
      //if we dont include it
      arr[index]  = 0;
      printSet(arr);
      // if we do include it
      arr[index] = 1;
      printSet(arr);
      return;
    } else {
      // recursive case
      arr[index] = 0;
      generateSets(arr, index+1);
      arr[index] = 1;
      generateSets(arr, index+1);
    }

  public static void printSet(int[] arr) {
    System.out.print(" { ");
    boolean isNull = true;
    for (int i = 0; i < givenArr.length; i++) {
      if (arr[i] == 1) {
        System.out.print(givenArr[i] + "");
        isNull = false;
      }
    }
    if (isNull == false) {
      System.out.print("}");
      System.out.print("  ");
    }

    if (isNull) {
      System.out.print("Empty");
      System.out.print("} ");
    }
  }

}
