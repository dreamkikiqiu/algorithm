public class Coding004_WidthOfBinarySearchTree {

    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(){

        }
        public TreeNode(int value){
            this.value = value;
        }

        public TreeNode(int value,TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    //提交以下方法需注意
    //如果测试数据量过大， 需要修改MAX
    //用每次处理的一层优化bfs就非常容易实现。
    public static int MAX = 3001;
    public static TreeNode[] nq = new TreeNode[MAX];
    public static int[] iq = new int[MAX];
    public static int l,r;
    public static int widthOfBinaryTree(TreeNode head){
        int ans = 1;
        l = r = 0;
        nq[r] = head;
        iq[r++] = 1;
        while(l < r){
            int size = r - l;
            ans = Math.max(ans, iq[r - 1] - iq[l] + 1);
            while(size-- > 0){
                head = nq[l];
                int id = iq[l++];
                if(head.left != null){
                    nq[r] = head.left;
                    iq[r++] = id << 1;
                }
                if(head.right != null){
                    nq[r] = head.right;
                    iq[r++] = id << 1 + 1;
                }
            }
        }
        return ans;
    }
}
