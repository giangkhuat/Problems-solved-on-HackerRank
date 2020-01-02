import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingRoomsII {
  /*
   * When a room is taken, the room can not be used for anther meeting until the
   *  current meeting is over. 
   * As soon as the current meeting is finished, the room can be used for another meeting.
   *  We can sort the meetings by start timestamps and sequentially assign each meeting to a room. 
   *  Each time when we assign a room for a meeting, we check if any meeting is finished so that the room can be reused. 
   *  In order to efficiently track the earliest ending meeting, we can use a min heap. 
   *  Whenever an old meeting ends before a new meeting starts, we reuse the room (i.e., do not add more room).
   *  Otherwise, we need an extra room (i.e., add a room).
   */
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    
    Arrays.sort(intervals, (a,b)-> a.start - b.start);
    PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>((a, b)-> a.end - b.end); // the one with ending earliest would be on top
    // so we can merge
    
    minHeap.add(intervals[0]);
    
    for(int i = 1; i < intervals.length; i++) {
      // compare current interval with the earliest one ended in heap
      // if current starts after ending earliest one end
      // we can merge them
      Interval earliest = minHeap.poll();
      if (intervals[i].start >= earliest.end) {
        earliest.end = intervals[i].end;
      } else {
        minHeap.add(intervals[i]);
      }
      minHeap.add(earliest);
    }
    return minHeap.size();
    
  }

}
