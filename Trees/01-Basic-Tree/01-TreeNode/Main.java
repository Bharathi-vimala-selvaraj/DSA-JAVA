class Main {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        System.out.println(root.val);
        System.out.println(root.left);
        System.out.println(root.right);
    }
}
