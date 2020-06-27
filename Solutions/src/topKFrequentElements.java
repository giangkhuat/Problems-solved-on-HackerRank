import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class topKFrequentElements {

  /*
   * First solution: Using HashMap
   */
  
  /*
  public class Pair {
    int num = 0;
    int time = 0;

    public Pair(int a, int b) {
      num = a;
      time = b;
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, (a, b) -> a.time - b.time);
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      int tmp = nums[i];
      if (!map.containsKey(tmp)) {
        map.put(tmp, 1);
      } else {
        map.put(tmp, map.get(tmp) + 1);

      }


    }

    for (Map.Entry<Integer, Integer> sample : map.entrySet()) {
      System.out.println("key " + sample.getKey() + ": " + sample.getValue());
    }


    for (Map.Entry<Integer, Integer> sample : map.entrySet()) {

      if (pq.size() >= k) {
        System.out.println("queue num: " + sample.getKey() + " : " + sample.getValue() + " times");
        if (sample.getValue() > pq.peek().time) {
          pq.poll();
          System.out.println("removing");
          Pair newPair = new Pair(sample.getKey(), sample.getValue());
          pq.add(newPair);
        }
      } else {
        System.out
            .println("Adding queue num: " + sample.getKey() + " : " + sample.getValue() + " times");
        Pair extraPair = new Pair(sample.getKey(), sample.getValue());
        pq.add(extraPair);
      }
    }

    Iterator<Pair> itr = pq.iterator();
    int[] freqLst = new int[k];
    int j = 0;
    while (itr.hasNext() && j < k) {
      Pair freqNum = itr.next();
      freqLst[j] = freqNum.num;
      j++;
      // System.out.println("queue num: " + freqNum.num + " : " + freqNum.time + " times");
    }
    return freqLst;
  }
  */
  
  /*
   * Secon solution: quickselect
   * Time complexity: O(n)
   *  Worst case: O(n^2)
   *  
   */

  static int[] unique;
  static Map<Integer, Integer> count;

  public static void swap(int a, int b) {
    int tmp = unique[a];
    unique[a] = unique[b];
    unique[b] = tmp;
  }

  public static int partition(int low, int hi) {
    int pivot = unique[hi];
    // return frequency
    int pivot_freq = count.get(pivot);
    // start partition at low bound
    int partIndex = low;

    for (int i = low; i <= hi; i++) {
      // get frequency
      int tmp_freq = count.get(unique[i]);
      if (tmp_freq < pivot_freq) {
        swap(i, partIndex);
        partIndex++;
      }
    }
    swap(partIndex, hi);
    return partIndex;
  }
  
  public static void quickSelect(int low, int hi, int k_smallest) {
    // sort the array such that kth less frequent is on the left
    if (low == hi) {
      return;
    }
    int pivotIndex = partition(low, hi);
    if (k_smallest == pivotIndex) {
      return;
    } else if (k_smallest < pivotIndex) {
      // go left because our top k most frequently elements can also be to the left of pivot index
      quickSelect(low, pivotIndex - 1, k_smallest);
    } else {
      // go right
      quickSelect(pivotIndex + 1, hi, k_smallest);
    }
  }
  
  public int[] topKFrequent(int[] nums, int k) {
    // build hashmap of numbers in array and their frequencies
    count = new HashMap<>();
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    // create array of unique elements
    int len = count.size();
    int i = 0;
    unique = new int[len];
    for (int num : count.keySet()) {
      unique[i++] = num;
    }

    // quickselect to separate sort array unique based on the frequencies values in the count
    // hashmap
    quickSelect(0, len - 1, len - k);
    // Return top k frequent elements
    return Arrays.copyOfRange(unique, len - k, len);
  }
  

}
