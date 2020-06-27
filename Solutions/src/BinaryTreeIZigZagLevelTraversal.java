import java.util.LinkedList;
import java.util.List;


/*
 * Idea: Linked List data structure allow add first and add last instead of arrayList
 */
public class BinaryTreeIZigZagLevelTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<List<Integer>> lst = new LinkedList<>();
    if (root == null) {
      return lst;
    }

    queue.add(root);
    boolean addFirst = false; // left to right

    while (!queue.isEmpty()) {
      int size = queue.size();
      LinkedList<Integer> subLst = new LinkedList<Integer>();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.remove();
        if (!addFirst) {
          subLst.add(current.val);
        } else {
          subLst.addFirst(current.val);
        }
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      addFirst = !addFirst;
      lst.add(subLst);
    }

    return lst;
  }
}
