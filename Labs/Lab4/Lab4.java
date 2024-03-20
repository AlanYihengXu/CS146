package Labs.Lab4;

public class Lab4 {
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

    public TreeNode invertTree(TreeNode root) {
        invertTreeRecurse(root);
        return root;
    }
    private void invertTreeRecurse(TreeNode current) {
        if (current == null) {
            return;
        }
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
        invertTreeRecurse(current.left);
        invertTreeRecurse(current.right);
    }

    public static void main(String[] args) {
        Lab4 tester = new Lab4();
        TreeNode left = tester.new TreeNode(2, tester.new TreeNode(3), tester.new TreeNode(4));
        TreeNode right = tester.new TreeNode(8, tester.new TreeNode(5), tester.new TreeNode(6));
        TreeNode root = tester.new TreeNode(1, left, right);
        System.out.println(root.val + " " + root.left.val + " " + root.right.val + " " + root.left.left.val + " " + root.left.right.val + " " + root.right.left.val + " " + root.right.right.val);
        tester.invertTree(root);
        System.out.println(root.val + " " + root.left.val + " " + root.right.val + " " + root.left.left.val + " " + root.left.right.val + " " + root.right.left.val + " " + root.right.right.val);
    }
}
