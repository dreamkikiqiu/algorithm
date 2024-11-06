import java.util.Arrays;

// 验证搜索二叉树
// 测试链接 : https://leetcode.cn/problems/validate-binary-search-tree/
public class Coding017_ValidateBinarySearchTree {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    //解法一：中序遍历非递归
    public static int MAXN = 10001;

    public static TreeNode[] stack = new TreeNode[MAXN];

    public static int r;
    // 提交时改名为 -> isValidBST
    public static boolean isValidBST1(TreeNode head){
        if(head == null){
            return true;
        }
        //pre记录中序前驱节点
        TreeNode pre = null;
        //重置
        r = 0;
        while(r > 0 || head != null){
            //复用head
            if(head != null){
                stack[r++] = head;
                head = head.left;
            }
            else{
                                head = stack[--r];
                //第一次pre为null 不作比较
                //后几次严格比较当前 pre.val < head.val
                if(pre != null && pre.val >= head.val){
                    return false;
                }
                pre = head;
                head = head.right;
            }
        }
        return true;
    }
    //---------------解法2--------------------
//    public static long min,max
//    public static boolean isValidBST2(TreeNode head){
//        if()
//    }

   
}
