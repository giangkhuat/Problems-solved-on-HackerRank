import java.util.*;
import java.io.*;

public class BinTreeHeight {
  /*
   * Time-complexity: O(n) (assuming tree is not balanced)
   */
  public static int height(Node root) {
    // Write your code here.
    if (root.left == null && root.right == null) {
      return 0;
    } else if (root.left == null && root.right != null) {
      return 1 + height(root.right);
    } else if (root.left != null && root.right == null) {
      return 1 + height(root.left);
    } else {
      return 1 + Math.max(height(root.left), height(root.right));
    }
  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    int height = height(root);
    System.out.println(height);
  }
}
