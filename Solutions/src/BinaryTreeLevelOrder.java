import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> nodes = new ArrayList<List<Integer>>();

    if (root == null) {
      return nodes;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<Integer> nodesAtlevel;
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      nodesAtlevel = new ArrayList<Integer>();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.remove();

        nodesAtlevel.add(current.val);
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      nodes.add(nodesAtlevel);

    }
    return nodes;
  }

}
