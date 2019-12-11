import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class mergeIntervals {
  public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1)
      return intervals;

    Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));

    List<int[]> result = new ArrayList<>();
    int[] newInterval = intervals[0];

    result.add(newInterval);

    /*
     * If overlap, we change the upperbound
     * Else we move the pointer to the current interval
     * Add that interval
     */
    for (int[] interval : intervals) {
      if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
        newInterval[1] = Math.max(newInterval[1], interval[1]);
      else { // Disjoint intervals, add the new interval to the list
        newInterval = interval;
        result.add(newInterval);
      }
    }
    int size = result.size();
    int[][] returnArr = new int[size][2];

    for (int i = 0; i < size; i++) {
      returnArr[i] = result.get(i);
    }

    return returnArr;
  }
}
