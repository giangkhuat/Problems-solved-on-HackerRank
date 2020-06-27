import java.util.LinkedList;
import java.util.Queue;

public class pointNodetoNext {
  /*
   * Populating next right pointers to the right node
   */
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> q = new LinkedList<Node>();
    Node prevNode = new Node();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      prevNode = null;
      for (int i = 0; i < size; i++) {
        Node tmp = q.remove();
        if (i == 0) {
          tmp.next = null;
        } else {
          tmp.next = prevNode;
        }
        prevNode = tmp;
        if (tmp.right != null) {
          q.add(tmp.right);
        }
        if (tmp.left != null) {
          q.add(tmp.left);
        }
      }
    }
    return root;
  }
}
