import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class Main {
  
  private class Package implements Comparable<Package> {
  String action = "";
  String assetType = "";
  String assetName  = "";
  int amount = 0;
  public Package (String act, String name, String type, int share) {
    action = act;
    assetType = type;
    assetName = name;
    amount = share;
  }
    
   @Override
        public int compareTo(Package o2) {
          if (assetName.compareTo(o2.assetName) == 0) {
            return assetType.compareTo(o2.assetType);
          } else {
            return assetName.compareTo(o2.assetName);
          }
        }
    
}
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      Main.matchBenchmark(line);
    }
  }
  
  public static void matchBenchmark(String input) {
    
    String[] splitCols = input.split("\\:");
    String[] portfolios = splitCols[0].split("\\|");
    String[] benchmarks = splitCols[1].split("\\|");
    ArrayList<Package> packages = new ArrayList<Package>();

    packages = produceMap(portfolios, benchmarks);
   
   Collections.sort(packages);
   printOut(packages);
   
  }
  
  
  /*
   * For each item in the benchmark packages
   *    Build a stringbuilder with the name and asset type by stringbuiler with each of them
   *    substring from the string builder to extract "Google,Stock" and 10
   *    Put the first part of the key of hashmap and value is the amount
   *    
   *    
   * For each item in the packages portfolio
   *    Do same thing, as split,
   *    Check if it contains in the benchmark, if not 
   *       => buy it, create new package return that
   *    If it does, check the amount 
   *        If amount portfolio < amount benchmark => Buy it 
   *        Else sell it , return package 
   */
  
  
  
  
  public static ArrayList<Package> produceMap(String[] portfolios, String[] benchmarks) {
    HashMap<StringBuilder, Integer> map = new HashMap<StringBuilder, Integer>;

    int portAmount = portfolios.length;
    for (int i = 0; i < portAmount; i++) {
      StringBuilder  phrase = new StringBuilder(portfolios[i]);
      int len = portfolios[i].length();
      StringBuilder key = new StringBuilder(phrase.substring(0, phrase.length() - 3));
      StringBuilder val = new StringBuilder(phrase.substring(phrase.length() - 2));
      map.put(key,Integer.parseInt(val.toString()));
    }   
    return producePackage(benchmarks, map);
    
  }
  
  public static ArrayList<Package> producePackage(String[] benchmarks, HashMap<StringBuilder, Integer> map) {
    ArrayList<Package> packages = new ArrayList<Package>;
    
    for (int i = 0; i < benchmarks.length; i++) {
      StringBuilder  phrase = new StringBuilder(benchmarks[i]);
      int len = benchmarks[i].length();
      StringBuilder key = new StringBuilder(phrase.substring(0, phrase.length() - 3));
      StringBuilder benchmark = new StringBuilder(phrase.substring(phrase.length() - 2));
      int benchAmount = Integer.parseInt(benchmark.toString());
      String[] benchPackage = key.toString().split(",");
      
      if (map.containsKey(key)) {   
        int mapAmount = map.get(key);
        // if portfolios amount < benchmark=> buy
        if ( mapAmount < benchAmount) {
          packages.add(new Main().new Package("BUY", benchPackage[0], benchPackage[1], benchAmount - mapAmount) ;
        } else {
          packages.add(new Main().new Package("SELL", benchPackage[0], benchPackage[1], mapAmount - benchAmount) ;
        }
      } else {
        packages.add(new Main().new Package("BUY", benchPackage[0], benchPackage[1], benchAmount) ;
      }
    }
    
    return packages;
  
  }
  
  
  
  
  
  public static Package determineBenchMark(String portfolio, String benchmark) {
    String[] portPackage = portfolio.split(",");
    String[] benchmarkPackage = benchmark.split(",");

    int portAmount = Integer.parseInt(portPackage[2]);
    int benchAmount = Integer.parseInt(benchmarkPackage[2]);
    
    
    if (portAmount < benchAmount) {
      return new Main().new Package("BUY", portPackage[0], portPackage[1], benchAmount - portAmount);
    } else if (portAmount > benchAmount) {
      return new Main().new Package("SELL", portPackage[0], portPackage[1],  portAmount - benchAmount);
    } else {
      return null;
    }
  }
  
  public static void printOut(ArrayList<Package> packages) {
    Iterator<Package> it = packages.iterator();
    while(it.hasNext()) {
      Package tmp = it.next();
      System.out.println(tmp.action + "," + tmp.assetName + "," + tmp.assetType + "," + tmp.amount);
    }
  }
  

}