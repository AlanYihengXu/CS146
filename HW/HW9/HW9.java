package HW.HW9;

public class HW9 {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (p.val < currentNode.val && q.val < currentNode.val) {
                currentNode = currentNode.left;
            } else if (p.val > currentNode.val && q.val > currentNode.val) {
                currentNode = currentNode.right;
            } else {
                return currentNode;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HW9 tester = new HW9();
        TreeNode five = tester.new TreeNode(5);
        TreeNode nine = tester.new TreeNode(9);
        TreeNode eight = tester.new TreeNode(8, five, nine);
        TreeNode one = tester.new TreeNode(1);
        TreeNode three = tester.new TreeNode(3, one, null);
        TreeNode four = tester.new TreeNode(4, three, eight);
        System.out.println(tester.lowestCommonAncestor(four, three, one).val);
    }
}
