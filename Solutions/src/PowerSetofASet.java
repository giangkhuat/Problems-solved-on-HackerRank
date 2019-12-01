import java.util.ArrayList;

public class PowerSetofASet {
  public static void main(String[] args)  throws Exception
  { 

      String[] set = { "a", "b", "c" }; 

      int index = set.length - 1; 
      ArrayList<ArrayList<String> > result = getSubset(set, index); 
      System.out.println(result); 
  } 

  public static ArrayList<ArrayList<String>> getSubset(String[] sets, int index) {
    ArrayList<ArrayList<String>> allSubsets = new ArrayList<ArrayList<String>>();
    if (index < 0) {
      ArrayList<String> emptyLst = new ArrayList<String>();
      allSubsets.add(emptyLst);
      
    } else {
      // Case 1: 
      allSubsets = getSubset(sets, index -1);
      
      // Case 2: 
      String currentItem = sets[index];
      // subsets that created by concat subsets of [0...index-1] and sets[index]
      ArrayList<ArrayList<String>> recurSubsets = new ArrayList<ArrayList<String>>();
     // for each subset in the set of [0...index-1]
      for (ArrayList<String> subset : allSubsets) {
        ArrayList<String> newSubset = new ArrayList<String>(); 
        newSubset.addAll(subset); 
        newSubset.add(currentItem); 
        // add this new concat subset to the recurSubsets
        recurSubsets.add(newSubset);
      }
      // add all of them to the allSubsets
      allSubsets.addAll(recurSubsets);
    }
    
    return allSubsets;
    
  }
}
