public class Coding005_DepthOfBinaryTree {

    //不要提交这个类
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    //二叉树的最大深度。
    // 测试链接 : https://leetcode.cn/problems/maximum-depth-of-binary-tree/
    public static int maxDepth(TreeNode head){
        return head == null?0: Math.max(maxDepth(head.left), maxDepth(head.right)) + 1;
    }

    //二叉树的最小深度。
    // 测试链接 : https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    //提交时修改函数名和内部递归函数名保持一致 -> minDepth1
    public static int minDepth1(TreeNode head){
        if(head == null){
            //当前树为空树，直接返回
            return 0;
        }
        //如果是叶子节点， 那么提供一层深度。
        if(head.left == null && head.right == null) {
            return 1;
        }
        //左子树的最小深度 初始为系统最大
        int lDepth = Integer.MAX_VALUE;
        //右子树的最小深度 初始为系统最大
        int rDepth = Integer.MAX_VALUE;

        //如果当前节点存在左子树， 那么递归调用。
        if(head.left != null){
            lDepth = minDepth1(head.left);
        }
        //如果当前节点存在右子树， 那么递归调用
        if(head.right != null){
            rDepth = minDepth1(head.right);
        }
        //结算以当前节点为根节点的最小深度。
        //比较左右子树的最小的深度出最小值 + 1。
        return Math.min(lDepth, rDepth) + 1;
    }
    //---------------------------解法2:二叉树的最小深度------------------
    //leetcode提交修改数据量记得更改
    public static int MAX = 10001;
    public static TreeNode[] queue = new TreeNode[MAX];
    public static int l,r;
    public static int minDepth2(TreeNode head){
        if(head == null) return 0;//空树

        l = r = 0;//重置
        queue[r++] = head;
        int ans = 1;
        while(l != r) {
            int size = r - l;
            while (size-- > 0) {
                head = queue[l++];
                if (head.left == null && head.right == null) {
                    return ans;
                }

                if (head.left != null) {
                    queue[r++] = head.left;
                }

                if (head.right != null) {
                    queue[r++] = head.right;
                }
            }
            ans++;
        }
        return ans;
    }
}
