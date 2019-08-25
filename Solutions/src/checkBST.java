
/*
 * Problem: Check if a binary Tree is a BST Tree
 * Constraints: 0 < data < 10^4
 * Assumption: No duplicate in the tree
 * Time Complexity: O(n)
 */

public class checkBST {
  public boolean isBSTHelper(Node root, int min, int max) {
    if (root == null) {
      return true;
    } else if (root.data > min && root.data < max && isBSTHelper(root.left, min, root.data)
        && isBSTHelper(root.right, root.data, max)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean checkBSTFun(Node root) {
    return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}