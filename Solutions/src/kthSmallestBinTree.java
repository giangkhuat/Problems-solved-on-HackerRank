/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class kthSmallestBinTree {
  /*
   * First method: O(n) time + O(n) space
    public int kthSmallest(TreeNode root, int k) {
         List<Integer> lst = new ArrayList<>();
         traverse(lst, root);
         return lst.get(k-1);
        
    }
    public static void traverse(List<Integer> lst, TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || s.size() > 0) {
            while (tmp != null) {
                s.push(tmp);
                tmp = tmp.left;
            }
            tmp = s.pop();
            lst.add(tmp.val);
            tmp = tmp.right;
        }
    }
    */
  /* Second O(H+K) time, O(h) space
   * */
  static int counter = 0;
  
  public int kthSmallest(TreeNode root, int k) {
       //List<Integer> lst = new ArrayList<>();
       int ans = traverse( root, k);
      counter = 0;
       return ans;
      
  }
  public static int traverse( TreeNode root, int k) {
      Stack<TreeNode> s = new Stack<>();
      TreeNode tmp = root;
      while (tmp != null || s.size() > 0) {
          while (tmp != null) {
              s.push(tmp);
              tmp = tmp.left;
          }
          tmp = s.pop();
          counter++;
          if (counter == k) {
              return tmp.val;
          }
          tmp = tmp.right;
      }
      return tmp.val;
  }
}