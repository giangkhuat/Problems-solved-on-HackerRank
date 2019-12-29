/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
 * Idea: BFS traversal
 * At each iteration or layer, we check the last node and put it in visible values
 */
class binaryTreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> visibleNodes = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size ;i++) {
                TreeNode current = queue.remove();
                if (i == size -1) {
                    visibleNodes.add(current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                
            }
            
        }
        return visibleNodes;
        
    }
}