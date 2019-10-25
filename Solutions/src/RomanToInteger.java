import java.util.HashMap;

class RomanToInteger {

  public HashMap<Character, Integer> createHashMap() {
    HashMap<Character, Integer> table = new HashMap<>();
    table.put('I', 1);
    table.put('V', 5);
    table.put('X', 10);
    table.put('L', 50);
    table.put('C', 100);
    table.put('D', 500);
    table.put('M', 1000);
    return table;
  }

  public boolean checkCondition(char tmp, char prev, int i, int len) {
    boolean passed = false;
    if (i + 1 <= len) {
      if (tmp == 'I' && (prev == 'V' || prev == 'X')) {
        passed = true;
      } else if (tmp == 'X' && (prev == 'L' || prev == 'C')) {
        passed = true;
      } else if (tmp == 'C' && (prev == 'D' || prev == 'M')) {
        passed = true;
      }
    }
    return passed;
  }

  public int romanToInt(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }

    // put in all possible characters in a hashmap
    HashMap<Character, Integer> table = new HashMap<>();
    table = createHashMap();
    // read in character from right to left
    int len = s.length() - 1;
    int sumSofar = 0;
    char prev = 'a';

    for (int i = len; i >= 0; i--) {
      char tmp = s.charAt(i);
      if (checkCondition(tmp, prev, i, len)) {
        sumSofar = sumSofar - table.get(tmp);
      } else {
        sumSofar = sumSofar + table.get(tmp);
      }
      prev = tmp;
    }
    return sumSofar;

  }
}
