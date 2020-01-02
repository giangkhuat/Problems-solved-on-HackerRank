
public class shortestWordDistance {
  // if word1 != word2
  public static int shortestDistance(String[] words, String word1, String word2) {
    int index1 = -1, index2 = -1;
    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        index1 = i;
      } else if (words[i].equals(word2)) {
        index2 = i;
      }
      if (index1 != -1 && index2 != -1) {
        minDist = Math.min(minDist, Math.abs(index1 - index2));

      }
    }
    return minDist;
  }

  // if word1 == word2 is possible
  public static int shortestDistanceSameWord(String[] words, String word1, String word2) {
    int index1 = -1, index2 = -1;
    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {

      if (word1.equals(word2)) {
        if (words[i].contentEquals(word1)) {
          if (index1 > index2) {
            index2 = i;
          } else
            index1 = i;
        }
      } else {
        if (words[i].equals(word1)) {
          index1 = i;
        } else if (words[i].equals(word2)) {
          index2 = i;
        }
      }
      if (index1 != -1 && index2 != -1) {
        minDist = Math.min(minDist, Math.abs(index1 - index2));

      }
    }
    return minDist;
  }

}
