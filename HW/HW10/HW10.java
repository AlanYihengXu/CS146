package HW.HW10;

import java.util.LinkedList;
import java.util.List;

public class HW10 {
    public class TreeNode {

        int val;
   
        TreeNode left;
   
        TreeNode right;
   
        TreeNode() {}
   
        TreeNode(int val) { this.val = val; }
   
        TreeNode(int val, TreeNode left, TreeNode right) {
   
            this.val = val;
   
            this.left = left;
   
            this.right = right;
   
        }
   
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> output = new LinkedList<List<Integer>>();
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.remove(0);
                level.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            output.add(level);
        }
        return output;
    }

    public static void main(String[] args) {
        HW10 tester = new HW10();
        TreeNode root = tester.new TreeNode(4, tester.new TreeNode(3, tester.new TreeNode(1), null), tester.new TreeNode(8, tester.new TreeNode(5), tester.new TreeNode(9)));
        List<List<Integer>> result = tester.levelOrder(root);
        System.out.println(result);

        root = null;
        result = tester.levelOrder(root);
        System.out.println(result);
    }
}
