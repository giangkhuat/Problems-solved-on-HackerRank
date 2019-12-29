class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[][] matrix = new int[numCourses][numCourses]; // i -> j
    int[] indegree = new int[numCourses];

    // creating adjacenccy matrix and indegree list
    for (int i = 0; i < prerequisites.length; i++) {
      int ready = prerequisites[i][0];
      int pre = prerequisites[i][1];
      indegree[ready]++; // duplicate case
      matrix[pre][ready] = 1;
    }

    int count = 0;
    Queue<Integer> queue = new LinkedList();
    // if the  node has 0 degree, push in queue
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0)
        queue.offer(i);
    }
    
    // while queue still has vertices, 
    // if one course is popped, increment count the number of courses finish
    // for all course's neighbors, decrement the indegree 
    // check if the indegree == 0 to enqueu
    while (!queue.isEmpty()) {
      int course = queue.poll();
      count++;
      for (int i = 0; i < numCourses; i++) {
        if (matrix[course][i] != 0) {
          if (--indegree[i] == 0)
            queue.offer(i);
        }
      }
    }
    return count == numCourses;

  }
}
