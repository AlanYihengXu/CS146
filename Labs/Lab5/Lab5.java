package Labs.Lab5;
import java.util.ArrayList;

public class Lab5 {
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

    public boolean isValidBST(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        traverse(root, list);
        boolean inOrder = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).val > list.get(i).val) {
                inOrder = false;
                break;
            }
        }
        return inOrder;
    }

    private void traverse(TreeNode current, ArrayList<TreeNode> list) {
        if (current == null) {
            return;
        }
        traverse(current.left, list);
        list.add(current);
        traverse(current.right, list);
    }

    public static void main(String[] args) {
        Lab5 tester = new Lab5();
        TreeNode left = tester.new TreeNode(3, tester.new TreeNode(1), null);
        TreeNode right = tester.new TreeNode(8, tester.new TreeNode(5), tester.new TreeNode(9));
        TreeNode root = tester.new TreeNode(4, left, right);
        System.out.println(tester.isValidBST(root));
        left = tester.new TreeNode(2, tester.new TreeNode(3), tester.new TreeNode(4));
        right = tester.new TreeNode(8, tester.new TreeNode(5), tester.new TreeNode(6));
        root = tester.new TreeNode(1, left, right);
        System.out.println(tester.isValidBST(root));    
    }
}
