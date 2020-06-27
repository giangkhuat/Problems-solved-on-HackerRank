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
class BinTreeConstructInAndPreorder {
   
    static int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length - 1;
        if (len == 0) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = recurse (preorder, inorder, 0, len);
        return root;
    }
    
    public static TreeNode recurse(int[] preorder, int[] inorder, int start,  int end) {
        if (start > end) {
            return null;
        }
        System.out.println(preIndex);
        TreeNode node = new TreeNode(preorder[preIndex++]);
        if (start == end) {
            return node;
        }
        int inIndex = search(node.val, inorder);
        //int inIndex = inIndex = search(preorder[preIndex], inorder);
        node.left = recurse(preorder, inorder, start, inIndex-1);
        node.right = recurse(preorder, inorder, inIndex+1, end);
        return node;
    }
    public static int search (int nextNode, int[] inorder) {
        int i ;
        for (i  = 0; i < inorder.length; i++) {
            if (inorder[i] == nextNode) {
                return i;
            }
        }
        return i;
    }
}